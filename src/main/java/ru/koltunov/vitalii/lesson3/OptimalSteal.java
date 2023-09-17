package ru.koltunov.vitalii.lesson3;

import java.util.Scanner;

public class OptimalSteal {
    public static void main(String[] args) {
//        simpleTest();
//        scannerTest();
    }

    public static void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        int maxKg = scanner.nextInt();
        int maxCount = scanner.nextInt();
        int[][] ints = new int[maxCount][maxKg];
    }

    private static void simpleTest() {
        int maxKg = 20;
        int[][] ints = new int[][]{{457, 12}, {759, 1}, {901, 4}, {645, 12}, {516, 8}, {182, 17}};
//        optimalSteal(ints, maxKg);
    }

//    private static void optimalSteal(int[][] ints, int maxKg) {
//        int[] arr = new int[ints.length];
//
//        sort(ints);
//        int maxCount = 0;
//        int sumWeight = 0;
//        int maxElem = 0;
//        for (int anInt : ints) {
//            if (sumWeight + anInt <= maxKg) {
//                sumWeight += anInt;
//                maxCount++;
//                maxElem = anInt;
//            }
//        }
//        sumWeight-=maxElem;
//        for (int anInt : ints) {
//            if (sumWeight + anInt <= maxKg) {
//                maxElem = anInt;
//            }
//        }
//        System.out.println(maxCount + " " + (sumWeight+maxElem));
//    }

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
