package parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import command.Command;

import duke.Duke;

/**
 * Parses user input to create corresponding Command objects.
 */
public class Parser {
    private static final String[] DATE_FORMATS = { "yyyy-MM-dd", "dd-MM-yyyy", "MM-dd-yyyy", "dd/MM/yyyy", "MM/dd/yyyy",
            "yyyy/MM/dd", "dd MMM yyyy", "MMM dd yyyy", "yyyy MMM dd", "dd MMM yyyy", "yyyy-MM-d", "d-MM-yyyy",
            "MM-d-yyyy", "d/MM/yyyy", "MM/d/yyyy", "yyyy/MM/d", "d MMM yyyy", "MMM d yyyy", "yyyy MMM d",
            "d MMM yyyy", "MMM dd yyyy" };
    private static final String[] TIME_FORMATS = { "HH:mm", "HH:mm", "h:mm a", "HHmm", "hh:mm a" };

    /**
     * Parses the user input and returns the corresponding Command object.
     *
     * @param userInput The user input string to be parsed.
     * @return The Command object corresponding to the user input.
     */
    public static Command parseCommand(String userInput) {
        String[] words = userInput.split(" ");
        String commandWord = words[0].toLowerCase();

        switch (commandWord) {
            case "todo":
                return new Command(words, Duke.CommandType.TODO);
            case "deadline":
                return new Command(words, Duke.CommandType.DEADLINE);
            case "event":
                return new Command(words, Duke.CommandType.EVENT);
            case "list":
                return new Command(words, Duke.CommandType.LIST);
            case "mark":
                return new Command(words, Duke.CommandType.MARK);
            case "unmark":
                return new Command(words, Duke.CommandType.UNMARK);
            case "delete":
                return new Command(words, Duke.CommandType.DELETE);
            case "bye":
                return new Command(words, Duke.CommandType.BYE);
            default:
                return new Command(words, Duke.CommandType.UNKNOWN);
        }
    }

    /**
     * 
     * @param dateTimeString
     * @return
     */
    public static LocalDateTime convertDateTime(String dateTimeString) {
        for (String dateFormat : DATE_FORMATS) {
            for (String timeFormat : TIME_FORMATS) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat + " " + dateFormat);
                    return LocalDateTime.parse(dateTimeString, formatter);
                } catch (DateTimeParseException e) {

                }
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat + " " + timeFormat);
                    return LocalDateTime.parse(dateTimeString, formatter);
                } catch (DateTimeParseException e) {

                }
            }
        }
        return null;
    }
}
