package interview.zdbikdu;

import java.util.*;

public class BadgeSystem {

    public static List<List<String>> mismatches(String[][] records) {
        Set<String> enterWithoutExit = new HashSet<>();
        Set<String> exitWithoutEnter = new HashSet<>();
        Map<String, String> currentStatus = new HashMap<>();

        for (String[] record : records) {
            String name = record[0];
            String action = record[1];

            if (action.equals("enter")) {
                if (currentStatus.containsKey(name)) {
                    // If there's an unmatched enter, it means there was no corresponding exit
                    enterWithoutExit.add(name);
                } else {
                    currentStatus.put(name, "entered");
                }
            } else if (action.equals("exit")) {
                if (!currentStatus.containsKey(name)) {
                    // Exiting without entering
                    exitWithoutEnter.add(name);
                } else {
                    // Matched entry and exit, so remove from current status
                    currentStatus.remove(name);
                }
            }
        }

        // Any remaining names in currentStatus didn't exit
        enterWithoutExit.addAll(currentStatus.keySet());

        // Convert sets to sorted lists
        List<String> enterWithoutExitList = new ArrayList<>(enterWithoutExit);
        List<String> exitWithoutEnterList = new ArrayList<>(exitWithoutEnter);
        Collections.sort(enterWithoutExitList);
        Collections.sort(exitWithoutEnterList);

        // Return as a list of lists
        List<List<String>> result = new ArrayList<>();
        result.add(enterWithoutExitList);
        result.add(exitWithoutEnterList);

        return result;
    }

    public static void main(String[] args) {
        String[][] records1 = {
                {"Paul", "enter"},
                {"Pauline", "exit"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Martha", "exit"},
                {"Joe", "enter"},
                {"Martha", "enter"},
                {"Steve", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Joe", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Joe", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Joe", "enter"},
                {"Joe", "enter"},
                {"Martha", "exit"},
                {"Joe", "exit"},
                {"Joe", "exit"}
        };

        String[][] records2 = {
                {"Paul", "enter"},
                {"Paul", "exit"},
        };

        String[][] records3 = {
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
        };

        String[][] records4 = {
                {"Raj", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Paul", "enter"},
                {"Raj", "enter"},
        };

        System.out.println(mismatches(records1)); // Expected: [["Steve", "Curtis", "Paul", "Joe"], ["Martha", "Pauline", "Curtis", "Joe"]]
        System.out.println(mismatches(records2)); // Expected: [[], []]
        System.out.println(mismatches(records3)); // Expected: [["Paul"], ["Paul"]]
        System.out.println(mismatches(records4)); // Expected: [["Raj", "Paul"], ["Paul"]]
    }
}


