package ru.koltunov.vitalii;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();
//        String cmd = "push aiv fff fddf dfdfd";
        String[] s = cmd.split("\\s");
        for (String value : s) {
            System.out.println(value);
        }
    }
}
