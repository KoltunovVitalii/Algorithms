package ru.koltunov.vitalii.sort;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {

//        simpleTest();
        scannerTest();
    }


    private static void simpleTest() {
        int[] a = new int[]{29, -18, 24, -15, 14, 37, 9, 6, -6, -3};
        System.out.println(Arrays.toString(a));
        System.out.println();
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] a = new int[x];
        for (int i = 0; i < x; i++) {
            a[i] = scanner.nextInt();
        }
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

//    public static void sort(int[] arr) {
//        int[] output = new int[arr.length];
//        int k = 200;
//        int[] freq = new int[k + 1];
//        for (int i : arr) {
//            freq[i]++;
//        }
//        int total = 0;
//        for (int i = 0; i < k + 1; i++) {
//            int oldCount = freq[i];
//            freq[i] = total;
//            total += oldCount;
//        }
//        for (int i : arr) {
//            output[freq[i]] = i;
//            freq[i]++;
//        }
//        Arrays.setAll(arr, i -> output[i]);
//    }

    public static void sort(int[] array)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int element : array)
        {
            if (element < min)
            {
                min = element;
            }
            if (element > max)
            {
                max = element;
            }
        }
        int[] buckets = new int[max - min + 1];
        for (int element : array)
        {
            buckets[element - min]++;
        }
        int arrayIndex = 0;
        for (int i = 0; i < buckets.length; i++)
        {
            for (int j = buckets[i]; j > 0; j--)
            {
                array[arrayIndex++] = i + min;
            }
        }
    }
}