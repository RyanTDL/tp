package seedu.duke.commands;

import seedu.duke.Activity;
import seedu.duke.ActivityList;
import seedu.duke.Command;
import seedu.duke.FavouritesList;
import seedu.duke.Food;
import seedu.duke.FoodList;
import seedu.duke.GiftList;
import seedu.duke.Itinerary;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.UserDetails;
import seedu.duke.exceptions.FlirtForkException;

public class GenerateItineraryCommand extends Command {
    private String description;


    public GenerateItineraryCommand(String description){
        this.description = description;
    }

    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        String userSatisfied;
        Food food1;
        Food food2;
        Activity activity1;
        Activity activity2;

        try {
            String[] splitDescription = description.split(", ");
            String preferredLocation = splitDescription[0];
            String preferredPrice = splitDescription[1];            
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
            } else {
                System.out.println("We apologise! Perhaps you could try again?");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Hmm... you may have entered the wrong number of fields. How about you try again?");
            System.out.println("Follow this format: 'itinerary LOCATION, PRICE'");
        } catch (IllegalArgumentException e) {
            System.out.println("We could not generate a suitable itinerary based on your inputs! Sorry!!");
        } catch (FlirtForkException e) {
            System.out.println("We could not generate a suitable itinerary based on your inputs! Sorry!!"); 
            System.out.println("Perhaps you could try a different location or budget?");
        }
    }
}

