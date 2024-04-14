package seedu.flirtfork;

/**
 * Represents a date activity consisting of:
 * A description, location, price and completion status.
 * The completion status indicates whether an activity idea has been accepted and marked as complete.
 */
public class Activity extends Favourites {
    protected String location;
    protected String price;
    protected String completionStatus;

    /**
     * Constructs an activity based on inputs.
     *
     * @param description The name of the activity.
     * @param location The location of the activity.
     * @param price The price category of the activity.
     * @param completionStatus The status of whether the activity has been done prior.
     */
    public Activity(String description, String location, String price, String completionStatus) {
        super(description);
        this.location = location;
        this.price = price;
        this.completionStatus = completionStatus;
    }

    /**
     * Returns the description of the activity.
     * @return String description of the activity.
     */
    @Override
    public String toString() {
        return description;
    }

    /**
     * Updates the completion status of the activity, marking it as having been completed.
     */
    public void markComplete() {
        this.completionStatus = "C";
    }

    /**
     * Returns the completion status of the activity.
     * @return completionStatus Completion status of the activity.
     */
    public String getCompletionStatus() {
        return completionStatus;
    }
}
