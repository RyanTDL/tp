package seedu.flirtfork;

/**
 * A gift item with a description, gender classification, and completion status.
 * The completion status indicates whether a gift has been accepted and marked as complete.
 */
public class Gift extends Favourites {

    protected String completionStatus;
    protected String gender; // M, F, U, any

    /**
     * Constructs a Gift with a name, gender, and completion status.
     *
     * @param name Name or description of the gift.
     * @param gender Gender classification of the gift (M, F, U, or any).
     * @param completionStatus Completion status of the gift.
     */
    public Gift(String name, String gender, String completionStatus) {
        super(name);
        this.gender = gender;
        this.completionStatus = completionStatus;
    }

    /**
     * Returns the description of the gift.
     * @return String description of the gift.
     */
    @Override
    public String toString() {
        return (description);
    }

    /**
     * Updates the completion status of the gift, marking it as having been completed.
     */
    public void markComplete() {
        this.completionStatus = "C";
    }

    /**
     * Returns the completion status of the gift.
     * @return completionStatus Completion status of the gift.
     */
    public String getCompletionStatus() {
        return completionStatus;
    }

    /**
     * Returns the gender classification of the gift.
     * @return gender gender classification of the gift.
     */
    public String getGender() {
        return gender;
    }
}
