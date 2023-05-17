package ru.koltunov.vitalii.lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        scannerTest();
    }

    public static void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] res = fibonacciList(x);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    private static void simpleTest() {
        int x = 4;
        System.out.println(Arrays.toString(fibonacciList(x)));
    }

    public static int[] fibonacciList(int x) {

        int[] fibList = new int[x];
        fibList[0] = 0;
        fibList[1] = 1;
        for (int i = 2; i < x; i++) {
            fibList[i] = fibList[i - 2] + fibList[i - 1];
        }
        return fibList;
    }
}
