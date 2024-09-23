package lld.splitwise;

import java.util.List;

class Transaction {
    private Person paidBy;
    private double amount;
    private List<Person> participants;

    public Transaction(Person paidBy, double amount, List<Person> participants) {
        this.paidBy = paidBy;
        this.amount = amount;
        this.participants = participants;
    }

    public Person getPaidBy() {
        return paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public List<Person> getParticipants() {
        return participants;
    }

    public double getSplitAmount() {
        return amount / participants.size();
    }
}
