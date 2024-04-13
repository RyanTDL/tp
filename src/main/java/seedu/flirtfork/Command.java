package seedu.flirtfork;

import seedu.flirtfork.exceptions.FlirtForkException;

/**
 * Abstract class for representing a command within the application.
 * All specific command types inherit from this class and implement the execute method,
 * defining how they interact with the application's state.
 */
public abstract class Command {
    /**
     * Executes the specific command and modifies the application's state accordingly.
     *
     * @param favourites The list of user's favourite items.
     * @param foods The list of foods available.
     * @param activities The list of activities available.
     * @param ui The user interface component used for all user interactions.
     * @param storage The storage component used for data persistence.
     * @param userDetails The details about the user necessary for some operations.
     * @param gifts The list of gifts available.
     * @throws FlirtForkException if there is an issue during the execution of the command.
     */
    public abstract void execute(FavouritesList favourites, FoodList foods, ActivityList activities,
                                 Ui ui, Storage storage, UserDetails userDetails, GiftList gifts)
                                 throws FlirtForkException;

}
