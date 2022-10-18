package org.hbrs.se1.ws22.uebung2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    Container c;
    Member m1, m2, m3;

    @BeforeEach
    void setup() throws ContainerException {
        c = new Container();
        m1 = new ConcreteMember();
        m2 = new ConcreteMember();
        m3 = new ConcreteMember();
        c.addMember(m1);
    }

    @Test
    void addMemberTest() throws ContainerException {
        c.addMember(m2);
        assertEquals(c.members.get(1), m2);
        assertThrows(ContainerException.class, () -> c.addMember(m2));
    }

    @Test
    void deleteMember() {
        assertEquals("Der Member mit der ID: " + m1.getID() + " wurde entfernt.", c.deleteMember(m1.getID()));
    }

    @Test
    void size() {
        assertEquals(1, c.size());
    }
}