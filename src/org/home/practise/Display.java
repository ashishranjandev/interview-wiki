package org.home.practise;

public class Display {

    public static void main (String[] args) {
        //printSeries0_3_8_15();
        //printSeries1_2_5_10_17_26();
        //print_1by2_1by4_1by6();

        int a = 2;
        int b = 3, c = 3;
        System.out.println(a - (b++) * (--c));
    }


    public static void print_1by2_1by4_1by6() {
        double sum = 0.0;
        for (int i = 2; i <= 20; i = i+ 2) {
            sum = sum + (1.0 / i) ;
        }
        System.out.println("Sum is " + sum);
    }

    public static void printSeries0_3_8_15() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum = sum + ((i * i) - 1 );
        }
        System.out.print("Sum is " + sum);
    }

    public static void printSeries1_2_5_10_17_26() {
        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = sum + ((i * i) + 1 );
        }
        System.out.print("Sum is " + sum);
    }

    public static void print2Series1() {
        int i = -1;
        int k = 2;
        int sum = 0;

        for (; i > -99;  ) {
            sum += i + k;
            i -= 2;
            k += 2;
        }
        System.out.println("The sum is " + sum);
    }
}
