package org.hbrs.se1.ws22.uebung2;

import org.hbrs.se1.ws22.uebung3.*;

import java.io.IOException;
import java.util.ArrayList;

public class Container {
    ArrayList<Member> members = new ArrayList<Member>();
    private static final Container container = new Container();
    private static PersistenceStrategy ps;

   // private Member members[];
    public Container(){

    }

    public ArrayList<Member> getCurrentList() {
        return container.members;
    }

    public static Container createContainer() {
        container.ps = new PersistenceStrategyStream();
        return container;
    }

    public static Container createContainer(PersistenceStrategy ps){
        container.ps = ps;
        return container;
    }

    public void store() throws PersistenceException, IOException {
        ps.save(container.members);
    }

    public void load() throws PersistenceException {
        container.members = (ArrayList<Member>) ps.load();
    }


    public void addMember(Member member) throws ContainerException {
       /* if(members.contains(member)){
            throw new ContainerException(member);
        } */
        for(int i=0; i<members.size(); i++){
            if(members.get(i).getID() == member.getID()){
                throw new ContainerException(member);
            }
        }
        /*
        for(int i = 0; i<members.length; i++){
            members.contains()
            if(members[i].getID() == member.getID()){
                throw new ContainerException(member);
            }
        }
        */
        members.add(member);
    }

    public Member createMember(){
        ConcreteMember x = new ConcreteMember();
        return x;
    }

    public String deleteMember(Integer id){

        Member delMember = null;

        for(int i=0; i<members.size(); i++){
            if(members.get(i).getID() == id){
                delMember = members.get(i);
            }
        }
        if(delMember == null){
            return "Member existiert nicht.";
        } else {
            members.remove(delMember);
            return "Der Member mit der ID: " + delMember.getID() + " wurde entfernt.";
        }
    }

    public void dump(){
        members.forEach(Member -> System.out.println(Member.toString()));
        System.out.println("----------------------");
    }

    public int size(){
        return members.size();
    }
}
