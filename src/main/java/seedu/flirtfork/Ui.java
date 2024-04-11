package seedu.flirtfork;

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
                "If you ever feel lost, just type 'help' for a guiding star!");
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
            "4. itinerary LOCATION, PRICE: Generate a suitable date itinerary based on your preferences \n\n" +
            "5. smart: Generate a smart itinerary, based on your user profile \n\n" +
            "6. gift: Generate a randomised gift idea \n\n" +
            "7. food NAME_OF_EATERY, LOCATION, PRICE, CUISINE: Add a restaurant to your favourites \n\n" +
            "8. activity NAME_OF_ACTIVITY, LOCATION, PRICE: Add an activity to your favourites \n\n" +
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

            "LEGEND (cuisines):\n" +
            "W: Western\n" +
            "F: Fusion\n" +
            "J: Japanese\n" +
            "C: Chinese\n" +
            "T: Thai\n" +
            "K: Korean\n" +
            "I: Italian\n" +
            "S: Spanish\n\n" +

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

    public void showMatchingFoods(ArrayList<Food> matchingFoods) {
        if (matchingFoods.isEmpty()) {
            System.out.println("No food found this time:( Let's try another clue?");
        } else {
            System.out.println("Eureka! Your cupid's arrow hit the target! We found these matches for you:");
            for (int i = 0; i < matchingFoods.size(); i++) {
                System.out.println((i + 1) + ". " + matchingFoods.get(i));
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
        System.out.println("4. Changed you mind? Feel free to cancel this command! (type 'cancel')");
        System.out.println("What's your pleasure?");
    }

    public void ideaSatisfiedErrorMessage() {
        System.out.println("Sorry, I didn't quite understand that :(");
        System.out.println("Please enter either yes or no or cancel the generation process");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Reads and validates the user's location input.
     *
     * @return The user's validated location input (E, W, C, S, or NE).
     */
    public String readUserLocation() {
        String input = readCommand();
        boolean isValid;

        isValid = input.equals("E") || input.equals("W") || input.equals("C")
                || input.equals("S") || input.equals("NE");

        while (!isValid) {
            showMessage("Invalid location, please enter E, W, C, S or NE.");
            input = readCommand();
            isValid = input.equals("E") || input.equals("W") || input.equals("C")
                    || input.equals("S") || input.equals("NE");
        }
        return input;
    }

    /**
     * Reads and validates the user's age input.
     *
     * @return The user's validated age input as a String.
     */
    public String readAge() {
        int age;
        while (true) {
            try {
                String input = readCommand();
                age = Integer.parseInt(input);
                if (age <= 0) {
                    showMessage("Age cannot be negative or zero. Please enter a valid age.");
                } else if (age >= 120) {
                    showMessage("I don't think you're older than the oldest person alive...re-enter your age!");
                } else {
                    return input; // Valid age
                }
            } catch (NumberFormatException e) {
                showMessage("Invalid input. Please enter a valid integer age.");
            }
        }
    }

    /**
     * Reads and validates the user's name input, ensuring it's not empty and doesn't contain numbers.
     *
     * @return The user's validated name input as a String.
     */
    public String readName() {
        while (true) {
            String name = readCommand();
            if (name.trim().isEmpty()) {
                showMessage("Name cannot be empty. Please enter a valid name.");
            } else if (name.matches(".*\\d+.*")) {
                showMessage("Name cannot contain numbers. Please re-enter without numbers.");
            } else {
                return name;
            }
        }
    }

    /**
     * Reads and validates the user's cuisine preference input.
     *
     * @return The user's validated cuisine preference input (W, F, J, C, T, K, I, or S).
     */
    public String readUserCuisine() {
        String input = readCommand();
        boolean isValid;

        isValid = input.equals("W") || input.equals("F") || input.equals("J") || input.equals("C")
                || input.equals("T") ||input.equals("K") || input.equals("I") || input.equals("S");

        while (!isValid) {
            showMessage("Please enter your preferences in this format.\n");
            showMessage("W: Western");
            showMessage("F: Fusion");
            showMessage("J: Japanese");
            showMessage("C: Chinese");
            showMessage("T: Thai");
            showMessage("K: Korean");
            showMessage("I: Italian");
            showMessage("S: Spanish");
            input = readCommand();
            isValid = input.equals("W") || input.equals("F") || input.equals("J") || input.equals("C")
                    || input.equals("T") ||input.equals("K") || input.equals("I") || input.equals("S");
        }
        return input;
    }

    /**
     * Reads and validates the user's relationship status input.
     *
     * @return The user's validated relationship status input (M, R, F, D, S, or X).
     */
    public String readUserStatus() {
        String input = readCommand();
        boolean isValid;

        isValid = input.equals("M") || input.equals("R") || input.equals("F")
                || input.equals("D") || input.equals("S") ||input.equals("X");

        while(!isValid) {
            showMessage("Please enter your status in this format.\n");
            showMessage("Enter 'M' if you are Married");
            showMessage("Enter 'R' if you are in a serious relationship");
            showMessage("Enter 'F' if you are having a fling");
            showMessage("Enter 'D' if you are dating/testing the waters");
            showMessage("Enter 'S' if you are single and ready to mingle");
            showMessage("Enter 'X' if you are single and only looking to hangout with friends");
            input = readCommand();
            isValid = input.equals("M") || input.equals("R") || input.equals("F")
                    || input.equals("D") || input.equals("S") ||input.equals("X");
        }
        return input;
    }

    /**
     * Reads and validates the user's gender input.
     *
     * @return The user's validated gender input (Male, Female, or Other).
     */
    public String readUserGender() {
        String input = readCommand();
        boolean isValid;

        isValid = input.equals("Male") || input.equals("Female") || input.equals("Other");

        while(!isValid) {
            showMessage("Please enter your gender in this format strictly. Please adhere to the capitalisation\n");
            showMessage("'Male' if you are a male");
            showMessage("'Female' if you are a female");
            showMessage("'Other' if its none of the above");

            input = readCommand();
            isValid = input.equals("Male") || input.equals("Female") || input.equals("Other");
        }
        return input;
    }

    /**
     * Reads and validates the user's anniversary date input.
     * The date must be in this format: dd/mm/yyyy
     *
     * @return The user's validated anniversary date input (String).
     */
    public String readAnniversaryDate() {
        String input = readCommand();

        while (!isValidDateFormat(input)) {
            showMessage("Invalid date format. Please enter the date in 'dd/mm/yyyy' format.");
            input = readCommand();
        }
        return input;
    }

    /**
     * Checks if the given input string represents a valid date in the format 'dd/mm/yyyy'.
     *
     * @param input The input string to be validated as a date.
     * @return true if the input string represents a valid date, false otherwise.
     */
    private boolean isValidDateFormat(String input) {
        if (input.matches("\\d{2}/\\d{2}/\\d{4}")) {
            String[] parts = input.split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            if (month >= 1 && month <= 12 && day >= 1 && day <= 31 && year >= 1000 && year <= 9999) {
                return true;
            }
        }
        return false;
    }
}
