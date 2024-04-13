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

/**
 * Command to list the user's favourites.
 */
public class ListFavouritesCommand extends Command {
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
        if (favourites == null) {
            throw new FlirtForkException("Favourites list is null.");
        }

        if (ui == null) {
            throw new FlirtForkException("UI is null.");
        }

        try {
            if (favourites.isEmpty()) {
                ui.showFavourite("No treasures found this time. Let's fill it with some love!");
            } else {
                ui.listFavourites(favourites);
            }
        } catch (Exception e) {
            FlirtForkException exception = new FlirtForkException("An error occurred while listing favourites: "
                    + e.getMessage());
            exception.initCause(e);
            throw exception;
        }
    }
}
