package org.hbrs.se1.ws22.uebung3;

import org.hbrs.se1.ws22.uebung2.Container;
import org.hbrs.se1.ws22.uebung2.ContainerException;

public class Main {

    public static void main(String[] args) throws ContainerException {
        Container c = Container.createContainer();
        Client.addMember(c, 20);
    }

}
