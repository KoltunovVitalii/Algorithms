package ru.koltunov.vitalii.hashtable;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
//        simpleTest();
        scannerTest();
    }

    public static void simpleTest() {
        HashTable h1 = new HashTable();
        h1.push("aiv");
        h1.push("yvbem");
        System.out.println(h1.search("aiv"));
        System.out.println(h1.search("woxfyobo"));
        System.out.println(h1.pop("guq"));
        System.out.println(h1.pop("prhw"));
        System.out.println(h1.pop("aiv"));
        h1.push("jv");
        System.out.println(h1.pop("aiv"));
        h1.push("ubcf");
    }

    public static void scannerTest() {
        HashTable h1 = new HashTable();
        Scanner scanner = new Scanner(System.in);
        int requests = scanner.nextInt();
        for (int i = 0; i < requests; i++) {
            String cmd = scanner.nextLine();
            String[] s = cmd.split(" ");
            switch (s[0]) {
                case "push" -> h1.push(s[1]);
                case "search" -> {
                    if (h1.search(s[1])) {
                        System.out.println("TRUE");
                    } else {
                        System.out.println("FALSE");
                    }
                }
                case "pop" -> {
                    if (h1.pop(s[1])) {
                        h1.pop(s[1]);
                        System.out.println("TRUE");
                    } else {
                        System.out.println("FALSE");
                    }
                }
            }
        }
    }
}


class HashTable {

    static final int seed = 2;
    int capacity = 2;
    ArrayList<MyList> hashTable;
    int count = 0;
    private final static int threshold = 4;

    public HashTable() {
        newHashTable();
    }

    private void newHashTable() {
        this.hashTable = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            hashTable.add(new MyList());
        }
    }

    public static int hashFunction(String s, int capacity) {
        int prime = 1;
        int hash = 0;

        for (int i = 0; i < s.length(); i++) {
            hash += prime * i;
            hash = hash % capacity;
            prime = prime * seed;
        }
        return hash;
    }

    boolean pop(String s) {
        int id = hashFunction(s, capacity);
        MyList bin = hashTable.get(id);
        if (!bin.isContained(s)) {
            return false;
        }
        bin.delete(s);
        count--;
        return true;
    }

    void push(String s) {
        rehash();
        int index = hashFunction(s, capacity);
        MyList bin = hashTable.get(index);
        bin.add(s);
        count++;
    }

    boolean search(String s) {
        int index = hashFunction(s, capacity);
        MyList bin = hashTable.get(index);
        return bin.isContained(s);
    }

    void rehash() {
        if (capacity <= count * threshold) {
            capacity = capacity * threshold;
            count = 0;
            ArrayList<MyList> hashTableOld = hashTable;
            newHashTable();
            for (MyList bin : hashTableOld) {
                while (bin.size() != 0) {
                    push(bin.pop());
                }
            }
        }
    }
}


class MyList {
    private ListNode head = null;
    private int size = 0;

    public void delete(String s) {
        ListNode prev = null;
        ListNode n = head;
        while (n != null) {
            if (n.data.equals(s)) {
                // удаляем
                if (prev == null) {
                    head = head.nextListNode;
                } else {
                    prev.nextListNode = n.nextListNode;
                }
                size--;
                return;
            }
            prev = n;
            n = n.nextListNode;
        }
    }

    public void add(String s) {
        if (isContained(s)) {
            return;
        }
        ListNode newListNode = new ListNode(s);
        newListNode.nextListNode = head;
        head = newListNode;
        size++;
    }

    /**
     * Ищет индекс элемента с данными -s-
     *
     * @param s - данные
     * @return Индекс элемента с данными -s-, или -1, если элемента с такими данными нет
     */
    public int getIndex(String s) {
        return -1;
    }

    public boolean isContained(String s) {
        for (ListNode currentListNode = head; currentListNode != null; currentListNode = currentListNode.nextListNode) {
            if (Objects.equals(currentListNode.data, s)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public String pop() {
        ListNode l = head;
        head = head.nextListNode;
        size--;
        return l.data;
    }
}

class ListNode {
    String data = null;
    ListNode nextListNode = null;

    public ListNode(String data) {
        this.data = data;
        this.nextListNode = null;
    }
}

