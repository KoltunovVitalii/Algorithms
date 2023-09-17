package ru.koltunov.vitalii.heap;

/*
ShiftUP(index) -- поднимает элемент с индексом index вверх, пока он больше родительского.

ShiftDown(index) -- опускает элемент с индексом index вниз, пока он меньше дочернего.

GetMax() -- возвращающий наибольший элемент в Куче.

PopMax() -- удаляющий наибольший элемент Кучи (поддержание Кучи должно быть корректно); Если Куча пуста ничего не делать

Push(value) -- добавляющий элемент value в Кучу

MakeHeap(array) -- строящий из массива array Кучу (и сохраняет ее в экземпляр класса), метод ничего не возвращает.

IsEmpty() -- возвращает TRUE, если Куча пуста и FALSE иначе. (это не строковые данные, а именно bool-евский тип данных)
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static java.util.Collections.swap;

public class Heap {


    public static void main(String[] args) {
        simpleTest();
        scannerTest();
    }

    public static void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[scanner.nextInt()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }

    }

    private static void simpleTest() {
        int[] ints = new int[]{-100, -86, -60, -43, -37, -27, -17, -1, 16, 26};

    }

    private void shiftUP(int index) {
//        while (index > 0) {
//            int indexParent = (index - 1) / 2;
//            if ()
//        }

    }

    private void shiftDown(int index) {

    }

    private int getMax() {
        return 0;
    }

    private void popMax() {

    }

    private void push(int value) {

    }

    private int[] makeHeap(int[] array) {
        int[] result = new int[array.length];
        return result;
    }

    private boolean isEmpty() {
        return false;
    }

}
