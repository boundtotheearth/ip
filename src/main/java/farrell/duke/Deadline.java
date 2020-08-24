package main.java.farrell.duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Encapsulates data for a deadline task.
 */
public class Deadline extends Task {
    /** The deadline for the task */
    LocalDate time;

    Deadline(String description, LocalDate time) {
        this(description, false, time);
    }

    Deadline(String description, boolean isDone, LocalDate time) {
        super(description, isDone);
        taskType = TaskType.DEADLINE;
        this.time = time;
    }

    @Override
    public String toString() {
        String formattedTime = time.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        return "[D]" + super.toString() + " (by: " + formattedTime + ")";
    }
}
