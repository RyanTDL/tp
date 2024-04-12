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

public class ListFavouritesCommand extends Command {
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
            FlirtForkException exception = new FlirtForkException("An error occurred while listing favourites: " + e.getMessage());
            exception.initCause(e);
            throw exception;
        }
    }
}
