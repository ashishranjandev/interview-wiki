package interview.zdbikdu;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class FollowerAnalysis {

    static class FollowEvent {
        String follower;
        String followed;
        LocalDateTime dateTime;

        FollowEvent(String follower, String followed, LocalDateTime dateTime) {
            this.follower = follower;
            this.followed = followed;
            this.dateTime = dateTime;
        }
    }

    // Helper method to parse date-time
    private static LocalDateTime parseDateTime(String date, String time) {
        String dateTimeString = date + " " + time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    // Parsing the input strings into FollowEvent objects
    public static List<FollowEvent> parseEvents(String[] events) {
        List<FollowEvent> eventList = new ArrayList<>();
        for (String event : events) {
            String[] parts = event.split("\\|\\|");
            String follower = parts[0];
            String followed = parts[1];
            LocalDateTime dateTime = parseDateTime(parts[2], parts[3]);
            eventList.add(new FollowEvent(follower, followed, dateTime));
        }
        return eventList;
    }

    // Find users who are followed by more than k users between a date range
    public static Set<String> findUsersFollowedMoreThanKBetween(List<FollowEvent> events, int k, LocalDateTime start, LocalDateTime end) {
        Map<String, Set<String>> followersMap = new HashMap<>();

        for (FollowEvent event : events) {
            if (!event.dateTime.isBefore(start) && !event.dateTime.isAfter(end)) {
                followersMap.computeIfAbsent(event.followed, v -> new HashSet<>()).add(event.follower);
            }
        }

        Set<String> result = new HashSet<>();
        for (Map.Entry<String, Set<String>> entry : followersMap.entrySet()) {
            if (entry.getValue().size() > k) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    // Find users who got at least k followers and order by when they got the k-th follower
    public static List<String> findUsersWithKFollowers(List<FollowEvent> events, int k, boolean ascending) {
        Map<String, List<LocalDateTime>> followersMap = new HashMap<>();

        for (FollowEvent event : events) {
            followersMap.computeIfAbsent(event.followed, v -> new ArrayList<>()).add(event.dateTime);
        }

        List<Map.Entry<String, LocalDateTime>> followerTimes = new ArrayList<>();

        for (Map.Entry<String, List<LocalDateTime>> entry : followersMap.entrySet()) {
            List<LocalDateTime> times = entry.getValue();
            Collections.sort(times);

            if (times.size() >= k) {
                followerTimes.add(new AbstractMap.SimpleEntry<>(entry.getKey(), times.get(k - 1)));
            }
        }

        followerTimes.sort((a, b) -> ascending ? a.getValue().compareTo(b.getValue()) : b.getValue().compareTo(a.getValue()));

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, LocalDateTime> entry : followerTimes) {
            result.add(entry.getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        String[] events = {
                "JohnDeo||Michele||24-12-2024||23:04",
                "Alice||Michele||24-12-2024||23:10",
                "Bob||Michele||24-12-2024||23:15",
                "Charlie||Michele||24-12-2024||23:20",
                "David||JohnDeo||25-12-2024||10:00",
                "Eve||Michele||25-12-2024||11:00",
                "Frank||Alice||26-12-2024||09:00"
        };

        List<FollowEvent> eventList = parseEvents(events);

        LocalDateTime startTime = parseDateTime("24-12-2024", "00:00");
        LocalDateTime endTime = parseDateTime("25-12-2024", "00:00");

        System.out.println("Users followed by more than 2 users between the given time:");
        Set<String> followedUsers = findUsersFollowedMoreThanKBetween(eventList, 2, startTime, endTime);
        System.out.println(followedUsers); // Expected output: ["Michele"]

        System.out.println("Users who got at least 3 followers in ascending order of time:");
        List<String> usersWithKFollowers = findUsersWithKFollowers(eventList, 3, true);
        System.out.println(usersWithKFollowers); // Expected output: ["Michele"]
    }
}

