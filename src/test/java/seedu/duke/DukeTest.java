package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.exceptions.FlirtForkException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DukeTest {
    private static final String FILE_PATH = "./data/FlirtFork.txt";
    private static final String FOOD_FILE_PATH = "./data/FoodList.txt";
    private static final String ACTIVITY_FILE_PATH = "./data/ActivityList.txt";
    private Ui ui = new Ui();
    private Storage storage = new Storage(FILE_PATH, FOOD_FILE_PATH, ACTIVITY_FILE_PATH);
    private FavouritesList favourites;
    private FoodList foods;
    private ActivityList activities;

    public void sampleTest() {
        assertTrue(true);
    }

    @Test
    public void testGenerateItineraryCommand() {
        try {
            favourites = new FavouritesList(storage.loadFavourites());
            foods = new FoodList(storage.loadFood());
            activities = new ActivityList(storage.loadActivity());
        } catch (FileNotFoundException e) {
            ui.errorMessage("File not found. Starting with an empty task list :)");
            favourites = new FavouritesList(new ArrayList<>());
        }
        GenerateItineraryCommand generateItineraryCommand = new GenerateItineraryCommand();
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            System.setOut(printStream);
            generateItineraryCommand.execute(favourites, foods, activities, ui, storage);
            String output = outputStream.toString();
            assertTrue(output.contains("You can do"));
            assertTrue(output.contains("and have a nice meal at"));
            assertTrue(output.length() > 36);
            System.setOut(System.out);
        } catch (FlirtForkException e) {
            ui.errorMessage(e.getMessage());
        }
    }
}
