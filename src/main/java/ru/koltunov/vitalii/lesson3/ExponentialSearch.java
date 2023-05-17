package ru.koltunov.vitalii.lesson3;

import java.util.Scanner;

public class ExponentialSearch {
    public static void main(String[] args) {
        scannerTest();
    }

    public static void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[scanner.nextInt()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }
        int search = scanner.nextInt();
        if (exponentialSearch(ints, search)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void simpleTest() {
        int[] ints = new int[]{-100, -86, -60, -43, -37, -27, -17, -1, 16, 26};
        int search = 200;
        if (exponentialSearch(ints, search)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean exponentialSearch(int[] ints, int search) {
        int p = 0;
        while ((int) Math.pow(2, p) < ints.length && search >= ints[(int) Math.pow(2, p)]) {
            p++;
        }
        int left = (int) Math.pow(2, (p - 1));
        int right = Math.min((int) Math.pow(2, p), ints.length - 1);
        return binarySearch(ints, left, right, search);
    }
    private static boolean binarySearch(int[] ints, int left, int right, int search) {
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
