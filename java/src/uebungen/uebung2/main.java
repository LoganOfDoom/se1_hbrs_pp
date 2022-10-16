package uebungen.uebung2;

public class main {
    public static void main(String[] args) throws ContainerException {
        Container c1 = new Container();
        ConcreteMember m1 = new ConcreteMember("Sir Fritz von Kola");
        ConcreteMember m2 = new ConcreteMember("Lady Afri von Cola");
        ConcreteMember m3 = new ConcreteMember("Sachse Vita von Cola");
        c1.addMember(m1);
        c1.addMember(m2);
        c1.addMember(m3);
        c1.dump();
        System.out.println(c1.size());
        c1.addMember(c1.createMember("Lady Coca von Cola"));
        c1.dump();
        System.out.println(c1.size());
        c1.deleteMember(3);
        c1.dump();
        System.out.println(c1.size());
    }
}
