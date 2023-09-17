package ru.koltunov.vitalii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class TEST {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();


        System.out.println("Введи число");

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        for (int i = 0; i < x; i++){
            System.out.println("Введи строку");
            Scanner scanner1 = new Scanner(System.in);
            String s = scanner1.next();
            listAdd(list, s);
        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        System.out.println("Введи номер строки в списке");
        Scanner scanner2 = new Scanner(System.in);
        int y = scanner2.nextInt() + 1;
        if (y <= list.size()) {
            if (y < 1) {

            } else {

            }
            System.out.println(list.get(y - 1));
        } else {
            System.out.println("такого числа в списке нет");
        }
    }

    private static List<String> listAdd (List<String> list, String s) {
        list.add(s);
        return list;
    }


}
