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

/**
 * Represents a command to display help messages to the user. This command is used
 * to guide users on how to use the application, providing a brief overview of
 * available commands and functionalities.
 */
public class HelpCommand extends Command {
    /**
     * Executes the process of displaying help messages to the user. This method calls
     * upon the UI component to show predefined help messages, offering guidance and
     * instructions for using the application effectively.
     *
     * @param favourites  The list of user's favourite items, not used in this command.
     * @param foods       The list of food items available, not used in this command.
     * @param activities  The list of available activities, not used in this command.
     * @param ui          The user interface component responsible for interactions.
     * @param storage     The storage handler for saving or retrieving data, not used in this command.
     * @param userDetails The details of the user, not used in this command.
     * @param gifts       The list of gifts available, not used in this command.
     * @throws FlirtForkException If any application-specific error occurs.
     */
    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        if (ui == null) {
            throw new FlirtForkException("UI component must not be null.");
        }
        System.out.println("I know you are excited to Flirt & Fork :) Here's how: \n");
        ui.helpMessage();
        ui.showMessage("Send me 'help' if you're new!");
    }
}
