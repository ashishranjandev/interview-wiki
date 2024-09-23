package lld.splitwise;

import java.util.Arrays;

public class SplitwiseMain {

    public static void main(String[] args) {
        Splitwise splitwise = new Splitwise();

        // Adding people to the system
        splitwise.addPerson("Alice");
        splitwise.addPerson("Bob");
        splitwise.addPerson("Charlie");

        // Adding transactions (e.g., Alice paid 300, for Alice, Bob, and Charlie)
        splitwise.addTransaction("Alice", 300, Arrays.asList("Alice", "Bob", "Charlie"));
        // Bob paid 150 for himself and Charlie
        splitwise.addTransaction("Bob", 150, Arrays.asList("Bob", "Charlie"));
        // Charlie paid 200 for everyone
        splitwise.addTransaction("Charlie", 200, Arrays.asList("Alice", "Bob", "Charlie"));

        // Print the net amounts owed by each person
        splitwise.printNetAmounts();
    }
}
