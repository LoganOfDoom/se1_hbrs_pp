package org.hbrs.se1.ws22.uebung4;


import org.hbrs.se1.ws22.uebung2.*;
import org.hbrs.se1.ws22.uebung3.PersistenceException;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws ContainerException, PersistenceException, IOException {
        Scanner sc = new Scanner(System.in);
        Container c = Container.createContainer();
        System.out.println("Projektleiter Eingaben");
        while(true){
            String[] params = sc.nextLine().split(" ");
            switch(params[0]){
                case "enter":
                    if(params[1].matches(".*[0-9].*") || params[2].matches(".*[0-9].*")){
                        throw new IllegalArgumentException("Keine Zahlen in Namen!");
                    }
                    ConcreteMember m = new ConcreteMember();

                    m.setVorname(params[1]);
                    m.setNachname(params[2]);
                    m.setPid(Integer.valueOf(params[3]));
                    m.setRolle(params[4]);
                    m.setAbteilung(params[5]);

                    for (int i = 6; i < params.length; i+=2)

                        m.setExpert(params[i], params[i + 1]);
                    c.addMember(m);
                    break;
                case "store":
                    c.store();
                    break;
                case "load":

                    if(params[1] == "merge"){
                        for(Member mem : c.getCurrentList())
                            c.addMember(mem);
                    }else if(params[1] == "force"){
                        c.load();
                    }else{
                        System.out.println("Unbekannter Parameter: " + params[1]);
                    }
                    break;
                case "dump":

                    System.out.println(sortList(c.getCurrentList()));
                    break;
                case "search":
                    ArrayList<Member> members = c.getCurrentList();
                    ArrayList<Member> membersMitExpertise = new ArrayList<>();

                    for(int i = 0; i < members.size(); i++){
                        for(int j = 0; j < members.get(i).numExpertisen(); j++){
                            if(members.get(i).getExpertise(j).equals(params[1]))
                                membersMitExpertise.add(members.get(i));
                        }
                    }

                    if(membersMitExpertise.size() == 0)
                        System.out.println("Nichts gefunden!");
                    else
                        System.out.println(sortList(membersMitExpertise));

                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "help":
                    System.out.println("Gültige Befehle:\nenter\nstore\nload\ndump\nsearch\nexit\nhelp");
                    break;
                default:
                    System.out.println("Ungültiger Befehl: " + params[0]);
                    System.out.println("Gebe help ein um alle Befehle anzuzeigen.");
                    break;
            }
        }


    }

    private static ArrayList<Member> sortList(ArrayList<Member> list){
        return (ArrayList<Member>) list.stream().sorted(Comparator.comparingInt(Member::getID)).collect(Collectors.toList());
    }

}