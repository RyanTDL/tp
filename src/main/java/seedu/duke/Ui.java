package seedu.duke;

import seedu.duke.exceptions.FlirtForkException;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private static final String BOT_NAME = "Flirt and Fork";
    private static final String HORIZONTAL = "____________________________________________________________";
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void greetingMessage(String anniversary) {
        System.out.println(HORIZONTAL);
        System.out.println("Hungry for love? You've come to the right place.\n" +
                "Welcome to " + BOT_NAME + " - where Cupid meets the chef!\n\n" +
                "Send me 'help' if you're new!");
        if (!anniversary.equals("N.A")) {
            System.out.println("\nRemember, your anniversary is on " + anniversary + " :)");
        }
        System.out.println(HORIZONTAL);
    }

    public void firstSetUpMessage() {
        System.out.println(HORIZONTAL);
        System.out.println("Hungry for love? You've come to the right place.\n" +
                "Welcome to " + BOT_NAME + " - where Cupid meets the chef!");
        System.out.println("Before we start, I would like to know you better!");
        System.out.println(HORIZONTAL);
    }

    public void exitMessage() {
        System.out.println("Love, like a good meal, is all about timing.\n" +
                "Keep your love simmering and your fork ready, " +
                "see you at the next course!");
    }

    public void helpMessage() {
        System.out.println(
            "----------------------------------------- \n" +
            "| Command to type | Function of feature | \n" +
            "----------------------------------------- \n" +
            "1. list: Take a look at potential restaurants, activities, or gifts \n\n" +
            "2. me: Let me know more about yourself \n\n" +
            "3. idea: Generate a randomised date idea \n\n" +
            "4. itinerary LOCATION PRICE: Generate a suitable date itinerary based on your preferences \n\n" +
            "5. smart: Generate a smart itinerary, based on your user profile \n\n" +
            "6. gift: Generate a randomised gift idea \n\n" +
            "7. food NAME_OF_EATERY LOCATION PRICE CUISINE: Add a restaurant to your favourites \n\n" +
            "8. activity NAME_OF_ACTIVITY LOCATION PRICE: Add an activity to your favourites \n\n" +
            "9. favourites: List out all your favourites \n\n" +
            "10. delete INDEX_OF_ENTRY: Delete an entry from your favourites \n\n" +
            "11. find KEYWORD: Find an entry from your favourites, based off keyword \n\n" +
            "12. history: List out all your past date locations and restaurants \n\n" +
            "13. exit: Exit the program \n\n" +

            "LEGEND (prices):\n" +
            "C: Cheap\n" +
            "B: Budget\n" +
            "A: Affordable\n" +
            "P: Pricey\n" +
            "S: Special Ocassions Only\n\n" +

            "LEGEND (locations):\n" +
            "E: East\n" +
            "W: West\n" +
            "C: Central\n" +
            "S: South\n" +
            "NE: NorthEast\n" +
            "ACC: Accessible (found in multiple places around SG)"
        );
    }

    public void errorMessage(String message) {
        System.out.println(message);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showFavourite(String favourite) {
        System.out.println(favourite);
    }

    public void listFavourites(FavouritesList favouritesList) {
        System.out.println("Drumroll, please! Presenting the stars of your romantic sky: ");
        System.out.println(favouritesList.getFormattedFavourites());
    }

    public void showMatchingFavourites(ArrayList<Favourites> matchingFavourites) {
        if (matchingFavourites.isEmpty()) {
            System.out.println("No treasures found this time. Let's try another clue?");
        } else {
            System.out.println("Eureka! Your cupid's arrow hit the target! We found these matches for you:");
            for (int i = 0; i < matchingFavourites.size(); i++) {
                System.out.println((i + 1) + ". " + matchingFavourites.get(i));
            }
        }
    }

    public static void listFood() {
        System.out.println("HMMMM Let's see what food is theree: ");
    }

    public static void listActivities() {
        System.out.println("What are some activities you can do as a couple? Let's see.." );
    }

    public static void listGifts() {
        System.out.println("Peek into Cupid's own gift collection!" );
    }

    public static void listCommand() {
        System.out.println("Looking for ideas to spice up your date night?");
        System.out.println("Choose from the following options:");
        System.out.println("1. List out delicious dining options (type 'food')");
        System.out.println("2. Discover exciting activities to do together (type 'activities')");
        System.out.println("3. Unwrap joy with our curated list of gifts that'll make hearts flutter! (type 'gifts')");
        System.out.println("What's your pleasure?");
    }

    public void ideaSatisfiedErrorMessage() {
        System.out.println("Sorry, I didn't quite understand that :(");
        System.out.println("Please enter either yes or no");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readUserLocation() {
        String input = readCommand();
        boolean isValid;

        isValid = input.equals("E") || input.equals("W") || input.equals("C")
                || input.equals("S") || input.equals("NE");

        while (!isValid) {
            System.out.println("Invalid location, please enter E, W, C, S or NE");
            input = readCommand();
            isValid = input.equals("E") || input.equals("W") || input.equals("C")
                    || input.equals("S") || input.equals("NE");
        }
        return input;
    }

    public String readAge() {
        int age;
        while (true) {
            try {
                String input = readCommand();
                age = Integer.parseInt(input);
                return input;
            } catch (NumberFormatException e) {
                showMessage("Invalid input. Please enter a valid integer age.");
            }
        }
    }
}
