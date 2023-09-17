package ru.koltunov.vitalii.stack;

import java.util.Scanner;
class Queue {    static Queue queueIN = new Queue();
    static Queue queueOUT = new Queue();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String cmd;
        do {
            cmd = scanner.nextLine();
            if (cmd.equals("новичок:")) {
                queueIN.newPatient(scanner.next());
            } else if (cmd.equals("следующий")) {
                String patient = queueOUT.nextPatient();
                if (patient != null)
                    System.out.println(patient);
            } else {
                continue;
            }
            if (queueIN.is_empty() && queueOUT.is_empty()) {
                System.out.println("Все вылечены!");
                break;
            }
        } while (!cmd.equals("Смена закончилась!"));
    }
    private static final int DEFAULT_CAPACITY = 15;
    private int size;
    private String[] queue;

    public Queue(int capacity) {
        this.queue = new String[capacity];
        this.size = 0;
    }

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    private void makeBigger() {
        int capacity = queue.length * 2;
        String[] newData = new String[capacity];
        System.arraycopy(this.queue, 0, newData, 0, queue.length);
        queue = newData;
    }

    private String pop() {
        String result = null;
        if (size > 0)
            result = this.queue[size - 1];
        int capacity = size--;
        String[] newData = new String[capacity];
        System.arraycopy(this.queue, 0, newData, 0, capacity);
        queue = newData;
        return  result;
    }

    private void push(String element) {
        if (size == queue.length) {
            makeBigger();
        }
        queue[size++] = element;
    }

    private String top() {
        return queue[size - 1];
    }

    private boolean is_empty() {
        return this.size == 0;
    }
    private String nextPatient() {
        if (queueIN.is_empty() && queueOUT.is_empty()) {
            return null;
        }
        String elem;

        if (queueOUT.is_empty()) {
            while (!queueIN.is_empty()) {
                queueOUT.newPatient(queueIN.pop());
            }
        }
        return queueOUT.pop();
    }

    private void newPatient(String element) {
        push(element);
    }
}