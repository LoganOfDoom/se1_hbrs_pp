package uebungen.uebung1.view;


import uebungen.uebung1.control.Host;

public class Client {

    /*
     * Methode zur Ausgabe einer Zahl auf der Console (auch bezeichnet als CLI, Terminal)
     */
    public void display(int aNumber) {
        // In dieser Methode soll die Methode translateNumber
        // mit dem übergegebenen Wert der Variable aNumber
        // aufgerufen werden.
        //
        // Strenge Implementierung gegen das Interface Translator gewuenscht!


        System.out.println("Das Ergebnis der Berechnung: " +
                Host.translator(aNumber));

    }

}





