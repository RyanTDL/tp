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

    @Test
    public void readUserGender_validMaleInput() {
        String input = "Male";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Ui ui = new Ui();

        String result = ui.readUserGender();

        assertEquals("Male", result);
    }

    @Test
    public void readUserGender_validFemaleInput() {
        String input = "Female";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Ui ui = new Ui();

        String result = ui.readUserGender();

        assertEquals("Female", result);
    }

    @Test
    public void readUserLocation_validInput() {
        String input = "C";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Ui ui = new Ui();

        String result = ui.readUserLocation();

        assertEquals("C", result);
    }

    @Test
    public void readAge_validInput() {
        String input = "25";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Ui ui = new Ui();

        String result = ui.readAge();

        assertEquals("25", result);
    }

    @Test
    public void readName_validInput() {
        String input = "John Doe";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Ui ui = new Ui();

        String result = ui.readName();

        assertEquals("John Doe", result);
    }

    @Test
    public void readUserCuisine_validInput() {
        String input = "J";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Ui ui = new Ui();

        String result = ui.readUserCuisine();

        assertEquals("J", result);
    }

    @Test
    public void readUserStatus_validInput() {
        String input = "S";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Ui ui = new Ui();

        String result = ui.readUserStatus();

        assertEquals("S", result);
    }

}
