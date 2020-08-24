package main.java.farrell.duke;

public enum TaskType {
    TODO,
    EVENT,
    DEADLINE;

    public static TaskType enumFromString(String string) {
        return TaskType.valueOf(string.toUpperCase());
    }
}