package seedu.flirtfork;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UiTest {
    @Test
    public void readAnniversaryDate_validInput() {
        String input = "14/02/2024";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Ui ui = new Ui();

        String result = ui.readAnniversaryDate();

        assertEquals(input, result);
    }
}
