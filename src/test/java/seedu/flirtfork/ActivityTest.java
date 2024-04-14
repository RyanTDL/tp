package seedu.flirtfork;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ActivityTest {

    @Test
    public void generateActivity_nullDescripton_throwsException() {
        String description = null;
        String location = "C";
        String price = "C";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Activity(description, location, price, "U");
        });
        assertTrue(exception.getMessage().contains("Description cannot be null"));
    }

    @Test
    void getDescription_validDescription_expectSameDescription() {
        String description = "Skydiving";
        String location = "C";
        String price = "C";
        try {
            Activity myActivity = new Activity(description, location, price, "U");
            assertEquals(description, myActivity.getDescription());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void toString_validDescription_expectSameDescription() {
        String description = "Skydiving";
        String location = "C";
        String price = "C";
        try {
            Activity myActivity = new Activity(description, location, price, "U");
            assertEquals(description, myActivity.toString());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void markComplete_validCallToMarkComplete_expectCompleted() {
        String description = "C";
        String location = "C";
        String price = "C";
        try {
            Activity myActivity = new Activity(description, location, price, "U");
            assertEquals("U", myActivity.getCompletionStatus());
            myActivity.markComplete();
            assertEquals("C", myActivity.getCompletionStatus());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
