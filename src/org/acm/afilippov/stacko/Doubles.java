package org.acm.afilippov.stacko;

public class Doubles {
    public static void main(String[] args) {
        double v = 0;
        for (int i = 0; i < 100; i++)
            v += 0.01;
        final double w = 1;
        System.out.println("v = " + v);
        System.out.println("w = " + w);
        if (v - w != 0.0) {
            System.out.println("difference: " + (v - w));
        }
    }
}
