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

public class FindOptionsCommand extends Command {

    private static final String HORIZONTAL = "____________________________________________________________";
    private String optionType;

    public FindOptionsCommand() {
    }

    /*
    public FindOptionsCommand(String optionType) {
        while (!optionType.equals("food") && !optionType.equals("activities")
                && !optionType.equals("gifts") && !optionType.equals("favourites") && !optionType.equals("cancel")) {
            System.out.println("Invalid option! Please choose 'food', 'activities', 'gifts', 'favourites' or 'cancel'.");;
            Scanner scanner = new Scanner(System.in);
            optionType = scanner.nextLine().toLowerCase();
        }
        this.optionType = optionType;
    }

     */

    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities,
                        Ui ui, Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {

        Scanner scanner = new Scanner(System.in);
        String optionType;
        Ui.listCommand();

        while (true) {
            optionType = scanner.nextLine().toLowerCase();

            switch (optionType) {
            case "food":
                System.out.println("Mmmm food yes. What restaurants would you like to search for?");
                Scanner foodScanner = new Scanner(System.in);
                String foodKeyword = foodScanner.nextLine().toLowerCase();
                ArrayList<Food> matchingFood = findFood(foodKeyword, foods);
                ui.showMatchingFoods(matchingFood);
                break;
            case "activities":
                System.out.println("Mmmm activities! What kind of activities would you like to search for?");
                Scanner activityScanner = new Scanner(System.in);
                String activityKeyword = activityScanner.nextLine().toLowerCase();
                ArrayList<Activity> matchingActivities = findActivities(activityKeyword, activities);
                ui.showMatchingActivities(matchingActivities);
                break;
            case "gifts":
                System.out.println("Mmmm gifts! What kind of gifts would you like to search for?");
                Scanner giftScanner = new Scanner(System.in);
                String giftKeyword = giftScanner.nextLine().toLowerCase();
                ArrayList<Gift> matchingGifts = findGifts(giftKeyword, gifts);
                ui.showMatchingGifts(matchingGifts);
                break;
            case "favourites":
                System.out.println("Mmmm finding your own treasures i see. What would you like to search for?");
                Scanner favouritesScanner = new Scanner(System.in);
                String favouritesKeyword = favouritesScanner.nextLine().toLowerCase();
                ArrayList<Favourites> matchingFavourites = findFavourites(favouritesKeyword, favourites);
                ui.showMatchingFavourites(matchingFavourites);
                break;
            case "cancel":
                System.out.println("Cancelling findings...\n" +
                        "Cancel success!");
                break;
            default:
                throw new FlirtForkException("Invalid option!"
                        + "Please choose 'food', 'activities', 'gifts', 'favourites' or 'cancel'.");
            }
        }
        /*try {
            assert (optionType.equals("food")
                    || optionType.equals("activities")
                    || optionType.equals("gifts")
                    || optionType.equals("favourites")
                    || optionType.equals("cancel"))
                    : "optionType should be food, activities, gifts, favourites or cancel";

            switch (optionType) {
            case "food":
                System.out.println("Mmmm food yes. What restaurants would you like to search for?");
                Scanner foodScanner = new Scanner(System.in);
                String foodKeyword = foodScanner.nextLine().toLowerCase();
                ArrayList<Food> matchingFood = findFood(foodKeyword, foods);
                ui.showMatchingFoods(matchingFood);
                break;
            case "activities":
                System.out.println("Mmmm activities! What kind of activities would you like to search for?");
                Scanner activityScanner = new Scanner(System.in);
                String activityKeyword = activityScanner.nextLine().toLowerCase();
                ArrayList<Activity> matchingActivities = findActivities(activityKeyword, activities);
                ui.showMatchingActivities(matchingActivities);
                break;
            case "gifts":
                System.out.println("Mmmm gifts! What kind of gifts would you like to search for?");
                Scanner giftScanner = new Scanner(System.in);
                String giftKeyword = giftScanner.nextLine().toLowerCase();
                ArrayList<Gift> matchingGifts = findGifts(giftKeyword, gifts);
                ui.showMatchingGifts(matchingGifts);
                break;
            case "favourites":
                System.out.println("Mmmm finding your own treasures i see. What would you like to search for?");
                Scanner favouritesScanner = new Scanner(System.in);
                String favouritesKeyword = favouritesScanner.nextLine().toLowerCase();
                ArrayList<Favourites> matchingFavourites = findFavourites(favouritesKeyword, favourites);
                ui.showMatchingFavourites(matchingFavourites);
                break;
            case "cancel":
                System.out.println("Cancelling findings...\n" +
                        "Cancel success!");
                break;
            default:
                throw new FlirtForkException("Invalid option!"
                        + "Please choose 'food', 'activities', 'gifts', 'favourites' or 'cancel'.");
            }
        } catch (FlirtForkException e) {
            ui.errorMessage(e.getMessage());
        }

         */
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
