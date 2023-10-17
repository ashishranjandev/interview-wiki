package org.home.practise;

import java.util.Scanner;

public class FunctionsIntro {

    int i = 0;

    int calculate(int k) {
        return k;
    }

    void calculate() {
        int sum = 0;
        int count = 0;
        double average = 0;

        int num = i;
        while (num != 0) {
            int digit = num % 10;
            sum = sum + digit;
            count++;
            num = num/10;
        }

        average = sum/Double.valueOf(count);

        System.out.println("Sum is " + sum);
        System.out.println("Count is " + count);
        System.out.println("Average is " + average);
    }

    public static void main(String...args) {
        FunctionsIntro obj = new FunctionsIntro();
        Scanner scanner = new Scanner(System.in);

        obj.calculate();
    }
}
