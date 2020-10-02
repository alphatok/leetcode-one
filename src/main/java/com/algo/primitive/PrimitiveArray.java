package com.algo.primitive;

import java.awt.*;

public class PrimitiveArray {
    public static void main(String[] args) {
        // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
        int[] intArray = new int[]{1};
        System.out.println("intArray.getClass().getCanonicalName() = " + intArray.getClass().getCanonicalName());
        System.out.println("intArray.getClass().getName() = " + intArray.getClass().getName());
        System.out.println("intArray instanceof Object = " + intArray instanceof Object);

        long[] longArray = new long[]{1};
        System.out.println("longArray.getClass().getCanonicalName() = " + longArray.getClass().getCanonicalName());
        System.out.println("longArray.getClass().getName() = " + longArray.getClass().getName());
        System.out.println("longArray instanceof Object = " + longArray instanceof Object);

        try {
            int ia[][] = { {1, 2}, null };
            for (int[] ea : ia) {
                for (int e: ea) {
                    System.out.println(e);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

/*        try {
            Thread.sleep(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        int ia[][] = { {1,2}, null };
        int ja[][] = ia.clone();
        System.out.print((ia == ja) + " ");
        System.out.println(ia[0] == ja[0] && ia[1] == ja[1]);

        SystemColor[] cpa = new SystemColor[10];
        Color[] pa = cpa;
        System.out.println(pa[1] == null);
        try {
            pa[0] = new Color(1);
        } catch (ArrayStoreException e) {
            System.out.println(e);
        }
    }
}
