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
        LogParse.byOleg(logs);
        LogParse.byAndy(logs);
        LogParse.byPolina(logs);
        // Below was implemented by candidate for Senior Engineer position
        System.out.println(" Sergey Filipov: " + LogParse.groupByUser(logs));
    }

    private static void byOleg(List<String> logs) {
        Map<String, List<String>> actions = new LinkedHashMap<>();
        logs.stream()
                .sorted(Comparator.comparing(o -> LocalDateTime.parse(o.split(",")[0])))
                .sorted(Comparator.comparing(o -> o.split(",")[1]))
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
        System.out.println("Oleg: " + actions);
    }

    private static void byAndy(List<String> logs) {
        record Row(LocalDateTime timestamp, String user, String action) {
            public static Row fromInput(String input) {
                String[] parts = input.split(",");
                return new Row(LocalDateTime.parse(parts[0]), parts[1], parts[2]);
            }
        }
        Map<String, List<String>> map = new HashMap<>();
        logs
                .stream()
                .map(Row::fromInput)
                .sorted(Comparator.comparing(Row::timestamp))
                .forEach(r -> map.computeIfAbsent(r.user, k -> new ArrayList<>()).add(r.action));
        System.out.println(" Andy: " + map);
    }

    private static void byPolina(List<String> logs) {

        Map<String, List<String>> map = new HashMap<>();
        Collections.sort(logs);

        for (String str : logs) {
            String[] data = str.split(",");
            String user = data[1];
            String action = data[2];
            if (!map.containsKey(user)) {
                map.put(user, List.of(action));
            } else {
                List<String> actions = new ArrayList<>(map.get(user));
                actions.add(action);
                map.put(user, actions);
            }
        }
        System.out.println("Polina: " + map);
    }

    // Below was implemented by candidate for Senior Engineer position
    private static Map<String, List<String>> groupByUser(List<String> logs) {
        // parse logs, ts, userId, action
        // group by userId, sort ts
        // logEntry -> activity
        Map<String, List<LogEntry>> logEntriesGrouped = logs.stream()
                .map(LogEntry::parse)
                .collect(Collectors.groupingBy(LogEntry::userId, Collectors.toList()));

        for (Map.Entry<String, List<LogEntry>> logEntry : logEntriesGrouped.entrySet()) {
            logEntry.getValue().sort(Comparator.comparing(LogEntry::ts));
        }

        return logEntriesGrouped.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                .map(LogEntry::activity)
                .toList()));
    }

    public record LogEntry(LocalDateTime ts, String userId, String activity) {
        public static LogEntry parse(String logEntry) {
            if (logEntry == null) return null;
            String[] fields = logEntry.split(",");
            if (fields.length < 3) throw new IllegalArgumentException("not all fields provided");
            LocalDateTime ts = LocalDateTime.parse(fields[0]);
            return new LogEntry(ts, fields[1], fields[2]);
        }
    }
}
