package seedu.flirtfork;

import seedu.flirtfork.exceptions.FlirtForkException;

public abstract class Command {
    public abstract void execute(FavouritesList favourites, FoodList foods, ActivityList activities,
                                 Ui ui, Storage storage, UserDetails userDetails, GiftList gifts)
                                 throws FlirtForkException;

}
