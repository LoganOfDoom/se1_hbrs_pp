package org.hbrs.se1.ws22.uebung3;

import org.hbrs.se1.ws22.uebung2.ConcreteMember;
import org.hbrs.se1.ws22.uebung2.Container;
import org.hbrs.se1.ws22.uebung2.ContainerException;

public class Client {

    public static void addMember(Container c, int anzahl) throws ContainerException {
        for(int i = 0; i < anzahl; i++){
            c.addMember(new ConcreteMember());
        }

        MemberView.dump(c.getCurrentList());
    }
}
