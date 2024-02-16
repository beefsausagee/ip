package seedu.duke;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import exception.DukeException;
import task.Deadline;

public class DeadlineTest {

    @Test
    public void testDeadlineConstructor_validDateFormat() {
        try {
            Deadline deadline = new Deadline("Finish report", "12/02/2022 19:11");
            assertEquals("Finish report", deadline.getName());
            assertEquals("2022-02-12T19:11", deadline.getBy().toString());
        } catch (DukeException e) {
        }
    }

    @Test
    public void testDeadlineConstructor_validTimeFormat() {
        try {
            Deadline deadline = new Deadline("Finish report", "12/02/2022 1800");
            assertEquals("Finish report", deadline.getName());
            assertEquals("2022-02-12T18:00", deadline.getBy().toString());
        } catch (DukeException e) {
        }
    }
}
