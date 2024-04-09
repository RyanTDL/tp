package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class FavouritesTest {
    //methodBeingTested_conditionToTest_ExpectedOutcome
    @Test
    void getDescription_validDescription_expectSameDescription() {
        String description = "Test Favourite";
        try {
            Favourites favourite = new Favourites(description);
            assertEquals(description, favourite.getDescription());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }

    }

    @Test
    void toString_validDescription_expectSameDescription() {
        String description = "Test Favourite";
        try {
            Favourites favourite = new Favourites(description);
            assertEquals(description, favourite.toString());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void toFileFormat_validDescription_expectSameDescription() {
        String description = "Test Favourite";
        try {
            Favourites favourite = new Favourites(description);
            assertEquals(description, favourite.toFileFormat());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
