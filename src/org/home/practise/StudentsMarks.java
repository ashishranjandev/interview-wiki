package org.home.practise;

import java.util.Random;

public class StudentsMarks {

    public static void main(String[] args) {
        int[] rollNumbers = new int[50];
        int[] marksArrayForSubjectA = new int[50];
        int[] marksArrayForSubjectB = new int[50];
        int[] marksArrayForSubjectC = new int[50];
        Random random = new Random();

        for (int i = 0; i < rollNumbers.length; i++) {
            rollNumbers[i] = i + 1;
        }

        for (int i = 0; i < marksArrayForSubjectA.length; i++) {
            int mark = random.nextInt(101); // Generates a random number between 0 and 100
            marksArrayForSubjectA[i] = mark;
        }

        for (int i = 0; i < marksArrayForSubjectB.length; i++) {
            int mark = random.nextInt(101); // Generates a random number between 0 and 100
            marksArrayForSubjectB[i] = mark;
        }
        for (int i = 0; i < marksArrayForSubjectC.length; i++) {
            int mark = random.nextInt(101); // Generates a random number between 0 and 100
            marksArrayForSubjectC[i] = mark;
        }

        System.out.println("Print Roll Number Array");
        for (int mark : rollNumbers) {
            System.out.print(mark + " ");
        }
        System.out.println("Print Marks in Subject A");
        for (int mark : marksArrayForSubjectA) {
            System.out.print(mark + " ");
        }
        System.out.println("Print Marks in Subject B");
        for (int mark : marksArrayForSubjectB) {
            System.out.print(mark + " ");
        }
        System.out.println("Print Marks in Subject C");
        for (int mark : marksArrayForSubjectC) {
            System.out.print(mark + " ");
        }
        System.out.println();

        int[] totalArray = new int[50];
        for (int i = 0; i < totalArray.length; i++) {
            totalArray[i] = marksArrayForSubjectA[i] + marksArrayForSubjectB[i] + marksArrayForSubjectC[i];
        }

        int highestInSubjectA = marksArrayForSubjectA[0];
        int rollNumberWhoHasHighestInSubjectA = rollNumbers[0];

        int highestInSubjectB = marksArrayForSubjectB[0];
        int rollNumberWhoHasHighestInSubjectB = rollNumbers[0];

        int highestInSubjectC = marksArrayForSubjectC[0];
        int rollNumberWhoHasHighestInSubjectC = rollNumbers[0];

        int highestInTotal = marksArrayForSubjectC[0];
        int rollNumberWhoHasHighestInTotal = rollNumbers[0];

        for (int i = 0; i < marksArrayForSubjectA.length; i++) {
            if (marksArrayForSubjectA[i] > highestInSubjectA) {
                highestInSubjectA = marksArrayForSubjectA[i];
                rollNumberWhoHasHighestInSubjectA = rollNumbers[i];
            }
        }

        for (int i = 0; i < marksArrayForSubjectB.length; i++) {
            if (marksArrayForSubjectB[i] > highestInSubjectB) {
                highestInSubjectB = marksArrayForSubjectB[i];
                rollNumberWhoHasHighestInSubjectB = rollNumbers[i];
            }
        }

        for (int i = 0; i < marksArrayForSubjectC.length; i++) {
            if (marksArrayForSubjectC[i] > highestInSubjectC) {
                highestInSubjectC = marksArrayForSubjectC[i];
                rollNumberWhoHasHighestInSubjectC = rollNumbers[i];
            }
        }

        for (int i = 0; i < totalArray.length; i++) {
            if (totalArray[i] > highestInTotal) {
                highestInTotal = totalArray[i];
                rollNumberWhoHasHighestInTotal = rollNumbers[i];
            }
        }

        System.out.println("Highest number in subject A is " + highestInSubjectA + " by roll number " + rollNumberWhoHasHighestInSubjectA);
        System.out.println("Highest number in subject B is " + highestInSubjectB + " by roll number " + rollNumberWhoHasHighestInSubjectB);
        System.out.println("Highest number in subject C is " + highestInSubjectC + " by roll number " + rollNumberWhoHasHighestInSubjectC);
        System.out.println("Highest number in total is " + highestInTotal + " by roll number " + rollNumberWhoHasHighestInTotal);

    }

}
