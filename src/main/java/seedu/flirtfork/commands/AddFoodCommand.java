package seedu.flirtfork.commands;

import java.util.Arrays;

import seedu.flirtfork.ActivityList;
import seedu.flirtfork.Command;
import seedu.flirtfork.FavouritesList;
import seedu.flirtfork.Food;
import seedu.flirtfork.FoodList;
import seedu.flirtfork.GiftList;
import seedu.flirtfork.Storage;
import seedu.flirtfork.Ui;
import seedu.flirtfork.UserDetails;
import seedu.flirtfork.exceptions.FlirtForkException;

/**
 * Command to add a food option to favourites.
 */
public class AddFoodCommand extends Command {
    private String description;

    /**
     * Constructs an AddFoodCommand with the specified description.
     *
     * @param description The description of the food option to add.
     */
    public AddFoodCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the list favourites command.
     *
     * @param favourites The list of favourites.
     * @param foods      The list of food options.
     * @param activities The list of activity options.
     * @param ui         The user interface.
     * @param storage    The storage component.
     * @param userDetails The user details.
     * @param gifts      The list of gift options.
     * @throws FlirtForkException If an error occurs during execution.
     */
    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        
                            
        String[] prices = {"C", "B", "A", "P", "S"};
        String[] locations = {"E", "W", "C", "S", "NE", "ACC"};
        String[] cuisines = {"W", "F", "J", "C", "T", "K", "I", "S"};
        String[] inputCommands = description.split(", ");
        // To deal with descriptions with multiple spaces: "Bistro C C W" versus "Bistro Bar C C W"
        try {
            String inputtedDescription = inputCommands[0];
            String inputtedLocation = inputCommands[1];
            String inputtedPrice = inputCommands[2];
            String inputtedCuisine = inputCommands[3];

            // Used to verify correct inputs
            if (!Arrays.asList(prices).contains(inputtedPrice)){
                System.out.println("Invalid price/format given! Perhaps you could try again?");
                System.out.println("Please type in the command 'help' to view our Legend for reference");
            } else if (!Arrays.asList(locations).contains(inputtedLocation)) {
                System.out.println("Invalid location/format given! Perhaps you could try again?");
                System.out.println("Please type in the command 'help' to view our Legend for reference");  
            } else if (!Arrays.asList(cuisines).contains(inputtedCuisine)) {
                System.out.println("Invalid cuisine/format given! Perhaps you could try again?");
                System.out.println("Please type in the command 'help' to view our Legend for reference"); 
            } else {
                Food newFood = new Food(inputtedDescription, inputtedLocation, inputtedPrice, inputtedCuisine, "U");

                // Add to favourites database
                favourites.addFavourite(newFood);
                System.out.println("Cupid's arrow strikes! This is now in your favourites. \n" + newFood);
                ui.showFavourite("You've collected " + favourites.getFavourites().size() + " romantic treasures!");

                // Add to food database
                foods.add(newFood);
                storage.saveFood(foods);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Hmm... you may have entered the wrong number of fields. How about you try again?");
            System.out.println("Follow this format: 'food NAME_OF_EATERY, LOCATION, PRICE, CUISINE'");
        }
    }
}
