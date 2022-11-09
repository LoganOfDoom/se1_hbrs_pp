package org.hbrs.se1.ws22.uebung2;

import org.hbrs.se1.ws22.uebung3.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Container {

    private ArrayList<Member> members = new ArrayList<>();
    private static final Container container = new Container();
    private static PersistenceStrategy ps;

    public void addMember(Member member) throws ContainerException {
        if (container.members.stream().filter(m -> m.getID() == member.getID()).count() > 0)
            throw new ContainerException(member);
        container.members.add(member);
    }

    private Container() {
        System.out.println("Container erstellt");
    }

    public static Container createContainer(){
        container.ps = new PersistenceStrategyStream();
        return container;
    }
    public static Container createContainer(PersistenceStrategy ps){
        container.ps = ps;
        return container;
    }

    public String deleteMember(Integer id) {
        if (container.members.stream().filter(m -> m.getID() == id).count() == 0)
            return "Es gibt keinen Member mit der ID " + id + " in dem Container!";
        container.members.remove(container.members.stream().filter(m -> m.getID() == id).findAny().get());
        return "Member mit der ID " + id + " wurde entfernt!";
    }

    public ArrayList<Member> getCurrentList() {
        return container.members;
    }

    public int size() {
        return container.members.size();
    }

    public void store() throws PersistenceException, IOException {
        ps.save(container.members);
    }

    public void store(List<Member> members) throws PersistenceException, IOException {
        ps.save(members);
    }

    public void load() throws PersistenceException {
        container.members = (ArrayList<Member>) ps.load();
    }

}