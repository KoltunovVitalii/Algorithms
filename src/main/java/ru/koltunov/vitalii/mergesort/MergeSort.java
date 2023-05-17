package ru.koltunov.vitalii.mergesort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        scannerTest();
    }

    public static void simpleTest() {
        int[] a = new int[]{66, -92, -90, 24, -62, 53, -11, 11, -25, -28};
        System.out.println(Arrays.toString(a));
        System.out.println();
        int[] result = mergeSort(a);
        System.out.println(Arrays.toString(result));
    }

    public static void scannerTest() {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] a = new int[x];
        for (int i = 0; i < x; i++) {
            a[i] = scanner.nextInt();
        }
        int[] result = mergeSort(a);
        for (int i : result) {
            System.out.println(i);
        }
    }


    public static int[] mergeSort(int[] arr) {
        return mergeSortRecursive(arr);
    }

    private static int[] mergeSortRecursive(int[] arr) {
        if (arr.length <= 1)
            return arr;
        int n = arr.length / 2;
        int[] left = new int[n];
        int[] right = new int[arr.length - n];
        System.arraycopy(arr, 0, left, 0, n);
        System.arraycopy(arr, n, right, 0, arr.length - n);
        left = mergeSortRecursive(left);
        right = mergeSortRecursive(right);
        return mergeTwoSortedArrays(left, right);
    }

    public static int[] mergeTwoSortedArrays(int[] left, int[] right) {
        int r = left.length + right.length;
        int[] result = new int[left.length + right.length];
        int leftInx = 0;
        int rightInx = 0;
        int resultInx = 0;
        while (leftInx < left.length || rightInx < right.length) {

            int number = 0;
            if (leftInx >= left.length) {
                number = right[rightInx++];
            } else if (rightInx >= right.length) {
                number = left[leftInx++];
            } else if (compare(left[leftInx], right[rightInx])) {
                number = left[leftInx++];
            } else {
                number = right[rightInx++];
            }
            result[resultInx++] = number;
        }
        return result;
    }
    static boolean compare (int x, int y) {
        return x > y;
    }
}

