package seedu.flirtfork.commands;

import seedu.flirtfork.ActivityList;
import seedu.flirtfork.Command;
import seedu.flirtfork.FavouritesList;
import seedu.flirtfork.FoodList;
import seedu.flirtfork.GiftList;
import seedu.flirtfork.Storage;
import seedu.flirtfork.Ui;
import seedu.flirtfork.UserDetails;
import seedu.flirtfork.exceptions.FlirtForkException;

import java.io.IOException;

/**
 * A command that is executed to safely exit the application.
 * This command handles the saving of all current application data,
 * including favourites, foods, activities, and gifts to ensure no data loss occurs upon exit.
 */
public class ExitCommand extends Command {
    /**
     * Executes the command to exit the application.
     * It first saves all relevant data to their respective files and then displays an exit message.
     * If any errors occur during the save operation, an error message is displayed.
     *
     * @param favourites The list of favourite items to save.
     * @param foods The list of food items to save.
     * @param activities The list of activities to save.
     * @param ui The user interface to handle interactions.
     * @param storage The storage component used for data persistence.
     * @param userDetails The user details.
     * @param gifts The list of gifts to save.
     * @throws FlirtForkException If an error occurs that affects the execution flow.
     */
    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {

        try {
            storage.saveFavourites(favourites.getFavourites());
            storage.saveActivity(activities);
            storage.saveFood(foods);
            storage.saveGift(gifts);
            ui.exitMessage();
        } catch (IOException e) {
            ui.errorMessage("Yikes! Our love potion spilled and couldn't save your data! " + e.getMessage());
        }
    }
}
