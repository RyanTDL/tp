package seedu.duke.commands;

import seedu.duke.ActivityList;
import seedu.duke.Command;
import seedu.duke.FavouritesList;
import seedu.duke.FoodList;
import seedu.duke.Gift;
import seedu.duke.GiftList;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.UserDetails;
import seedu.duke.exceptions.FlirtForkException;

public class GenerateGiftCommand extends Command {
    private static final String HORIZONTAL = "____________________________________________________________";
    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        String userSatisfied;

        do {
            Gift gift = gifts.getRandomGift();
            System.out.println(gift);
            System.out.println("Satisfied with the gift suggestion? [Yes/No]");
            System.out.println(HORIZONTAL);
            userSatisfied = ui.readCommand().toLowerCase();
            if (userSatisfied.equals("yes")) {
                System.out.println("This gift is about to make a love story even sweeter.");
                gift.markComplete();
                break;
            } else if (userSatisfied.equals("stop")) {
                System.out.println("Taking a break? That's okay! \n" +
                        "Remember, great ideas need their own time to unwrap.");
                break;
            } else {
                System.out.println("No worries, love's journey has many paths. Let's try another! ");
            }
        } while (true);

        storage.saveGift(gifts);
    }
}
