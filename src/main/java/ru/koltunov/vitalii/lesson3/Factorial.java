package ru.koltunov.vitalii.lesson3;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        simpleTest();
//        scannerTest();
    }
    public static void simpleTest() {
        int x = 15;
        int factorialX = factorialX(x);
        System.out.println(factorialX);
    }

    public static void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        int factorialX = factorialX(scanner.nextInt());
        System.out.println(factorialX);
    }


    public static int factorialX(int x) {
        int count = x + 1;
        int[] factorial = new int[count];
        factorial[0] = 1;
        factorial[1] =1;
        int result = 0;
        for (int i = 2; i < count; i++) {
            factorial[i] = factorial[i - 1] * i;
            result = factorial[i];
        }
        return result;
    }
}
