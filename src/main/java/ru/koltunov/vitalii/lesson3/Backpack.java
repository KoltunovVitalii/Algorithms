package ru.koltunov.vitalii.lesson3;

import java.util.Scanner;

public class Backpack {
    public static void main(String[] args) {
//        simpleTest();
        scannerTest();
    }

    public static void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        int maxKg = scanner.nextInt();
        int[] ints = new int[scanner.nextInt()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }
        backpack(ints, maxKg);
    }

    private static void simpleTest() {
        int maxKg = 100;
        int[] ints = new int[]{31, 35, 46, 49, 54, 79, 82, 93, 99, 99};
        backpack(ints, maxKg);
    }

    private static void backpack(int[] ints, int maxKg) {
        sort(ints);
        int maxCount = 0;
        int sumWeight = 0;
        int maxElem = 0;
        for (int anInt : ints) {
            if (sumWeight + anInt <= maxKg) {
                sumWeight += anInt;
                maxCount++;
                maxElem = anInt;
            }
        }
        sumWeight-=maxElem;
        for (int anInt : ints) {
            if (sumWeight + anInt <= maxKg) {
                maxElem = anInt;
            }
        }
        System.out.println(maxCount + " " + (sumWeight+maxElem));
    }


    public static void sort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = i + 1; j < ints.length; j++)
                if (compare(ints[i], ints[j])) {
                    int r = ints[i];
                    ints[i] = ints[j];
                    ints[j] = r;
                }
        }
    }

    static boolean compare(int x, int y) {
        return x > y;
    }
}
