package seedu.flirtfork.commands;

import seedu.flirtfork.Activity;
import seedu.flirtfork.ActivityList;
import seedu.flirtfork.Command;
import seedu.flirtfork.Favourites;
import seedu.flirtfork.FavouritesList;
import seedu.flirtfork.Food;
import seedu.flirtfork.FoodList;
import seedu.flirtfork.Gift;
import seedu.flirtfork.GiftList;
import seedu.flirtfork.Storage;
import seedu.flirtfork.Ui;
import seedu.flirtfork.UserDetails;
import seedu.flirtfork.exceptions.FlirtForkException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Command to find options based on user input.
 */
public class FindOptionsCommand extends Command {

    private static final String HORIZONTAL = "____________________________________________________________";
    private String optionType;

    public FindOptionsCommand() {
    }

    /**
     * Executes the command to find options based on user input.
     *
     * @param favourites The list of favourites.
     * @param foods      The list of food options.
     * @param activities The list of activity options.
     * @param ui         The user interface.
     * @param storage    The storage component.
     * @param userDetails The user details.
     * @param gifts      The list of gift options.
     * @throws FlirtForkException If an error occurs during execution.
     */
    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities,
                        Ui ui, Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {

        Scanner scanner = new Scanner(System.in);
        String optionType;
        Ui.findCommand();

        while (true) {
            optionType = scanner.nextLine().toLowerCase();

            switch (optionType) {
            case "food":
                System.out.println("Mmmm food yes. What restaurants would you like to search for?");
                String foodKeyword = scanner.nextLine().toLowerCase();
                ArrayList<Food> matchingFood = findFood(foodKeyword, foods);
                ui.showMatchingFoods(matchingFood);
                System.out.println(HORIZONTAL);
                System.out.println("To find exciting activities, type 'activities'");
                System.out.println("To hunt for gifts, type 'gifts'");
                System.out.println("To search for your treasures, type 'favourites'");
                System.out.println("To cancel this command, type 'cancel'");
                break;
            case "activities":
                System.out.println("Mmmm activities! What kind of activities would you like to search for?");
                String activityKeyword = scanner.nextLine().toLowerCase();
                ArrayList<Activity> matchingActivities = findActivities(activityKeyword, activities);
                ui.showMatchingActivities(matchingActivities);
                System.out.println(HORIZONTAL);
                System.out.println("To find delicious food, type 'food'");
                System.out.println("To hunt for gifts, type 'gifts'");
                System.out.println("To search for your treasures, type 'favourites'");
                System.out.println("To cancel this command, type 'cancel'");
                break;
            case "gifts":
                System.out.println("Mmmm gifts! What kind of gifts would you like to search for?");
                String giftKeyword = scanner.nextLine().toLowerCase();
                ArrayList<Gift> matchingGifts = findGifts(giftKeyword, gifts);
                ui.showMatchingGifts(matchingGifts);
                System.out.println(HORIZONTAL);
                System.out.println("To find delicious food, type 'food'");
                System.out.println("To find exciting activities, type 'activities'");
                System.out.println("To search for your treasures, type 'favourites'");
                System.out.println("To cancel this command, type 'cancel'");
                break;
            case "favourites":
                System.out.println("Mmmm finding your own treasures i see. What would you like to search for?");
                String favouritesKeyword = scanner.nextLine().toLowerCase();
                ArrayList<Favourites> matchingFavourites = findFavourites(favouritesKeyword, favourites);
                ui.showMatchingFavourites(matchingFavourites);
                System.out.println(HORIZONTAL);
                System.out.println("To find delicious food, type 'food'");
                System.out.println("To find exciting activities, type 'activities'");
                System.out.println("To hunt for gifts, type 'gifts'");
                System.out.println("To cancel this command, type 'cancel'");
                break;
            case "cancel":
                System.out.println("Cancelling findings...\n" +
                        "Cancel success!");
                return;
            default:
                System.out.println("Invalid option! "
                        + "Please choose 'food', 'activities', 'gifts', 'favourites' or 'cancel'.");
                System.out.println(HORIZONTAL);
            }
        }
    }

    private ArrayList<Food> findFood(String keyword, FoodList foods) {
        ArrayList<Food> matchingSaves = new ArrayList<>();

        for(int i = 0; i < foods.size(); i++) {
            Food food = foods.get(i);
            String description = food.getDescription().toLowerCase();
            if (description.contains(keyword.toLowerCase())) {
                matchingSaves.add(food);
            }
        }
        return matchingSaves;
    }

    private ArrayList<Activity> findActivities(String keyword, ActivityList activities) {
        ArrayList<Activity> matchingSaves = new ArrayList<>();

        for(int i = 0; i < activities.size(); i++) {
            Activity activity = activities.get(i);
            String description = activity.getDescription().toLowerCase();
            if (description.contains(keyword.toLowerCase())) {
                matchingSaves.add(activity);
            }
        }
        return matchingSaves;
    }

    private ArrayList<Gift> findGifts(String keyword, GiftList gifts) {
        ArrayList<Gift> matchingSaves = new ArrayList<>();

        for(int i = 0; i < gifts.size(); i++) {
            Gift gift = gifts.get(i);
            String description = gift.getDescription().toLowerCase();
            int categoryIndex = description.indexOf("]") + 1;
            if (description.substring(categoryIndex).contains(keyword.toLowerCase())) {
                matchingSaves.add(gift);
            }
        }
        return matchingSaves;
    }

    private ArrayList<Favourites> findFavourites(String keyword, FavouritesList favourites) {
        ArrayList<Favourites> matchingSaves = new ArrayList<>();

        for(Favourites favourite: favourites.getFavourites()) {
            String description = favourite.getDescription().toLowerCase();
            if (description.contains(keyword.toLowerCase())) {
                matchingSaves.add(favourite);
            }
        }
        return matchingSaves;
    }
}
