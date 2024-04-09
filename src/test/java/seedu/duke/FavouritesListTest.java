package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FavouritesListTest {

    @Test
    void addFavourite_validFavourite_addedToFavouritesList() {
        Favourites favourite = new Favourites("Test Favourite");
        FavouritesList favouritesList = new FavouritesList();
        favouritesList.addFavourite(favourite);
        assertTrue(favouritesList.getFavourites().contains(favourite));
    }

    @Test
    void deleteFavourite_validIndex_favouriteDeletedFromFavouritesList() {
        Favourites favourite = new Favourites("Test Favourite");
        FavouritesList favouritesList = new FavouritesList();
        favouritesList.addFavourite(favourite);
        favouritesList.deleteFavourite(0);
        assertFalse(favouritesList.getFavourites().contains(favourite));
    }

    @Test
    void getFormattedFavourites_emptyFavouritesList_returnsBlankCanvasMessage() {
        FavouritesList favouritesList = new FavouritesList();
        assertEquals("A blank canvas! Let's fill it with some love~", favouritesList.getFormattedFavourites());
    }

    @Test
    void getFormattedFavourites_nonEmptyFavouritesList_returnsFormattedString() {
        FavouritesList favouritesList = new FavouritesList();
        favouritesList.addFavourite(new Favourites("Favourite 1"));
        favouritesList.addFavourite(new Favourites("Favourite 2"));
        String expected = "1. Favourite 1\n2. Favourite 2";
        assertEquals(expected, favouritesList.getFormattedFavourites());
    }

    @Test
    void findFavourites_matchingKeyword_returnsMatchingFavourites() {
        FavouritesList favouritesList = new FavouritesList();
        favouritesList.addFavourite(new Favourites("Apple"));
        favouritesList.addFavourite(new Favourites("Banana"));
        favouritesList.addFavourite(new Favourites("Orange"));
        assertEquals(2, favouritesList.findFavourites("an").size());
    }
}
