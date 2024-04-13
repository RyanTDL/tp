package seedu.flirtfork.commands;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ListOptionsCommandTest {

    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setIn(standardIn);
        System.setOut(standardOut);
    }

    @Test
    void invalidOptionType_expectUserInputPrompt() {
        String simulatedUserInput = "food\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(inputStream);

        ListOptionsCommand listOptionsCommand = new ListOptionsCommand();
        System.out.flush();

        String output = outputStream.toString();
        assertFalse(output.contains("Invalid option! Please choose 'food', 'activities', 'gifts' or 'cancel'."));
    }
}
