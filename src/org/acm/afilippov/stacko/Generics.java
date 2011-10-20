package org.acm.afilippov.stacko;

import java.awt.event.MouseEvent;
import java.util.EventObject;

public class Generics {
    static class A<E extends EventObject> {
    }

    static class B extends A<MouseEvent> {

    }

    public static void main(String[] args) {
        System.out.println(B.class.getGenericSuperclass());
    }
}
