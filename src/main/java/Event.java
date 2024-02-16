import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an Event task, which is a type of task that needs to be completed.
 * Inherits from the Task class.
 */
class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;

    Event(String name, String fromText, String toText) throws DukeException {
        super(name);
        this.to = super.convertDateTime(toText);
        this.from = super.convertDateTime(fromText);
        if (name == null || name.isEmpty()) {
            throw new DukeException("Task name cannot be empty");
        } else if (from == null) {
            throw new DukeException("Invalid from date format: Event dates should be in dd/mm/yyyy HHmm");
        } else if (to == null) {
            throw new DukeException("Invalid to date format: Event dates should be in dd/mm/yyyy HHmm");
        }
    }

    Event(String name, String fromText, String toText, boolean doneStatus) throws DukeException {
        super(name, doneStatus);
        this.to = super.convertDateTime(toText);
        this.from = super.convertDateTime(fromText);
        if (name == null || name.isEmpty()) {
            throw new DukeException("Task name cannot be empty");
        } else if (from == null) {
            throw new DukeException("Invalid from date format: Event dates should be in dd/mm/yyyy HHmm");
        } else if (to == null) {
            throw new DukeException("Invalid to date format: Event dates should be in dd/mm/yyyy HHmm");
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");
        return String.format("[E]%s (from: %s to: %s)", super.toString(), from.format(formatter), to.format(formatter));
    }
}