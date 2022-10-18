package org.hbrs.se1.ws22.uebung1.control;

public class Host {

    public static String translator(int aNumber) {
        Translator trans = new GermanTranslator();
        return trans.translateNumber(aNumber);
    }

}
