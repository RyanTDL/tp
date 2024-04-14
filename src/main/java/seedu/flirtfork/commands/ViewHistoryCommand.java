package seedu.flirtfork.commands;

import seedu.flirtfork.Activity;
import seedu.flirtfork.ActivityList;
import seedu.flirtfork.Command;
import seedu.flirtfork.FavouritesList;
import seedu.flirtfork.Food;
import seedu.flirtfork.FoodList;
import seedu.flirtfork.Gift;
import seedu.flirtfork.GiftList;
import seedu.flirtfork.Storage;
import seedu.flirtfork.Ui;
import seedu.flirtfork.UserDetails;
import seedu.flirtfork.exceptions.FlirtForkException;

/**
 * Command to view the user's history.
 */
public class ViewHistoryCommand extends Command {
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
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        int foodCount = 0;
        int activityCount = 0;
        int giftCount = 0;

        System.out.println("These are the activities you have marked:");
        for (int i=0; i<activities.size(); i++) {
            Activity oneActivity = activities.get(i);
            String completionStatus = oneActivity.getCompletionStatus();
            if (completionStatus.equals("C")) {
                System.out.println(++activityCount + ". " + oneActivity);
            }
        }

        System.out.println("");
        System.out.println("These are the restaurants you have marked:");
        for (int i=0; i<foods.size(); i++) {
            Food oneFood = foods.get(i);
            String completionStatus = oneFood.getCompletionStatus();
            if (completionStatus.equals("C")) {
                System.out.println(++foodCount + ". " + oneFood);
            }
        }

        System.out.println("");
        System.out.println("These are the gifts you've marked:");
        for (int i=0; i<gifts.size(); i++) {
            Gift oneGift = gifts.get(i);
            String completionStatus = oneGift.getCompletionStatus();
            if (completionStatus.equals("C")) {
                System.out.println(++giftCount + ". " + oneGift);
            }
        }
    }
}
