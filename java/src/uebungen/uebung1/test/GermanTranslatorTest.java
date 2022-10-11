package uebungen.uebung1.test;

import org.junit.jupiter.api.Test;
import uebungen.uebung1.control.GermanTranslator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GermanTranslatorTest {

    GermanTranslator gTrans = new GermanTranslator();


    @Test
    void gAEK_1(){
        assertEquals(10, "zehn");
    }

    @Test
    void uAEK_1(){
        int uAEK_1_number = -25;
        assertEquals("Uebersetzung der Zahl " + uAEK_1_number + " nicht möglich (Version: " + gTrans.version +")", gTrans.translateNumber(uAEK_1_number));
        uAEK_1_number = 0; //Grenzwert
        assertEquals("Uebersetzung der Zahl " + uAEK_1_number + " nicht möglich (Version: " + gTrans.version +")", gTrans.translateNumber(uAEK_1_number));
    }

    @Test
    void uAEK_2(){
        int uAEK_2_number = 129;
        assertEquals("Uebersetzung der Zahl " + uAEK_2_number + " nicht möglich (Version: " + gTrans.version +")", gTrans.translateNumber(uAEK_2_number));
        uAEK_2_number = 11; // Grenzwert
        assertEquals("Uebersetzung der Zahl " + uAEK_2_number + " nicht möglich (Version: " + gTrans.version +")", gTrans.translateNumber(uAEK_2_number));
    }

}
