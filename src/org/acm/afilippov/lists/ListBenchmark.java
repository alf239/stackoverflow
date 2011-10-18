package org.acm.afilippov.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import static java.util.Collections.addAll;

/**
 * @author alf
 */
public class ListBenchmark {
    public static final int N = 6000;
    public static final int M = 3000;

    private static Integer[] listJoin(Integer[]... src) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        for (Integer[] integers : src) {
            addAll(result, integers);
        }
        return result.toArray(new Integer[result.size()]);
    }

    private static Integer[] arrayJoin(Integer[]... src) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer[] integers : src) {
            addAll(result, integers);
        }
        return result.toArray(new Integer[result.size()]);
    }

    private static Integer[] preAllocatedArrayJoin(Integer[]... src) {
        int len = 0;
        for (Integer[] ints : src) {
            len += ints.length;
        }
        ArrayList<Integer> result = new ArrayList<Integer>(len);
        for (Integer[] integers : src) {
            addAll(result, integers);
        }
        return result.toArray(new Integer[result.size()]);
    }

    private static int sum(Integer[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static Integer[][] sampleData() {
        Random r = new Random();
        Integer[][] result = new Integer[N][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Integer[r.nextInt(M)];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = r.nextInt();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long totalsum = 0;
        for (int i = 0; i < 1000; i++) {
            final Integer[][] ints = sampleData();

            final long t1 = System.currentTimeMillis();
            final Integer[] integers1 = listJoin(ints);
            System.out.print(System.currentTimeMillis() - t1);
            System.out.print("\t");

            final long t2 = System.currentTimeMillis();
            final Integer[] integers2 = arrayJoin(ints);
            System.out.print(System.currentTimeMillis() - t2);
            System.out.print("\t");

            final long t3 = System.currentTimeMillis();
            final Integer[] integers3 = preAllocatedArrayJoin(ints);
            System.out.print(System.currentTimeMillis() - t3);
            System.out.print("\n");

            System.gc();
            System.gc();

            totalsum += sum(integers1);
            totalsum += sum(integers2);
            totalsum += sum(integers3);
        }
        System.out.println("total sum = " + totalsum);
    }
}
