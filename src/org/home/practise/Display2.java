package org.home.practise;

public class Display2 {

    public static void main(String...args) {
        splitNumber(45825);
        //splitNumber(55555);
    }

    public static void splitNumber(Integer input) {
        Integer copyOfInput = input.intValue();
        int index = 0;
        while (index < 5) {
            int digit = (int) (copyOfInput % Math.pow(10, index));
            digit =  (int) (digit / Math.pow(10, index - 1));
            System.out.println("Digit " + digit);

            if (digit == 5) {
                //System.out.println("Found 5 at index " + index);
                if (index >=1 ) {
                    copyOfInput = (int) (copyOfInput - Math.pow(10, index - 1));
                } else {
                    copyOfInput = copyOfInput - 1;
                }
            }
            index++;
        }
        System.out.println("Final Numbers are " + copyOfInput + " and " + (input - copyOfInput));
    }
}
