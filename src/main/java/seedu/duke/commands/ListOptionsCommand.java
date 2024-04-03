package seedu.duke.commands;

import seedu.duke.ActivityList;
import seedu.duke.Command;
import seedu.duke.FavouritesList;
import seedu.duke.FoodList;
import seedu.duke.GiftList;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.UserDetails;
import seedu.duke.exceptions.FlirtForkException;

import java.util.Scanner;

/**
 * Represents a command to list options of a specified type (food, activities, or gifts).
 */
public class ListOptionsCommand extends Command {
    private String optionType;

    /**
     * Constructs a ListOptionsCommand object with the specified option type.
     * Will ask for the user's input until a valid option type is given for construction.
     *
     * @param optionType The type of options to list (food, activities, or gifts).
     */
    public ListOptionsCommand(String optionType) {
        while (!optionType.equals("food") && !optionType.equals("activities") && !optionType.equals("gifts")) {
            System.out.println("Invalid option! Please choose 'food', 'activities' or 'gifts'.");;
            Scanner scanner = new Scanner(System.in);
            optionType = scanner.nextLine().toLowerCase();
        }
        this.optionType = optionType;
    }

    /**
     * Executes the list options command based on the specified option type.
     *
     * @param favourites The list of favourites.
     * @param foods The list of foods.
     * @param activities The list of activities.
     * @param ui The user interface.
     * @param storage The storage component.
     * @param userDetails The user details.
     * @param gifts The list of gifts.
     * @throws FlirtForkException If an invalid option type is provided.
     */
    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities,
                        Ui ui, Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        assert (optionType.equals("food") || optionType.equals("activities")
                || optionType.equals("gifts")) : "optionType should be food, activities or gifts";

        switch(optionType) {
        case "food":
            printFoodList(ui, foods);
            break;
        case "activities":
            printActivityList(ui, activities);
            break;
        case "gifts":
            printGiftList(ui, gifts);
            break;
        default:
            throw new FlirtForkException("Invalid option! Please choose 'food', 'activities' or 'gifts'.");
        }
    }

    /**
     * Prints the list of food items.
     *
     * @param ui The user interface.
     * @param foods The list of foods to print.
     */
    private void printFoodList(Ui ui, FoodList foods) {
        ui.listFood();
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(i + 1 + ". " + foods.get(i));
        }
    }

    /**
     * Prints the list of activities.
     *
     * @param ui The user interface.
     * @param activities The list of activities to print.
     */
    private void printActivityList(Ui ui, ActivityList activities) {
        ui.listActivities();
        for (int i = 0; i < activities.size(); i++) {
            System.out.println(i + 1 + ". " + activities.get(i));
        }
    }

    /**
     * Prints the list of gifts.
     *
     * @param ui The user interface.
     * @param gifts The list of gifts to print.
     */
    private void printGiftList(Ui ui, GiftList gifts) {
        ui.listGifts();
        for (int i = 0; i < gifts.size(); i++) {
            System.out.println(i + 1 + ". " + gifts.get(i));
        }
    }
}