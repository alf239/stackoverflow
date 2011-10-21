package org.acm.afilippov.stacko;

public class Test {
    public static void main(String[] args) {
        Icmp test = new Icmp();
    }

    public static interface Cmp {
        public int cmp(Object x, Object y);
    }

    static class Icmp implements Cmp {
        public int cmp(Object o1, Object o2) {
            int i1 = ((Integer) o1).intValue();
            int i2 = ((Integer) o2).intValue();

            if (i1 < i2)
                return -1;
            else if (i1 == i2)
                return 0;
            else
                return 1;
        }
    }
}