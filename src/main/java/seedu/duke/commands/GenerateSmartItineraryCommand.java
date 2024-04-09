package seedu.duke.commands;

import seedu.duke.Activity;
import seedu.duke.ActivityList;
import seedu.duke.Command;
import seedu.duke.FavouritesList;
import seedu.duke.Food;
import seedu.duke.FoodList;
import seedu.duke.GiftList;
import seedu.duke.SmartItinerary;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.UserDetails;
import seedu.duke.exceptions.FlirtForkException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Represents a command to generate a smart itinerary based on user preferences.
 * This command considers the user's preferred location and cuisine to create
 * a personalized itinerary that includes food and activities.
 */
public class GenerateSmartItineraryCommand extends Command {
    private static final Logger LOGGER = Logger.getLogger(GenerateItineraryCommand.class.getName());
    private String preferredLocation;
    private String preferredCuisine;

    /**
     * Creates a GenerateSmartItineraryCommand with specified user details.
     * 
     * @param userDetails The details of the user including preferred location and
     *                    cuisine.
     */
    public GenerateSmartItineraryCommand(UserDetails userDetails) {
        if (userDetails == null) {
            LOGGER.log(Level.SEVERE, "User details are not provided at command creation.");
            throw new IllegalArgumentException("User details are required at command creation.");
        }
        this.preferredLocation = userDetails.getLocation();
        this.preferredCuisine = userDetails.getCuisine();
    }

    /**
     * Executes the smart itinerary generation process. It selects food and
     * activities
     * based on the user's preferences and creates an itinerary. If the preferences
     * are too unique or if any error occurs, it logs a severe error and informs the
     * user.
     * 
     * @param favourites  The list of favourite items of the user.
     * @param foods       The list of available foods.
     * @param activities  The list of available activities.
     * @param ui          The user interface to interact with the user.
     * @param storage     The storage handler to save or load data.
     * @param userDetails The details of the user, including preferences.
     * @param gifts       The list of gifts available for the user.
     * @throws FlirtForkException If an error specific to the Flirt Fork application
     *                            occurs.
     */
    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui, Storage storage,
            UserDetails userDetails, GiftList gifts) throws FlirtForkException {

        String userSatisfied;
        Food food1;
        Food food2;
        Activity activity1;
        Activity activity2;

        try {
            food1 = foods.getCustomisedFood(preferredLocation, preferredCuisine);
            activity1 = activities.getCustomisedActivity(preferredLocation);
            // Ensure activity1 and activity2 are different
            do {
                food2 = foods.getRandomFood();
            } while (food2.getDescription().equals(food1.getDescription()));
            // Ensure food1 and food2 are different
            do {
                activity2 = activities.getRandomActivity();
            } while (activity2.getDescription().equals(activity1.getDescription()));
            SmartItinerary itinerary = new SmartItinerary(food1, food2, activity1, activity2);
            System.out.println(itinerary);

            System.out.println("Are you satisfied with the date idea? [Yes/No]");

            while (true) {
                userSatisfied = ui.readCommand().toLowerCase();
                if (userSatisfied.equalsIgnoreCase("yes")) {
                    System.out.println("That's great! Enjoy your date!");
                    food1.markComplete();
                    food2.markComplete();
                    activity1.markComplete();
                    activity2.markComplete();
                    storage.saveFood(foods);
                    storage.saveActivity(activities);
                    return;
                } else if (userSatisfied.equalsIgnoreCase("no")) {
                    System.out.println("I apologise for not being smart enough. Please try again next time!");
                    return;
                } else {
                    ui.ideaSatisfiedErrorMessage();
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println(preferredCuisine);
            System.out.println(preferredLocation);
            System.out.println("You are too unique of an individual for smart itineraries! Sorry!!");
            LOGGER.log(Level.SEVERE, "Invalid arguments given");
        } catch (FlirtForkException e) {
            System.out.println("I could not generate a suitable itinerary based on your personal details!");
            System.out.println("I'm not smart enough for your default preferences, try 'itinerary' command instead!");
        }

    }

}
