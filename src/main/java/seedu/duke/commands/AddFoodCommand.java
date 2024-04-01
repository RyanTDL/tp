package seedu.duke.commands;

import java.util.Arrays;

import seedu.duke.ActivityList;
import seedu.duke.Command;
import seedu.duke.FavouritesList;
import seedu.duke.Food;
import seedu.duke.FoodList;
import seedu.duke.GiftList;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.UserDetails;
import seedu.duke.exceptions.FlirtForkException;

public class AddFoodCommand extends Command {
    private String description;
    public AddFoodCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        
                            
        String[] prices = {"C", "B", "A", "P", "S"};
        String[] locations = {"E", "W", "C", "S", "NE", "ACC"};
        String[] inputCommands = description.split(" ");
        // To deal with descriptions with multiple spaces: "Bistro C C W" versus "Bistro Bar C C W"
        try {
            String inputtedDescription = String.join(" ", 
                                        Arrays.copyOfRange(inputCommands, 0, inputCommands.length - 3));
            String inputtedLocation = inputCommands[inputCommands.length-3];
            String inputtedPrice = inputCommands[inputCommands.length-2];
            String inputtedCuisine = inputCommands[inputCommands.length-1];

            // Used to verify correct number of inputs
            if (inputtedLocation.length()>3 || inputtedPrice.length()!=1) {
                System.out.println("Invalid inputs entered");
                System.out.println("Please follow the format: 'food NAME_OF_EATERY LOCATION PRICE CUISINE'");
            } else if (!Arrays.asList(prices).contains(inputtedPrice) || 
                    !Arrays.asList(locations).contains(inputtedLocation)){
                System.out.println("Invalid price/location given");
                System.out.println("Please type in the command 'help' to view our Legend for reference");
            } else {
                Food food = new Food("[Food] " +inputtedDescription, inputtedLocation, 
                        inputtedPrice, inputtedCuisine, "U");
                favourites.addFavourite(food);
                System.out.println("Cupid's arrow strikes! This is now in your favourites. \n" + food);
                ui.showFavourite("You've collected " + favourites.getFavourites().size() + " romantic treasures!");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid inputs entered");
            System.out.println("Please follow the format: 'food NAME_OF_EATERY LOCATION PRICE CUISINE'");
        }
    }
}
