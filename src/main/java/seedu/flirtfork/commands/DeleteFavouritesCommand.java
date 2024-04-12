package seedu.flirtfork.commands;

import seedu.flirtfork.ActivityList;
import seedu.flirtfork.Command;
import seedu.flirtfork.Favourites;
import seedu.flirtfork.FavouritesList;
import seedu.flirtfork.FoodList;
import seedu.flirtfork.GiftList;
import seedu.flirtfork.Storage;
import seedu.flirtfork.Ui;
import seedu.flirtfork.UserDetails;
import seedu.flirtfork.exceptions.FlirtForkException;

public class DeleteFavouritesCommand extends Command {
    private final int index;

    public DeleteFavouritesCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        try {
            if (index >= 0 && index < favourites.getFavourites().size()) {
                Favourites removedFavourite = favourites.getFavourites().get(index);
                favourites.deleteFavourite(index);
                ui.showFavourite("Poof! Sayonara~ This favourite has been removed: \n" + removedFavourite);
                ui.showFavourite("Now you have " + favourites.getFavourites().size() + " romantic treasures!\n" +
                        "Your journey of love and taste continues~");
            } else {
                throw new FlirtForkException("Index out of bounds: " + index);
            }
        } catch (FlirtForkException e) {
            ui.errorMessage("This number's playing hard to get. How about trying one that is in range?");
        }
    }
}

