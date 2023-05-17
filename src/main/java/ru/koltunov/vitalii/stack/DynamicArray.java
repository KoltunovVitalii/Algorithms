package ru.koltunov.vitalii.stack;

//    Реализуйте класс динамический массив, имеющий методы:
//    push_back(element) - Добавляет элемент в конец массива. Работает амортизировано за O(1)
//    pop_back() - Удаляет элемент, находящийся в конце массива, а также возвращающий значение удаленного элемента
//    size() - Возвращает количество элементов в массиве.
//    capacity() - Возвращает число элементов, которое массив может содержать без выделения дополнительного пространства.
//    Также должен быть реализован метод взятия и изменения элемента по индексу - по [] - как у стандартного массива.
//На первой строке вводится число N - количество запросов, которые должен будет обработать массив.
//    На каждой из следующих N строк вводится запрос. Ниже приведены запросы и те ответы на них, которые должна дать программа.
//    Если вводится запрос "push_back", тогда на следующей строке необходимо считать <целое число>,
//    а затем вызвать метод добавления этого числа в конец массива.
//    Если вводится запрос "pop_back", программа должна вызвать метод удаления последнего элемента.
//    А на экран программа должна вывести значение удаленного элемента.
//    Если вводится запрос "size", программа должна вызвать метод size.
//    А на экран программа должна вывести количество элементов массива.
//    Если вводится запрос "index", тогда на следующей строчке должно вводится целое число,
//    которе означает индекс интересуемого элемента. В таком случае программа должна вывести значение интересуемого элемента.

import java.util.Scanner;

public class DynamicArray {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        DynamicArray array = new DynamicArray();
        int requests = scanner.nextInt();
        for (int i = 0; i < requests; i++) {
            String cmd = scanner.next();
            if (cmd.equals("push_back")) {
                array.push_back(scanner.nextInt());
            } else if (cmd.equals("pop_back")) {
                System.out.println(array.pop_back());
            } else if (cmd.equals("size")) {
                System.out.println(array.size());
            } else if (cmd.equals("index")) {
                System.out.println(array.getDatum(scanner.nextInt()));
            }
        }
    }
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int[] data;

    public DynamicArray(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    private void resize() {
        int capacity = data.length * 2;
        int[] newData = new int[capacity];
        System.arraycopy(this.data, 0, newData, 0, data.length);
        data = newData;
    }

    public int pop_back() {
        int capacity = data.length;
        int[] newData = new int[capacity];
        System.arraycopy(this.data, 0, newData, 0, data.length);
        data = newData;
        return data[--size];
    }

    public void push_back(int c) {
        if (size == data.length) {
            resize();
        }
        data[size++] = c;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.data.length;
    }

    public int getDatum(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of Stack bound " + size);
        }
        return data[index];
    }

    public void putDatum(int index, int datum) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of Stack bound " + size);
        }
        data[index] = datum;
    }
}
