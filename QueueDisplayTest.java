package CCE105LAB;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueDisplayTest {
    public static void main(String[] args) throws Exception {
        ERQueue er = new ERQueue();
        er.arrive("Low", 3, "sample", "09:00");
        er.arrive("Late", 2, "sample", "09:20");
        er.arrive("Early", 2, "sample", "09:10");
        er.arrive("Urgent", 1, "sample", "09:30");

        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(captured, true, "UTF-8"));
            er.displayQueue();
        } finally {
            System.setOut(original);
        }

        List<String> patients = new ArrayList<>();
        for (String line : captured.toString("UTF-8").split(System.lineSeparator())) {
            if (line.contains("[P")) {
                patients.add(line.trim());
            }
        }
        List<String> expected = Arrays.asList(
            "1 [P1] Urgent | sample (09:30)",
            "2 [P2] Early | sample (09:10)",
            "3 [P2] Late | sample (09:20)",
            "4 [P3] Low | sample (09:00)"
        );
        if (!patients.equals(expected)) {
            throw new AssertionError("Queue display order: " + patients);
        }
        if (er.queue.size() != 4 || !er.queue.peek().name.equals("Urgent")) {
            throw new AssertionError("Displaying the queue changed treatment order");
        }
        System.out.println("Queue display regression test passed");
    }
}
