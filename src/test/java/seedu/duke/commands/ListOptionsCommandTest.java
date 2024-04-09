package seedu.duke.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.Duke;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ListOptionsCommandTest {

    @BeforeEach
    void setUp() {
        Duke duke = new Duke("./data/FlirtFork.txt");
    }

    @Test
    void invalidOptionType_expectUserInputPrompt() {
        String optionType = "invalid";
        String simulatedUserInput = "food\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        try {
            ListOptionsCommand listOptionsCommand = new ListOptionsCommand(optionType);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            String output = outputStream.toString();
            assertEquals(output.trim(), "Invalid option! Please choose 'food', 'activities' or 'gifts'.");
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
