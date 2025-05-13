import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LogParseTest {

    private LogParse logParse;
    private List<String> logs;
    private Map<String, List<String>> expectedLogs;

    @BeforeEach
    void setUp() {
        logParse = new LogParse();
        logs = Arrays.asList(
                "2025-02-26T10:15:30,user123,LOGIN",
                "2025-02-26T10:20:00,user456,PURCHASE",
                "2025-02-26T10:18:00,user123,PURCHASE",
                "2025-02-26T10:25:00,user123,LOGOUT"
        );
        expectedLogs = Map.of(
                "user123", List.of("LOGIN", "PURCHASE", "LOGOUT"),
                "user456", List.of("PURCHASE")
        );
    }

    @Test
    void testLogParseByOleg() {
        System.out.println("Oleg: " + logParse.byOleg(logs));
        assertEquals(expectedLogs, logParse.byOleg(logs));
    }

    @Test
    void testLogParseByAndy() {
        System.out.println("Andy: " + logParse.byAndy(logs));
        assertEquals(expectedLogs, logParse.byAndy(logs));
    }

    @Test
    void testLogParseByPolina() {
        System.out.println("Polina: " + logParse.byPolina(logs));
        assertEquals(expectedLogs, logParse.byPolina(logs));
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    void testLogParseBySergei() {
        System.out.println("Sergey Filipov: " + logParse.groupByUser(logs));
        assertEquals(expectedLogs, logParse.groupByUser(logs));
    }


    @AfterEach
    void tearDown() {
        logParse = null;
    }
}