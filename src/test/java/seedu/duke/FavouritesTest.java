package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FavouritesTest {
    //methodBeingTested_conditionToTest_ExpectedOutcome
    @Test
    void getDescription_validDescription_expectSameDescription() {
        String description = "Test Favourite";
        Favourites favourite = new Favourites(description);
        assertEquals(description, favourite.getDescription());
    }

    @Test
    void toString_validDescription_expectSameDescription() {
        String description = "Test Favourite";
        Favourites favourite = new Favourites(description);
        assertEquals(description, favourite.toString());
    }

    @Test
    void toFileFormat_validDescription_expectSameDescription() {
        String description = "Test Favourite";
        Favourites favourite = new Favourites(description);
        assertEquals(description, favourite.toFileFormat());
    }
}