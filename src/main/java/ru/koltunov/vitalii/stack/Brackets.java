package ru.koltunov.vitalii.stack;


import java.util.Arrays;
import java.util.Scanner;
class Brackets {

    public static void main(String[] args) {
        scannerTest();
    }

    public static void simpleTest() {
        System.out.println(checkParNew("([]){[()]}"));
        System.out.println(checkParNew("([)(]){[()]}"));
    }

    public static void scannerTest() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        if (checkParNew(string)) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }

    private static boolean checkParNew(String string) {
        final String open = "{([";
        final String close = "})]";
        Brackets brackets = new Brackets();
        char[] chars = string.toCharArray();
        for (char c : chars) {
            int openPos = open.indexOf(c);
            int closePos = close.indexOf(c);
            if (openPos >= 0) {
                brackets.push(c);
            }
            else if (closePos >= 0){
                if (brackets.is_empty())
                    return false;
                if (close.indexOf(c) != open.indexOf(brackets.top())) {
                    return false;
                }
                brackets.pop();
            }
        }
        return brackets.is_empty();
    }
    private static boolean checkPar(String string) {
        Brackets bracketsOpen = new Brackets();
        Brackets bracketsClose = new Brackets();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                bracketsOpen.push(chars[i]);
            } else if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
                bracketsClose.push(chars[i]);
            }
        }
        while (!bracketsOpen.is_empty() && !bracketsClose.is_empty()) {
            if (bracketsOpen.top() == '(' && bracketsClose.top() == ')' || bracketsOpen.top() == '{'
                    && bracketsClose.top() == '}' || bracketsOpen.top() == '[' && bracketsClose.top() == ']') {
                bracketsOpen.pop();
                bracketsClose.pop();
            }
        }
        return bracketsOpen.is_empty() && bracketsClose.is_empty();
    }

    //================================= stack ==========================================
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private char[] stack;


    public Brackets(int capacity) {
        this.stack = new char[capacity];
        this.size = 0;
    }

    public Brackets() {
        this(DEFAULT_CAPACITY);
    }

    private void resize() {
        int capacity = stack.length * 2;
        char[] newData = new char[capacity];
        System.arraycopy(this.stack, 0, newData, 0, stack.length);
        stack = newData;
    }

    private void pop() {
        int capacity = size--;
        char[] newData = new char[capacity];
        System.arraycopy(this.stack, 0, newData, 0, capacity);
        stack = newData;
    }

    private void push(char element) {
        if (size == stack.length) {
            resize();
        }
        stack[size++] = element;
    }

    private char top() {
        return stack[size - 1];
    }

    private boolean is_empty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        return "Brackets: " +
                "size=" + size +
                ", stack=" + Arrays.toString(stack);
    }
}

