package lld.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Splitwise {
    private List<Person> people;
    private List<Transaction> transactions;

    public Splitwise() {
        people = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    // Add a person to the group
    public void addPerson(String name) {
        people.add(new Person(name));
    }

    // Add a transaction to the system
    public void addTransaction(String paidByName, double amount, List<String> participantNames) {
        Person paidBy = findPersonByName(paidByName);
        List<Person> participants = new ArrayList<>();
        for (String participantName : participantNames) {
            participants.add(findPersonByName(participantName));
        }
        transactions.add(new Transaction(paidBy, amount, participants));
    }

    // Find a person by name
    private Person findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new IllegalArgumentException("Person not found: " + name);
    }

    // Calculate the net amount each person owes or is owed
    public Map<Person, Double> calculateNetAmounts() {
        Map<Person, Double> netBalances = new HashMap<>();

        // Initialize balances for all people
        for (Person person : people) {
            netBalances.put(person, 0.0);
        }

        // Process each transaction
        for (Transaction transaction : transactions) {
            double splitAmount = transaction.getSplitAmount();
            Person paidBy = transaction.getPaidBy();

            // Update the balance for the person who paid
            netBalances.put(paidBy, netBalances.get(paidBy) + transaction.getAmount());

            // Update the balance for participants
            for (Person participant : transaction.getParticipants()) {
                netBalances.put(participant, netBalances.get(participant) - splitAmount);
            }
        }

        return netBalances;
    }

    // Print the net amounts for each person
    public void printNetAmounts() {
        Map<Person, Double> netAmounts = calculateNetAmounts();
        for (Map.Entry<Person, Double> entry : netAmounts.entrySet()) {
            System.out.println(entry.getKey().getName() + " net balance: " + String.format("%.2f", entry.getValue()));
        }
    }
}
