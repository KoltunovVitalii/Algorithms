package ru.koltunov.vitalii.lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
//        simpleTest();
        scannerTest();
    }

    public static void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[scanner.nextInt()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }
        int search = scanner.nextInt();
        if (binarySearch(ints, search)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void simpleTest() {
        int[] ints = new int[]{-100, -86, -60, -43, -37, -27, -17, -1, 16, 26};
        int search = -43;
        if (binarySearch(ints, search)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean binarySearch(int[] ints, int search) {
        int left = 0;
        int right = ints.length;

        while ((right - left) > 1) {
            int mid = (right + left) / 2;
            if (search < ints[mid]) {
                right = mid;
            } else if (search > ints[mid]) {
                left = mid;
            } else return search == ints[mid];
        }
        return ints[left] == search || ints[right] == search;
    }
}
