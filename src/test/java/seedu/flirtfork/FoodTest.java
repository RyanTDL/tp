package seedu.flirtfork;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class FoodTest {

    @Test
    public void generateFood_nullDescripton_throwsException() {
        String description = null;
        String location = "C";
        String price = "C";
        String cuisine = "C";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Food(description, location, price, cuisine, "U");
        });
        assertTrue(exception.getMessage().contains("Description cannot be null"));
    }

    @Test
    void getDescription_validDescription_expectSameDescription() {
        String description = "Bistro Bar";
        String location = "C";
        String price = "C";
        String cuisine = "C";
        try {
            Food myFood = new Food(description, location, price, cuisine, "U");
            assertEquals(description, myFood.getDescription());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void toString_validDescription_expectSameDescription() {
        String description = "Bistro Bar";
        String location = "C";
        String price = "C";
        String cuisine = "C";
        try {
            Food myFood = new Food(description, location, price, cuisine, "U");
            assertEquals(description, myFood.toString());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void markComplete_validCallToMarkComplete_expectCompleted() {
        String description = "C";
        String location = "C";
        String price = "C";
        String cuisine = "C";

        try {
            Food myFood = new Food(description, location, price, cuisine, "U");
            assertEquals("U", myFood.getCompletionStatus());
            myFood.markComplete();
            assertEquals("C", myFood.getCompletionStatus());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
