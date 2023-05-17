package ru.koltunov.vitalii.stack;

import java.util.Scanner;

public class Test {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int result = sum(x, y);
        System.out.println(result);

    }

    public static int sum(int x, int y){
        return x + y;
    }

}