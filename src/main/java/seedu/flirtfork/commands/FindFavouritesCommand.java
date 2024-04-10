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

import java.util.ArrayList;

public class FindFavouritesCommand extends Command {
    private String keyword;
    public FindFavouritesCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        ArrayList<Favourites> matchingFavourites = favourites.findFavourites(keyword);
        ui.showMatchingFavourites(matchingFavourites);
    }
}
