package uebungen.uebung2;

public class ContainerException extends Exception {
    public ContainerException(Member m){
        super("Das Member-Objekt mit der ID "+ m.getID() +"ist bereits vorhanden!");
    }
}
