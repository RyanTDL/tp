package seedu.flirtfork;

import seedu.flirtfork.commands.ExitCommand;
import seedu.flirtfork.commands.UserDetailsCommand;
import seedu.flirtfork.exceptions.FlirtForkException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The main class that initializes and runs the FlirtFork application.
 * It sets up the environment, loads necessary data,
 * and handles the main interaction loop where commands are processed.
 */
public class FlirtFork {
    private static final String FILE_PATH = "./data/FlirtFork.txt";

    private static final String HORIZONTAL = "____________________________________________________________";
    private static FoodList foods;
    private FavouritesList favourites;
    private ActivityList activities;
    private Ui ui;
    private Storage storage;
    private UserDetails userDetails;
    private GiftList gifts;

    /**
     * Constructor for FlirtFork class.
     *
     * @param filePath The file path to store data.
     */
    public FlirtFork(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            favourites = storage.loadFavourites();
            userDetails = storage.loadUserDetails();

            if (userDetails.getName().equals("NOT SET")) {
                foods = new FoodList(storage.loadFoodFirstTime());
                activities = new ActivityList(storage.loadActivityFirstTime());
                gifts = new GiftList(storage.loadGiftFirstTime());
            } else {
                foods = new FoodList(storage.loadFood());
                activities = new ActivityList(storage.loadActivity());
                gifts = new GiftList(storage.loadGift());                
            }
        } catch (FileNotFoundException e) {
            ui.errorMessage("File not found. Starting with an empty task list :)");
            favourites = new FavouritesList(new ArrayList<>());
        }
    }

    /**
     * Starts the application's main loop.
     * It handles user input, processes commands, and continues until an exit command is called.
     * Depending on whether the user details are set, it may prompt for initial setup.
     */
    public void run() {
        if (userDetails.getName().equals("NOT SET")) {
            ui.firstSetUpMessage();
            UserDetailsCommand userDetailsCommand = new UserDetailsCommand();
            userDetailsCommand.execute(favourites, foods, activities, ui, storage, userDetails, gifts);
        } else {
            ui.greetingMessage(userDetails.getAnniversary());
        }

        boolean isExit = false;
        while(!isExit) {
            String userInput = ui.readCommand();
            try {
                Command command = Parser.parseCommand(userInput, userDetails);
                command.execute(favourites, foods, activities, ui, storage, userDetails, gifts);
                if(command instanceof ExitCommand) {
                    isExit = true;
                }
                System.out.println(HORIZONTAL);
            } catch (FlirtForkException e) {
                ui.errorMessage(e.getMessage());
            }
        }
    }

    /**
     * Main entry point of the application.
     * It creates an instance of FlirtFork and starts the application.
     *
     * @param args The command line arguments passed to the application. 
     */
    public static void main(String[] args) {
        FlirtFork flirtFork = new FlirtFork(FILE_PATH);
        assert foods.get(0).toString().equals("25 Degrees") : "first entry in food database must be 25 degrees";
        flirtFork.run();
    }
}
