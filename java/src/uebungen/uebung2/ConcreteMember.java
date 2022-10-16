package uebungen.uebung2;

public class ConcreteMember implements Member{

    private static Integer number = 0;
    private Integer id;
    private String name;

    public ConcreteMember(String name){
        number++;
        id = number;
        this.name = name;
    }
    @Override
    public Integer getID() {
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "ID = "+getID() + " " +name;
    }
}
