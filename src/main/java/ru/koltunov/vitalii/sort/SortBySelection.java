package ru.koltunov.vitalii.sort;

import java.util.Arrays;
import java.util.Scanner;

public class SortBySelection {
    public static void main(String[] args) {
        scannerTest();
//        simpleTest();
    }
    public static void simpleTest() {
        int[] ints = new int[] {3, 7, 9, 1, 8, 6};
        System.out.println(Arrays.toString(ints));
        selectionSort(ints);
        System.out.println(Arrays.toString(ints));
    }
    public static void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] ints = new int[x];
        for (int i = 0; i < x; i++) {
            ints[i] = scanner.nextInt();
        }
        selectionSort(ints);
        for (int i = 0; i < x; i++) {
            System.out.println(ints[i]);
        }
    }

    private static void selectionSort(int[] ints) {
        for (int i = 0; i < ints.length ; i++) {
            int extInx = i;
            int extreme = ints[extInx];
            for (int j = i + 1; j < ints.length; j++)
                if (compare(extreme, ints[j])) {
                    extInx = j;
                    extreme = ints[extInx];
                }
            int r = ints[i];
            ints[i] = ints[extInx];
            ints[extInx] = r;
        }
    }
    static boolean compare (int x, int i) {
        return x <= i;
    }
}

