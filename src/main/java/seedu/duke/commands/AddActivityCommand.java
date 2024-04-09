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

    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {

        String[] prices = {"C", "B", "A", "P", "S"};
        String[] locations = {"E", "W", "C", "S", "NE", "ACC"};
        String[] inputCommands = description.split(", ");
        try {
            String inputtedDescription = inputCommands[0];
            String inputtedLocation = inputCommands[1];
            String inputtedPrice = inputCommands[2];

            // Used to verify correct inputs
            if (!Arrays.asList(prices).contains(inputtedPrice)){
                System.out.println("Invalid price/format given! Perhaps you could try again?");
                System.out.println("Please type in the command 'help' to view our Legend for reference");
            } else if (!Arrays.asList(locations).contains(inputtedLocation)) {
                System.out.println("Invalid location/format given! Perhaps you could try again?");
                System.out.println("Please type in the command 'help' to view our Legend for reference");   
            } else {
                Activity newActivity = new Activity(inputtedDescription, inputtedLocation, inputtedPrice, "U");

                // Add to favourites database
                favourites.addFavourite(newActivity);
                System.out.println("Cupid's arrow strikes! This is now in your favourites. \n" + newActivity);
                ui.showFavourite("You've collected " + favourites.getFavourites().size() + " romantic treasures!");

                // Add to activity database
                activities.add(newActivity);
                storage.saveActivity(activities);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Hmm... you may have entered the wrong number of fields. How about you try again?");
            System.out.println("Follow this format: 'activity NAME, LOCATION, PRICE'");
        }
    }
}




