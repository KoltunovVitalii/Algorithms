package ru.koltunov.vitalii.hashfunction;

public class HashFunctionFoString {
    private String s;
    private int p;
    private int[] ints;
    private int intsSize = ints.length;

    public HashFunctionFoString(int[] ints) {
        this.ints = ints;
    }

    public static void main(String[] args) {
        int[] ints1 = new int[10];
        int x = hashFunctionFoString("sdfdfdffdfdjad", 5, ints1.length);
        System.out.println(x);
    }

    public static int hashFunctionFoString(String s, int p, int intsSize) {
        int prime = 1;
        int hash = 0;

        for (int i = 0; i < s.length(); i++) {
            hash += prime * i;
            hash = hash % intsSize;
            prime = prime * p;
        }
        return hash;
    }


}
