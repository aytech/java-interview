import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * You are tasked with implementing a method to process a log of user activities on an e-commerce platform.
 * Each activity is represented as a string in the format:
 * "<timestamp>,<userId>,<action>"
 * where:
 * <timestamp> is an ISO 8601 formatted date (e.g., `2025-02-26T10:15:30`).
 * <userId> is a unique identifier for the user (e.g., `user123`).
 * <action> is the type of activity (e.g., `LOGIN`, `LOGOUT`, `PURCHASE`).
 * Write a function that:
 * 1.	Groups the activities by user.
 * 2.	Returns a map where the key is the `userId` and the value is a list of actions sorted by timestamp.
 * INPUT:
 * List<String> logs = Arrays.asList(
 * "2025-02-26T10:15:30,user123,LOGIN",
 * "2025-02-26T10:20:00,user456,PURCHASE",
 * "2025-02-26T10:18:00,user123,PURCHASE",
 * "2025-02-26T10:25:00,user123,LOGOUT"
 * );
 * EXPECTED OUTPUT:
 * {
 * "user123": ["LOGIN", "PURCHASE", "LOGOUT"],
 * "user456": ["PURCHASE"]
 * }
 */
public class LogParse {
    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
                "2025-02-26T10:15:30,user123,LOGIN",
                "2025-02-26T10:20:00,user456,PURCHASE",
                "2025-02-26T10:18:00,user123,PURCHASE",
                "2025-02-26T10:25:00,user123,LOGOUT"
        );
        Map<String, List<String>> actions = new LinkedHashMap<>();
        logs.stream()
                .sorted((o1, o2) ->
                        LocalDateTime.parse(o1.split(",")[0]).compareTo(LocalDateTime.parse(o2.split(",")[0])))
                .sorted((o1, o2) -> o1.split(",")[1].compareTo(o2.split(",")[1]))
                .forEach(logItem -> {
                    String[] parts = logItem.split(",");
                    if (actions.containsKey(parts[1])) {
                        actions.merge(
                                parts[1],
                                Collections.singletonList(parts[2]),
                                (a, b) ->
                                        Stream.concat(a.stream(), b.stream()).collect(Collectors.toList()));
                    } else {
                        actions.put(parts[1], Collections.singletonList(parts[2]));
                    }
                });
        System.out.println(actions);
    }
}
