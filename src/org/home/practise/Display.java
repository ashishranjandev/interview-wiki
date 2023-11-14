package org.home.practise;

import java.util.Scanner;

public class Display {

    public static void main (String[] args) {
        //[1 2 3]
        //[4 5 6]
        //[7 8 9]
        /*
        int[][] nums2 = new int[3][3];
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};

        System.out.println("*******************");

        stringDemo();

        System.out.println("*******************");

        printSumOfEachRows();

        printSumOfEachColumns();

        printSumOfFirstRow();
        printSumOfSecondRow();
        printSumOfThirdRow();

        printSumOfFirstColumn();

        printSumOfRightDiagonal();
        */
        //printFrequencyAndSumOfEvenDigits();

        //printFirstLetterOfEveryWord();

        //printIncomeTax();
        //a quick fox jumped over a lazy dog
        printLongestWord();
    }

    public static void printLongestWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Sentence");
        String sentence = scanner.nextLine();

        String longestWord = sentence.substring(0, sentence.indexOf(' '));
        int startOfWord = 0;
        for (int i = 1; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                int endOfWord = i - 1;
                int lengthOfCurrentWord = endOfWord - startOfWord + 1;
                if (lengthOfCurrentWord > longestWord.length()) {
                    longestWord = sentence.substring(startOfWord, endOfWord + 1);
                }
                startOfWord = i + 1;
            }
            if (i == sentence.length() - 1) {
                int endOfWord = i;
                int lengthOfCurrentWord = endOfWord - startOfWord + 1;
                if (lengthOfCurrentWord > longestWord.length()) {
                    longestWord = sentence.substring(startOfWord, endOfWord + 1);
                }
            }
        }
        System.out.println("Longest word is "+ longestWord);
    }


    public static void printIncomeTax() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the employee Name");
        String name = scanner.nextLine();

        System.out.println("Enter the employee annual gross income");
        double salary = scanner.nextDouble();

        double incomeTax;
        if (salary <= 100000) {
            incomeTax = 0.0;
        } else if (salary > 100000 && salary <= 500000) {
            incomeTax = 1000 + ((salary - 100000) / 10);
        } else if (salary > 500000 && salary <= 800000) {
            incomeTax = 5000 + ((salary - 500000) / 5);
        } else {
            incomeTax = 10000 + (((salary - 800000) * 30) / 100);
        }

        System.out.println("Employee Name - " + name);
        System.out.println("Total Income tax - " + incomeTax);
    }

    public static void printFrequencyAndSumOfEvenDigits() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = scanner.nextInt();
        int temp = number;

        System.out.println("Enter the digit for getting the frequency");
        int digit = scanner.nextInt();

        int frequency = 0;
        int sumOfEvenDigits = 0;
        while (temp != 0) {
            int currentDigit = temp % 10;
            if (currentDigit == digit) {
                frequency++;
            }
            if (currentDigit % 2 == 0) {
                sumOfEvenDigits = sumOfEvenDigits + currentDigit;
            }
            temp = temp / 10;
        }

        System.out.println(" Frequency of Digit is " + frequency);
        System.out.println(" Sum of Even Digits is " + sumOfEvenDigits);
    }

    public static void printFirstLetterOfEveryWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String sentence = scanner.nextLine();
        sentence = sentence.toUpperCase();
        System.out.println(sentence);

        int length = sentence.length();
        System.out.print(sentence.charAt(0));
        for (int i = 0; i < length ; i++) {
            if (sentence.charAt(i) == ' ' && i != length - 1) {
                System.out.print("." + sentence.charAt(i + 1));
            }
        }
    }

    public static void stringDemo() {
        String name1 = " Ankita Roy ";
        String name2 = " Ankita Roy ";

        System.out.println(name1.length());

        System.out.println(name1.charAt(4));

        System.out.println(name1.indexOf('i'));

        System.out.println(name1.lastIndexOf('a'));

        System.out.println(name1.toUpperCase());

        System.out.println(name1.toLowerCase());

        System.out.println(name1.equalsIgnoreCase("Ankita Roy"));

        System.out.println(name1.equalsIgnoreCase("Ankita roy"));

        System.out.println(name1.replace('o', 'a'));

        System.out.println(name1.concat(" Student"));
        System.out.println(name1.trim());

        name1 = "Bhaskar";
        System.out.println(name1.substring(2));

        System.out.println(name1.substring(2, 5));

        name2 = "Bhaskar";
        System.out.println(name1.compareTo(name2));

        name1 = "Amit";
        name2 = "Surabhi";
        System.out.println(name1.compareTo(name2));

        System.out.println("Hello".compareToIgnoreCase("HELLO"));

    }

    public int func() {
        int x[] = {1,2,3,5};
        int y[] = {7,8,9,15};

        y = x;

        System.out.println(y[2]);
        return  -1;
    }

    public static void printSumOfRightDiagonal() {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum = sum + nums[i][2 - i];
        }
        System.out.println("Sum of right diagonal is " + sum);
    }

    public static void printSumOfEachRows() {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for(int j =0; j < 3; j++) {
                sum = sum + nums[i][j];
            }
            System.out.println("Sum of " + (i + 1) + " is " + sum);
        }
    }

    public static void printSumOfEachColumns() {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        for (int j = 0; j < 3; j++) {
            int sum = 0;
            for(int i =0; i < 3; i++) {
                sum = sum + nums[i][j];
            }
            System.out.println("Sum of Column number: " + (j + 1) + " is " + sum);
        }
    }

    public static void printSumOfFirstColumn() {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        int sum = 0;
        for(int i = 0; i < 3; i++) {
            sum = sum + nums[i][0];
        }
        System.out.println("Sum of 1st Column is " + sum);
    }

    public static void printSumOfFirstRow() {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        int sum = 0;
        for(int j =0; j < 3; j++) {
            sum = sum + nums[0][j];
        }
        System.out.println("Sum of 1st Row is " + sum);
    }

    public static void printSumOfSecondRow() {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        int sum = 0;
        for(int j =0; j < 3; j++) {
            sum = sum + nums[1][j];
        }
        System.out.println("Sum of 2nd Row is " + sum);
    }

    public static void printSumOfThirdRow() {
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        int sum = 0;
        for(int j =0; j < 3; j++) {
            sum = sum + nums[2][j];
        }
        System.out.println("Sum of 3rd Row is " + sum);
    }





    public static double getAreaOfRectangle(double length, double breadth) {
        return length * breadth;
    }

    public static double getAreaOfHouse(double edge) {
        double areaOfSquare = edge * edge;
        double areaOfTriangle = getAreaOfEquilateralTriangle(edge);
        double areaOfShape = areaOfSquare + areaOfTriangle;
        return areaOfShape;
    }

    public static double getAreaOfEquilateralTriangle(double edge) {
        double areaOfTriangle = (Math.sqrt(3.0) * edge * edge) / 4;

        return areaOfTriangle;
    }

    public static void inputArrayAndMarks() {
        Scanner obj = new Scanner(System.in);
        int[] rollNumbers = new int[5];
        int[] totalMarks = new int[5];
        System.out.println("Please enter 5 roll numbers and their total marks");
        for (int i = 0; i < 5; i++) {
            rollNumbers[i] = obj.nextInt();
            totalMarks[i] = obj.nextInt();
        }

        int max = totalMarks[0];
        int rollNumberOfMaxMarks = rollNumbers[0];
        for (int i = 0; i < 5; i++) {
            if (totalMarks[i] > max) {
                max = totalMarks[i];
                rollNumberOfMaxMarks = rollNumbers[i];
            }
        }

        System.out.println("Highest total marks is " + max + " Student who obtained it is  - " + rollNumberOfMaxMarks );
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
