package org.acm.afilippov.stacko;

public class MyStack<E> {
    public static void main(String[] args) {
        Integer[] test = new MyStack<Integer>().test();
    }

    public E[] test() {
        return (E[]) (new Object[10]);
    }
}