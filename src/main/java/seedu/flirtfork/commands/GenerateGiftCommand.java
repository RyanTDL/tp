package seedu.flirtfork.commands;

import seedu.flirtfork.ActivityList;
import seedu.flirtfork.Command;
import seedu.flirtfork.FavouritesList;
import seedu.flirtfork.FoodList;
import seedu.flirtfork.Gift;
import seedu.flirtfork.GiftList;
import seedu.flirtfork.Storage;
import seedu.flirtfork.Ui;
import seedu.flirtfork.UserDetails;
import seedu.flirtfork.exceptions.FlirtForkException;

public class GenerateGiftCommand extends Command {
    private static final String HORIZONTAL = "____________________________________________________________";
    private final String gender;

    public GenerateGiftCommand(String gender) {
        this.gender = gender;
    }

    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        String userSatisfied;

        Gift gift = gifts.getRandomGift(this.gender);
        System.out.println(gift);
        System.out.println("-> Satisfied with the gift suggestion? [Yes/No]");
        System.out.println("-> Else, feel free to stop idea generation using the command 'cancel'");
        System.out.println(HORIZONTAL);

        do {

            userSatisfied = ui.readCommand().toLowerCase();
            if (userSatisfied.equals("yes")) {
                System.out.println("This gift is about to make a love story even sweeter.");
                gift.markComplete();
                break;
            } else if (userSatisfied.equals("no")) {
                System.out.println("Not satisfied? That's okay! \n" +
                        "Regenerating a new gift idea...");
                gifts.getRandomGift(this.gender);
                System.out.println(gift);
                System.out.println("-> Satisfied with the gift suggestion? [Yes/No]");
                System.out.println("-> Else, feel free to stop idea generation using the command 'cancel'");
                System.out.println(HORIZONTAL);
            } else if (userSatisfied.equals("cancel")) {
                System.out.println("Taking a break? That's okay! \n" +
                        "Remember, great ideas need their own time to unwrap.");
                break;
            } else {
                ui.ideaSatisfiedErrorMessage();
            }
        } while (true);

        storage.saveGift(gifts);
    }
}
