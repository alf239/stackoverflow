package org.acm.afilippov.stacko;

public class VolatileExample implements Runnable {
    public static volatile boolean flag = true; // do not try this at home

    public void run() {
        long i = 0;
        while (flag) {
            if (i++ % 10000000000L == 0)
                System.out.println("Waiting  " + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new VolatileExample());
        thread.start();
        Thread.sleep(10000L);
        flag = false;
        long start = System.currentTimeMillis();
        System.out.println("stopping " + start);
        thread.join();
        long end = System.currentTimeMillis();
        System.out.println("stopped  " + end);
        System.out.println("Delay: " + ((end - start) / 1000L));
    }
}
