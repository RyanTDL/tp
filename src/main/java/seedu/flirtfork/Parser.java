package seedu.flirtfork;


import seedu.flirtfork.commands.AddActivityCommand;
import seedu.flirtfork.commands.AddFoodCommand;
import seedu.flirtfork.commands.DeleteFavouritesCommand;
import seedu.flirtfork.commands.ListFavouritesCommand;
import seedu.flirtfork.commands.ExitCommand;
import seedu.flirtfork.commands.FindOptionsCommand;
import seedu.flirtfork.commands.GenerateGiftCommand;
import seedu.flirtfork.commands.GenerateIdeaCommand;
import seedu.flirtfork.commands.GenerateItineraryCommand;
import seedu.flirtfork.commands.GenerateSmartItineraryCommand;
import seedu.flirtfork.commands.HelpCommand;
import seedu.flirtfork.commands.ListOptionsCommand;
import seedu.flirtfork.commands.UserDetailsCommand;
import seedu.flirtfork.commands.ViewHistoryCommand;

import seedu.flirtfork.exceptions.FlirtForkEmptyException;
import seedu.flirtfork.exceptions.FlirtForkException;

import java.util.Scanner;

/**
 * The Parser class is responsible for interpreting user input and converting it into a Command
 * that the application can execute.
 * It checks the command type, validates and processes any arguments,
 * and returns the appropriate Command object to perform the requested action.
 */
public class Parser {
    private static final String HORIZONTAL = "____________________________________________________________";

    /**
     * Parses the user input into a command based on the first word of the input and any subsequent arguments.
     *
     * @param userInput The raw input string from the user.
     * @param userDetails The UserDetails object containing specific data about the user.
     * @return Command The command to be executed.
     * @throws FlirtForkException if there is an error parsing the input or if the input is invalid.
     */
    public static Command parseCommand(String userInput, UserDetails userDetails) throws FlirtForkException {
        if (userInput.trim().isEmpty()) {
            throw new FlirtForkException("OOPS! Input cannot be empty! \n" + HORIZONTAL);
        }

        assert userDetails != null : "Input should not be empty";

        String commandType = userInput.split(" ")[0];
        String arguments = userInput.contains(" ") ? userInput.substring(userInput.indexOf(" ") + 1) : "";

        switch (commandType) {
        case "food":
            if (arguments.trim().isEmpty()) {
                throw new FlirtForkException("OOPS! Food description cannot be empty! \n" + HORIZONTAL);
            }
            return new AddFoodCommand(arguments);
        case "activity":
            if (arguments.trim().isEmpty()) {
                throw new FlirtForkEmptyException();
            }
            return new AddActivityCommand(arguments);
        case "favourites":
            if (!arguments.trim().isEmpty()) {
                throw new FlirtForkException("OOPS! The 'favourites' command does not require " +
                        "any additional arguments. \n" + HORIZONTAL);
            }
            return new ListFavouritesCommand();
        case "delete":
            try {
                int index = Integer.parseInt(arguments) - 1;
                if (index < 0) {
                    throw new FlirtForkException("OOPS! Index must be greater than 0! \n" +
                            HORIZONTAL);
                }
                return new DeleteFavouritesCommand(index);
            } catch (NumberFormatException e) {
                throw new FlirtForkException("OOPS! Invalid format, " +
                        "please specify task index correctly! \n" + HORIZONTAL);
            }
        case "find":
            if (!arguments.trim().isEmpty()) {
                throw new FlirtForkException("OOPS! Don't need kanchiong! Just type 'find' first! \n" + HORIZONTAL);
            }
            Ui.findCommand();
            Scanner findScanner = new Scanner(System.in);
            String findOptionType = findScanner.nextLine().toLowerCase();
            return new FindOptionsCommand(findOptionType);
        case "itinerary":
            if (arguments.trim().isEmpty()) {
                throw new FlirtForkEmptyException();
            } else if (arguments.split(" ").length!=2) {
                throw new FlirtForkException("Please follow the format: 'itinerary LOCATION, PRICE'");
            } else {
                return new GenerateItineraryCommand(arguments);
            }
        case "smart":
            if (!arguments.trim().isEmpty()) {
                throw new FlirtForkException("To generate smart itinerary, please only send 'smart'.");
            }
            return new GenerateSmartItineraryCommand(userDetails);
        case "idea":
            if (!arguments.trim().isEmpty()) {
                throw new FlirtForkException("To generate date ideas, please only send 'idea'.");
            }
            return new GenerateIdeaCommand();
        case "gift":
            return parseGiftCommand(arguments);
        case "exit":
            if (!arguments.trim().isEmpty()) {
                throw new FlirtForkException("If you wish to exit, please only send 'exit'. \n" + HORIZONTAL);
            }
            return new ExitCommand();
        case "help":
            if (!arguments.trim().isEmpty()) {
                throw new FlirtForkException("Just 'help' is enough :) \n" + HORIZONTAL);
            }
            return new HelpCommand();
        case "me":
            if (!arguments.trim().isEmpty()) {
                throw new FlirtForkException("Don't be ambitious! Just 'me' is enough! \n" + HORIZONTAL);
            }
            return new UserDetailsCommand();
        case "history":
            if (!arguments.trim().isEmpty()) {
                throw new FlirtForkException("Okay, just type 'history' as it is to view your past. \n" + HORIZONTAL);
            }
            return new ViewHistoryCommand();
        case "list":
            if (!arguments.trim().isEmpty()) {
                throw new FlirtForkException("Only 'list' is required to view the list! \n" + HORIZONTAL);
            }
            return new ListOptionsCommand();
        default:
            throw new FlirtForkException("Love is a language we all speak, but we didn't quite catch that. \n" +
                    "Try again? \n" + HORIZONTAL);
        }
    }

    /**
     * Parses the command arguments to determine the gender-specific gift command to be generated.
     *
     * @param arguments The arguments part of the user input for gift-related commands.
     * @return Command A new GenerateGiftCommand with the specified gender criteria.
     * @throws FlirtForkException if the arguments are invalid or improperly formatted.
     */
    private static Command parseGiftCommand(String arguments) throws FlirtForkException {
        String giftGender = "any"; // Default to any gender

        if (!arguments.trim().isEmpty()) {
            String[] argsSplit = arguments.trim().split("\\s+");

            if (argsSplit.length == 1) {
                String genderArg = argsSplit[0].toLowerCase();
                switch (genderArg) {
                case "male":
                    giftGender = "M";
                    break;
                case "female":
                    giftGender = "F";
                    break;
                case "unisex":
                    giftGender = "U";
                    break;
                default:
                    throw new FlirtForkException("Invalid argument for gift command! \n" +
                            "For a random gift, type 'gift'. \n" +
                            "For a more gender-specific randomisation, type only one of 'gift male', " +
                            "'gift female', or 'gift unisex'.");
                }
            } else {
                throw new FlirtForkException("Too many arguments for gift command! \n" +
                        "For a random gift, type 'gift'. \n" +
                        "For a more gender-specific randomisation, type only one of 'gift male', " +
                        "'gift female', or 'gift unisex'.");
            }
        }

        // giftGender remains "any"
        return new GenerateGiftCommand(giftGender);
    }

    public static Favourites parseFavourites(String line) {
        String[] parts = line.split(" \\| ");
        Favourites favourite = null;

        if ("F".equals(parts[0]) && parts.length >= 2) {
            favourite = new Food(parts[0], parts[1], parts[2], parts[3], parts[4]);
        } else if ("A".equals(parts[0]) && parts.length >= 2) {
            favourite = new Activity(parts[0], parts[1], parts[2], parts[3]);
        } else {
            assert false; // Throws AssertionError if favourite not created yet
        }

        return favourite;
    }

    /**
     * Parses a line from the FoodList.txt file and constructs a Food object from it.
     *
     * @param line The line from the food file.
     * @return Food A new Food object based on the parsed line.
     */
    public static Food parseFood(String line) {
        String[] parts = line.split(" \\| ");
        Food food;
        food = new Food(parts[0], parts[1], parts[2], parts[3], parts[4]);
        return food;
    }

    /**
     * Parses a line from the ActivityList.txt file and constructs an Activity object from it.
     *
     * @param line The line from the activities file.
     * @return Activity A new Activity object based on the parsed line.
     */
    public static Activity parseActivity(String line) {
        String[] parts = line.split(" \\| ");
        Activity activity;
        activity = new Activity(parts[0], parts[1], parts[2], parts[3]);
        return activity;
    }

    /**
     * Parses a line from the GiftList.txt file and constructs a Gift object from it.
     * Ensures that each line includes a description, completion status, and gender marker.
     *
     * @param line The line from the gifts file.
     * @return Gift A new Gift object based on the parsed line.
     * @throws FlirtForkException if the gift data is incomplete or improperly formatted.
     */
    public static Gift parseGift(String line) throws FlirtForkException {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) {
            throw new FlirtForkException("Gift data is incomplete. " +
                    "Each line must include a description, completion status, and gender marker.");
        }
        Gift gift = new Gift(parts[0], parts[1], parts[2]);
        return gift;
    }

}


