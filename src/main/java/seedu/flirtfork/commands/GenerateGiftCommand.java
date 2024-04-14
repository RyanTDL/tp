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

/**
 * This command generates a random gift suggestion based on the gender specified.
 * It allows users to continually receive gift suggestions until they are satisfied,
 * or choose to cancel the process.
 */
public class GenerateGiftCommand extends Command {
    private static final String HORIZONTAL = "____________________________________________________________";
    private final String gender;

    /**
     * Constructs a new GenerateGiftCommand with the specified gender.
     *
     * @param gender The gender filter for the gift suggestions (male, female, unisex, or any).
     */
    public GenerateGiftCommand(String gender) {
        this.gender = gender;
    }

    /**
     * Executes the gift suggestion process. Prompts the user with randomly generated
     * gift suggestions based on the specified gender filter until they are satisfied
     * or choose to cancel the process.
     *
     * @param favourites List of user's favourite items.
     * @param foods List of food items available.
     * @param activities List of activities available.
     * @param ui UI interface to interact with the user.
     * @param storage The storage handler for saving and retrieving data.
     * @param userDetails The user details for personalized suggestions.
     * @param gifts The list of gifts available.
     * @throws FlirtForkException If an error occurs during the execution of the command.
     */
    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        String userSatisfied;

        Gift gift = gifts.getRandomGift(this.gender);
        System.out.println(gift);
        System.out.println("-> Satisfied with the gift suggestion? [Yes/No]");
        System.out.println("-> Changed you mind? type 'cancel' to exit this process!");
        System.out.println(HORIZONTAL);

        do {
            userSatisfied = ui.readCommand().toLowerCase();
            if (userSatisfied.equals("yes")) {
                System.out.println("This gift is about to make a love story even sweeter.");
                gift.markComplete();
                break;
            } else if (userSatisfied.equals("no")) {
                gift = gifts.getRandomGift(this.gender);
                if (gift == null) {
                    System.out.println("Wow! You've seen all our ideas! \n" +
                            "Sometimes, the best gifts are the ones you come up with yourself.\n" +
                            "We believe in you!");
                    System.out.println("");
                    System.out.println("Exiting gift generation process...");
                    System.out.println("Exit success!");
                    break;
                }
                System.out.println("Regenerating a new gift idea...");
                System.out.println(gift);
                System.out.println("-> Satisfied with the gift suggestion? [Yes/No]");
                System.out.println("-> Changed you mind? type 'cancel' to exit this process!");
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
