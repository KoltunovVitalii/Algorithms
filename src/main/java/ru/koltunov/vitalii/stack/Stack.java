package ru.koltunov.vitalii.stack;


import java.util.Scanner;

class Stack {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        Stack array = new Stack();
        int requests = scanner.nextInt();
        for (int i = 0; i < requests; i++) {
            String cmd = scanner.next();
            if (cmd.equals("push")) {
                array.push(scanner.nextInt());
            }
            else if (cmd.equals("top")) {
                System.out.println(array.top());
            }
            else if (cmd.equals("pop")) {
                array.pop();
            }
            else if (cmd.equals("is_empty")) {
                if (array.is_empty()) {
                    System.out.println("Пуст");
                }
                else System.out.println("Не пуст");
            }
        }
    }
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int[] stack;

    public Stack(int capacity) {
        this.stack = new int[capacity];
        this.size = 0;
    }

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    private void resize() {
        int capacity = stack.length * 2;
        int[] newData = new int[capacity];
        System.arraycopy(this.stack, 0, newData, 0, stack.length);
        stack = newData;
    }

    private void pop() {
        int capacity = size--;
        int[] newData = new int[capacity];
        System.arraycopy(this.stack, 0, newData, 0, capacity);
        stack = newData;
    }

    private void push(int element) {
        if (size == stack.length) {
            resize();
        }
        stack[size++] = element;
    }
    private int top() {
        return stack[size - 1];
    }
    private boolean is_empty() {
        return this.size == 0;
    }

}