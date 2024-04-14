package seedu.flirtfork;

import org.junit.jupiter.api.Test;
import seedu.flirtfork.commands.AddActivityCommand;
import seedu.flirtfork.commands.AddFoodCommand;
import seedu.flirtfork.commands.DeleteFavouritesCommand;
import seedu.flirtfork.commands.ExitCommand;
import seedu.flirtfork.commands.ListFavouritesCommand;
import seedu.flirtfork.commands.UserDetailsCommand;
import seedu.flirtfork.commands.HelpCommand;
import seedu.flirtfork.commands.GenerateGiftCommand;
import seedu.flirtfork.commands.ListOptionsCommand;
import seedu.flirtfork.exceptions.FlirtForkException;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ParserTest {

    private UserDetails userDetails;

    @BeforeEach
    void setUp() {
        // Create a dummy UserDetails object for testing
        userDetails = new UserDetails("John Doe", "25", "Male", "Single", "Central",
                "Italian", "14/2/2024");
    }

    // 3 part format
    //methodBeingTested_conditionToTest_ExpectedOutcome
    @Test
    void parseCommand_emptyInput_expectException() {
        // Test to ensure that exception is thrown for empty input
        assertThrows(FlirtForkException.class, () -> {
            Parser.parseCommand("", userDetails);
        }, "Empty input should throw FlirtForkException");
    }

    @Test
    void parseCommand_exitCommand_expectExitMessage() {
        try {
            Command result = Parser.parseCommand("exit", userDetails);
            assertTrue(result instanceof ExitCommand, "Result should be an instance of ExitCommand");
        } catch (FlirtForkException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void parseCommand_addFoodCommand_expectAddFoodCommand() {
        try {
            Command result = Parser.parseCommand("food sushi express", userDetails);
            assertTrue(result instanceof AddFoodCommand, "Expected AddFoodCommand for 'food' input.");
        } catch (Exception e) {
            fail("Exception should not be thrown for valid 'food' input.");
        }
    }

    @Test
    void parseCommand_foodCommandWithEmptyArguments_expectException() {
        // Test food command without arguments throws an exception
        assertThrows(FlirtForkException.class, () -> {
            Parser.parseCommand("food", userDetails);
        }, "Food command without description should throw FlirtForkException");
    }

    @Test
    void parseCommand_addActivityCommandInput_expectAddActivityCommand() {
        try {
            Command result = Parser.parseCommand("activity karaoke", userDetails);
            assertTrue(result instanceof AddActivityCommand, "Expected AddActivityCommand for 'activity' input.");
        } catch (Exception e) {
            fail("Exception should not be thrown for valid 'activity' input.");
        }
    }

    @Test
    void parseCommand_userDetailsCommandInput_expectUserDetailsCommand() {
        try {
            Command result = Parser.parseCommand("me", userDetails);
            assertTrue(result instanceof UserDetailsCommand, "Expected UserDetailsCommand for 'me' input.");
        } catch (Exception e) {
            fail("Exception should not be thrown for valid 'me' input.");
        }
    }

    @Test
    void parseCommand_invalidUserDetailsCommand_expectException() {
        // Test that an invalid command for user details throws FlirtForkException
        assertThrows(FlirtForkException.class, () -> {
            Parser.parseCommand("undefined 123", userDetails);
        }, "Undefined command should throw FlirtForkException");
    }

    @Test
    void parseCommand_listFavouritesCommandInput_expectListFavouritesCommand() {
        try {
            Command result = Parser.parseCommand("favourites", userDetails);
            assertTrue(result instanceof ListFavouritesCommand,
                    "Expected ListFavouritesCommand for 'favourites' input.");
        } catch (Exception e) {
            fail("Exception should not be thrown for valid 'favourites' input.");
        }
    }

    @Test
    void parseCommand_deleteFavouritesCommandInputWithValidIndex_expectDeleteFavouritesCommand() {
        try {
            Command result = Parser.parseCommand("delete 1", userDetails);
            assertTrue(result instanceof DeleteFavouritesCommand,
                    "Expected DeleteFavouritesCommand for 'delete' input with a valid index.");
        } catch (Exception e) {
            fail("Exception should not be thrown for valid 'delete' input with a valid index.");
        }
    }

    @Test
    void parseCommand_helpCommand_expectHelpCommand() {
        // Test for correct parsing of the help command
        assertDoesNotThrow(() -> {
            Command result = Parser.parseCommand("help", userDetails);
            assertTrue(result instanceof HelpCommand, "Expected HelpCommand for 'help'.");
        });
    }

    @Test
    void parseCommand_giftDefault_expectGenerateGiftCommandWithAny() {
        try {
            Command result = Parser.parseCommand("gift", userDetails);
            assertTrue(result instanceof GenerateGiftCommand);
        } catch (FlirtForkException e) {
            fail("Should not throw an exception for 'gift'");
        }
    }

    @Test
    void parseCommand_giftWithInvalidArgument_expectException() {
        // Test that an invalid gender argument for gift command throws FlirtForkException
        String invalidGender = "invalid_gender";
        String userInput = "gift " + invalidGender;
        assertThrows(FlirtForkException.class, () -> Parser.parseCommand(userInput, userDetails),
                "An invalid gender argument should throw a FlirtForkException.");
    }

    @Test
    void parseCommand_giftWithMultipleArguments_expectException() {
        // Test that multiple arguments for gift command throws FlirtForkException
        String userInput = "gift male female";
        assertThrows(FlirtForkException.class, () -> Parser.parseCommand(userInput, userDetails),
                "Multiple arguments should throw a FlirtForkException.");
    }

    @Test
    void parseCommand_listInput_expectListOptionsCommand() {
        String userInput = "list";
        try {
            Command result = Parser.parseCommand(userInput, userDetails);
            assertTrue(result instanceof ListOptionsCommand, "Expected ListOptionsCommand for 'list' input.");
        } catch (FlirtForkException e) {
            fail("No exception should be thrown for valid 'list' input.");
        }
    }

}
