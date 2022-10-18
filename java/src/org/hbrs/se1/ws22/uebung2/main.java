package org.hbrs.se1.ws22.uebung2;

public class main {
    public static void main(String[] args) throws ContainerException {
        Container c1 = new Container();
        ConcreteMember m1 = new ConcreteMember();
        ConcreteMember m2 = new ConcreteMember();
        ConcreteMember m3 = new ConcreteMember();
        c1.addMember(m1);
        //c1.addMember(m1);  test ob exception funktioniert
        c1.addMember(m2);
        c1.addMember(m3);
        c1.dump();
        System.out.println(c1.size());
        c1.addMember(c1.createMember());
        c1.dump();
        System.out.println(c1.size());
        System.out.println(c1.deleteMember(3));
        System.out.println(c1.deleteMember(23)); //test ob "exception" funktioniert
        c1.dump();
        System.out.println(c1.size());
    }
}
