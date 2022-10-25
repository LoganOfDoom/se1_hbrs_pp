package org.hbrs.se1.ws22.uebung3;

import org.hbrs.se1.ws22.uebung2.ConcreteMember;
import org.hbrs.se1.ws22.uebung2.Container;
import org.hbrs.se1.ws22.uebung2.ContainerException;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    Container c;
    ConcreteMember m1 = new ConcreteMember();
    ConcreteMember m2 = new ConcreteMember();


    @BeforeEach
    public void setup(){
        c = Container.createContainer();
    }

    @Test
    public void testNull() throws ContainerException {
        c = Container.createContainer(null);
        c.addMember(m1);
        assertThrows(NullPointerException.class, () -> c.store());
        assertThrows(NullPointerException.class, () -> c.load());
        c.deleteMember(m1.getID());
    }

    @Test
    public void testMongoDB() throws ContainerException {
        c = Container.createContainer(new PersistenceStrategyMongoDB());
        c.addMember(m1);
        assertThrows(UnsupportedOperationException.class, () -> c.store());
        assertThrows(UnsupportedOperationException.class, () -> c.load());
        c.deleteMember(m1.getID());
    }

    @Test
    public void testLoc(){
        PersistenceStrategyStream pss = new PersistenceStrategyStream("");
        c = Container.createContainer(pss);
        assertThrows(RuntimeException.class, () -> c.store());
        assertThrows(RuntimeException.class, () -> c.load());
    }

    @Test
    public void testSize() throws ContainerException, PersistenceException, IOException {
        c.addMember(m2);
        assertEquals(1, c.size());
        c.store();
        assertEquals("Der Member mit der ID: 6 wurde entfernt.", c.deleteMember(m2.getID()));
        c.deleteMember(m2.getID());
        assertEquals(0, c.size());
        c.load();
        assertEquals(1, c.size());
    }
}