package interview.zdbikdu;

import java.util.*;

public class KeyCardAlertSystem {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> employeeTimes = new HashMap<>();

        // Convert time to minutes and group by employee name
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            int timeInMinutes = convertToMinutes(keyTime[i]);

            employeeTimes.computeIfAbsent(name, k -> new ArrayList<>()).add(timeInMinutes);
        }

        List<String> alertNames = new ArrayList<>();

        // Check each employee's times for alerts
        for (Map.Entry<String, List<Integer>> entry : employeeTimes.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();
            Collections.sort(times);

            for (int i = 0; i <= times.size() - 3; i++) {
                if (times.get(i + 2) - times.get(i) <= 60) {
                    alertNames.add(name);
                    break; // We can stop checking this employee after the first alert
                }
            }
        }

        // Sort the alert names alphabetically
        Collections.sort(alertNames);
        return alertNames;
    }

    // Helper function to convert "HH:MM" to minutes since midnight
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    public static void main(String[] args) {
        KeyCardAlertSystem system = new KeyCardAlertSystem();

        String[] keyName1 = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] keyTime1 = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        System.out.println(system.alertNames(keyName1, keyTime1)); // Expected: ["daniel"]

        String[] keyName2 = {"alice","alice","alice","bob","bob","bob","bob"};
        String[] keyTime2 = {"12:01","12:00","18:00","21:00","21:20","21:30","23:00"};
        System.out.println(system.alertNames(keyName2, keyTime2)); // Expected: ["bob"]
    }
}

