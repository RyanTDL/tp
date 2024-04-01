package seedu.duke.commands;

import java.util.Arrays;

import seedu.duke.Activity;
import seedu.duke.ActivityList;
import seedu.duke.Command;
import seedu.duke.FavouritesList;
import seedu.duke.FoodList;
import seedu.duke.GiftList;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.UserDetails;
import seedu.duke.exceptions.FlirtForkException;


public class AddActivityCommand extends Command {
    private String description;
    public AddActivityCommand(String description) {
        this.description = description;
    }

    private static final String[] prices = {"C", "B", "A", "P", "S"};
    private static final String[] locations = {"E", "W", "C", "S", "NE", "ACC"};

    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {

        String[] inputCommands = description.split(" ");
        // To deal with descriptions with multiple spaces: "Bistro C C W" versus "Bistro Bar C C W"
        try {
            String inputtedDescription = String.join(" ", 
                                        Arrays.copyOfRange(inputCommands, 0, inputCommands.length - 2));
            String inputtedLocation = inputCommands[inputCommands.length-2];
            String inputtedPrice = inputCommands[inputCommands.length-1];

            // Used to verify correct number of inputs
            if (inputtedLocation.length()>3 || inputtedPrice.length()!=1) {
                System.out.println("Invalid inputs entered");
                System.out.println("Please follow the format: 'activity NAME_OF_ACTIVITY LOCATION PRICE'");
            } else if (!Arrays.asList(prices).contains(inputtedPrice) || !Arrays.asList(locations).contains(inputtedLocation)){
                System.out.println("Invalid price/location given");
                System.out.println("Please type in the command 'help' to view our Legend for reference");
            } else {
                Activity activity = new Activity(inputtedDescription, inputtedLocation, inputtedPrice, "U");
                favourites.addFavourite(activity);
                System.out.println("Cupid's arrow strikes! This is now in your favourites. \n" + activity);
                ui.showFavourite("You've collected " + favourites.getFavourites().size() + " romantic treasures!");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid inputs entered");
            System.out.println("Please follow the format: 'activity NAME_OF_ACTIVITY LOCATION PRICE'");
        }
    }
}




