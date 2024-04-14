package seedu.flirtfork.commands;

import java.util.Arrays;
import seedu.flirtfork.Activity;
import seedu.flirtfork.ActivityList;
import seedu.flirtfork.Command;
import seedu.flirtfork.FavouritesList;
import seedu.flirtfork.Food;
import seedu.flirtfork.FoodList;
import seedu.flirtfork.GiftList;
import seedu.flirtfork.Itinerary;
import seedu.flirtfork.Storage;
import seedu.flirtfork.Ui;
import seedu.flirtfork.UserDetails;
import seedu.flirtfork.exceptions.FlirtForkException;

/**
 * Represents a command to generate a date itinerary for the user based on a specified category of food and activity.
 * The user can choose whether they are satisfied with the itinerary or not.
 * If the user is satisfied, the chosen food and activity items are marked as completed
 * If the user is not satisfied, the command stops and the user is prompted to try again
 */
public class GenerateItineraryCommand extends Command {
    private String description;

    public GenerateItineraryCommand(String description){
        this.description = description;
    }

    /**
     * Generates a date itinerary consisting of 2 food items and 2 activities.
     * Food and activites generated are based on the chosen location and price category specified by the user
     * Asks the user if they are satisfied with the idea. If satisfied, marks the chosen food
     * and activity as complete and saves the changes to storage. If not satisfied, prompts
     * the user to try again.
     *
     * @param favourites The user's list of favourite items (not directly used in this method).
     * @param foods The list of food items.
     * @param activities The list of activities.
     * @param ui The user interface to interact with the user for input and output.
     * @param storage The storage handler to save changes to food and activity lists.
     * @param userDetails The UserDetails object containing user details (not directly used in this method).
     * @param gifts The list of gifts (not directly used in this method). 
     * @throws FlirtForkException If an error occurs during the execution of the command.
     */
    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        String userSatisfied;
        Food food1;
        Food food2;
        Activity activity1;
        Activity activity2;

        String[] prices = {"C", "B", "A", "P", "S"};
        String[] locations = {"E", "W", "C", "S", "NE", "ACC"};

        try {
            String[] splitDescription = description.split(", ");
            String preferredLocation = splitDescription[0];
            String preferredPrice = splitDescription[1];            

            // Verify whether price/location entered correctly
            if (!Arrays.asList(prices).contains(preferredPrice)){
                System.out.println("Invalid price/format given! Perhaps you could try again?");
                System.out.println("Please type in the command 'help' to view our Legend for reference");
                return;
            } else if (!Arrays.asList(locations).contains(preferredLocation)) {
                System.out.println("Invalid location/format given! Perhaps you could try again?");
                System.out.println("Please type in the command 'help' to view our Legend for reference");
                return;            
            }

            food1 = foods.getFilteredFood(preferredLocation, preferredPrice);
            activity1 = activities.getFilteredActivity(preferredLocation, preferredPrice);
            // Ensure activity1 and activity2 are different
            do {
                food2 = foods.getFilteredFood(preferredLocation, preferredPrice);
            } while (food2.getDescription().equals(food1.getDescription()));
            // Ensure food1 and food2 are different
            do {
                activity2 = activities.getFilteredActivity(preferredLocation, preferredPrice);
            } while (activity2.getDescription().equals(activity1.getDescription()));
            Itinerary itinerary = new Itinerary(food1, food2, activity1, activity2);
            System.out.println(itinerary);

            System.out.println("Are you satisfied with the itinerary? [Yes/No]");
            userSatisfied = ui.readCommand().toLowerCase();
            if (userSatisfied.equals("yes")) {
                System.out.println("That's great! Enjoy your date!");
                food1.markComplete();
                food2.markComplete();
                activity1.markComplete();
                activity2.markComplete();
                storage.saveFood(foods);
                storage.saveActivity(activities);
                return;
            } else if (userSatisfied.equals("no")) {
                System.out.println("We apologise! Perhaps you could try again?");
            } else {
                System.out.println("Sorry, I did not understand that command! Stopping itinerary generation...");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Hmm... you may have entered the wrong number of fields. How about you try again?");
            System.out.println("Follow this format: 'itinerary LOCATION, PRICE'");
        } catch (IllegalArgumentException e) {
            System.out.println("We could not generate a suitable itinerary based on your inputs! Sorry!!");
        } catch (FlirtForkException e) {
            System.out.println("Hmm.. we ran out of suitable ideas based on your current budget/location!");  
            System.out.println("Perhaps you could try a different location or budget?");
            System.out.println("Feel free to add more to our database using the 'food'/'activity' command!");
        }
    }
}

