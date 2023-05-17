package ru.koltunov.vitalii.stack;

//   9
//        1
//        2
//        +
//        3
//        *
//        10
//        2
//        :
//        +

import java.util.Scanner;

class RPN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RPN array = new RPN();
        int requests = scanner.nextInt();
        for (int i = 0; i < requests; i++) {
            String cmd = scanner.next();
            if (cmd.matches("[1-9][0-9]{0,2}")) {
                int x = Integer.parseInt(cmd);
                array.push(x);
            } else {
                int x = array.top();
                array.pop();
                int y = array.top();
                array.pop();
                if (cmd.matches("\\+")) {
                    int res = x + y;
                    array.push(res);
                }
                if (cmd.matches("\\-")) {
                    int res = y - x;
                    array.push(res);
                }
                if (cmd.matches("\\*")) {
                    int res = x * y;
                    array.push(res);
                }
                if (cmd.matches(":")) {
                    int res = y / x;
                    array.push(res);
                }
            }
        }
        System.out.println(array.top());
    }

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int[] stack;

    public RPN(int capacity) {
        this.stack = new int[capacity];
        this.size = 0;
    }

    public RPN() {
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
