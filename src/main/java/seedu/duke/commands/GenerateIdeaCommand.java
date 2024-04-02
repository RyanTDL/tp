package seedu.duke.commands;

import seedu.duke.Activity;
import seedu.duke.ActivityList;
import seedu.duke.Command;
import seedu.duke.FavouritesList;
import seedu.duke.Food;
import seedu.duke.FoodList;
import seedu.duke.GiftList;
import seedu.duke.Idea;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.UserDetails;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a command to generate a date idea for the user based on a random combination of food and activity.
 * The user can choose whether they are satisfied with the idea or not.
 */
public class GenerateIdeaCommand extends Command {

    private static Logger logger = Logger.getLogger("IdeaLogger");

    /**
     * Generates a date idea consisting of a random food item and a random activity.
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
     */
    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts)  {
        String userSatisfied;

        Food food = foods.getRandomFood();
        Activity activity = activities.getRandomActivity();
        Idea idea = new Idea(food, activity);
        System.out.println(idea);
        System.out.println("Are you satisfied with the date idea? [Yes/No]");

        while (true) {
            userSatisfied = ui.readCommand().toLowerCase();
            if (userSatisfied.equalsIgnoreCase("yes")) {
                System.out.println("That's great! Enjoy your date!");
                food.markComplete();
                activity.markComplete();
                storage.saveFood(foods);
                storage.saveActivity(activities);
                return;
            } else if (userSatisfied.equalsIgnoreCase("no")) {
                System.out.println("Regenerating a new date idea...");
                food = foods.getRandomFood();
                activity = activities.getRandomActivity();
                idea.setFood(food);
                idea.setActivity(activity);
                System.out.println(idea);
                System.out.println("Are you satisfied with the date idea? [Yes/No]");
            } else {
                ui.ideaSatisfiedErrorMessage();
                logger.log(Level.WARNING, "input error");
            }
        }
    }
}
