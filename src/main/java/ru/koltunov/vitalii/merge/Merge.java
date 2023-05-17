package ru.koltunov.vitalii.merge;

import java.util.Arrays;
import java.util.Scanner;

public class Merge {

    public static void main(String[] args) {
//        scannerTest();
        simpleTest();
    }

    public static void simpleTest() {
        int[] a = new int[]{-84, -43, -25, -13, -7, -7, 9, 31, 63, 99};
        int[] b = new int[]{-89, -83, -79, -23, -22, -10, 29, 54};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println();
        int[] result = mergeTwoSortedArraysNonDecreasing(a, b);
        System.out.println(Arrays.toString(result));

        int[] MYresult = MYmergeTwoSortedArraysNonDecreasing(a, b);
        System.out.println(Arrays.toString(MYresult));
    }

    public static void scannerTest() {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] a = new int[x];

        for (int i = 0; i < x; i++) {
            a[i] = scanner.nextInt();
        }
        int y = scanner.nextInt();
        int[] b = new int[y];
        for (int j = 0; j < y; j++) {
            b[j] = scanner.nextInt();
        }

        int[] result = MYmergeTwoSortedArraysNonDecreasing(a, b);
        for (int i : result) {
            System.out.println(i);
        }
    }


    static public int[] mergeTwoSortedArraysNonDecreasing(int[] a, int[] b) {
        int r = a.length + b.length;
        int[] result = new int[r];
        int iterA = 0;
        int iterB = 0;
        int resultInx = 0;
        while (iterA < a.length || iterB < b.length) {
            int number = 0;
            if (iterA >= a.length) {
                number = b[iterB++];
            } else if (iterB >= b.length) {
                number = a[iterA++];
            } else if (a[iterA] < b[iterB]) {
                number = a[iterA++];
            } else if (a[iterA] >= b[iterB]) {
                number = b[iterB++];
            }
            result[resultInx++] = number;
        }
        return result;
    }

    static public int[] MYmergeTwoSortedArraysNonDecreasing(int[] a, int[] b) {
        int r = a.length + b.length;
        int[] result = new int[r];
        int iterA = 0;
        int iterB = 0;
        while (iterA < a.length || iterB < b.length) {
            for (int n = 0; n < result.length; n++) {
                if (iterA >= a.length) {
                    result[n] = b[iterB];
                    iterB++;
                } else if (iterB >= b.length) {
                    result[n] = a[iterA];
                    iterA++;
                } else if (a[iterA] < b[iterB]) {
                    result[n] = a[iterA];
                    iterA++;
                } else if (a[iterA] >= b[iterB]) {
                    result[n] = b[iterB];
                    iterB++;
                }
            }
        }
        return result;
    }
}
