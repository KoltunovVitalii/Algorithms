package ru.koltunov.vitalii.sort;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] ints = new int[x];
        for (int i = 0; i < x; i++) {
            ints[i] = scanner.nextInt();
        }

        for (int i = ints.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++)
                if (compare(ints[j], ints[j + 1])) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
        }
//        for (int i = 0; i < ints.length - 1; i++) {
//            for (int j = i + 1; j < ints.length; j++)
//                if (compare(ints[i], ints[j])) {
//                    int r = ints[i];
//                    ints[i] = ints[j];
//                    ints[j] = r;
//                }
//        }
        for (int i = 0; i < x; i++) {
            System.out.println(ints[i]);
        }
    }

    static boolean compare (int x, int y) {
        return x > y;
    }
}
