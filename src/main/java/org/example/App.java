package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        StringBuilder total = new StringBuilder();
        long init = System.currentTimeMillis();
        for(int i = 0; i < 20000; i++) {
            total.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - init);
    }

    // casting, casteo
    public static void mainAux() {
        // byte subset short subset int subset long

        int a = 1; // [-2^31, 2^31) // 2^N ~ 10^(N/3)
        long b = 2;
        short e = 3;
        byte d = 4; // [-2^7, 2^7)

        b = a;
        a = (int) b;

        // int subset float
        // long subset double
        // float subset double
        // double epsilon = 0.000001;
        // x == y ?     y in (x - epsilon, x + epsilon)
        float x = 5;
        double y = 6;

        char c = 'a'; // EASCII
        int f = c;
        c = (char) f;

        boolean p = true;

        String str = "123A" + "AAA";
        str = String.valueOf(x);

        try {
            f = Integer.parseInt(str);
        } catch (Exception err) {

        }

        int n = 9;  // 2^31 - 1
        int m = 10; // 2^31 - 2

        n = n + m; // n = 19, m = 10
        m = n - m; // n = 19, m = 9
        n = n - m; // n = 10, m = 9

        // Z + Z = Z

        // + -> OPERADOR     "Hello" + "" = "Hello"


        // ---------------------------------------

        System.out.println();

        Scanner scanner = new Scanner(System.in);
        String l = scanner.next();

        // inmutabilidad

        String hello = "Hello";
        String hello2 = hello.toUpperCase();
        System.out.println(hello);
        System.out.println(hello2);
    }

    public static void example() {

        if(q() && p()) {
            f();
        }


    }

    public static boolean p() {
        throw new RuntimeException();
    }

    public static boolean q() {
        return false;
    }


    public static void f() {

    }

    public static void g() {

    }

    public static void h(String[] array) {

        String total = "";
        int i = 0;
        while(i < array.length) {
            total += array[i];
            i++;
        }

    }

    // Baeldung
    // arreglos y matrices
    // recursividad
    // listas y diccionarios

}
