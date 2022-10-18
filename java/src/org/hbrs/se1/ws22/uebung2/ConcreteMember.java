package org.hbrs.se1.ws22.uebung2;

public class ConcreteMember implements Member{

    private static Integer number = 0;
    private Integer id;
    private String name;

    public ConcreteMember(){
        number++;
        id = number;

    }
    @Override
    public Integer getID() {
        return this.id;
    }



    public String toString(){
        return "ID = "+getID() + " " +name;
    }
}
