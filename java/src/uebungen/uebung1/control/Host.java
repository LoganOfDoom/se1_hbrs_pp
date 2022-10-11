package uebungen.uebung1.control;

public class Host {

    public static String translator(int aNumber) {
        Translator trans = new GermanTranslator();
        return trans.translateNumber(aNumber);
    }

}
