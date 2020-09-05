package main.java.farrell.duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Encapsulates data for an event task
 */
public class Event extends Task {
    /** The time when the event is occurring */
    private LocalDate time;

    Event(String description, LocalDate time) {
        this(description, false, time);
    }

    Event(String description, boolean isDone, LocalDate time) {
        super(description, isDone);
        taskType = TaskType.EVENT;
        this.time = time;
    }

    public LocalDate getTime() {
        return time;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        String formattedTime = time.format(formatter);
        return "[E]" + super.toString() + " (at: " + formattedTime + ")";
    }
}
