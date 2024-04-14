package seedu.flirtfork;

/**
 * Represents a restaurant location consisting of:
 * A description, location, price, cuisine and completion status.
 * The completion status indicates whether a restaurant has been accepted and marked as complete.
 */
public class Food extends Favourites {
    protected String location;
    protected String price;
    protected String cuisine;
    protected String completionStatus;

    /**
     * Constructs a restaurant location based on inputs.
     *
     * @param description The name of the restaurant.
     * @param location The location of the restaurant.
     * @param price The price category of the restaurant.
     * @param cuisine The cuisine category of the restaurant.
     * @param completionStatus The status of whether the restaurant has been visited prior.
     */
    public Food(String description, String location, String price, String cuisine, String completionStatus) {
        super(description);
        this.location = location;
        this.price = price;
        this.cuisine = cuisine;
        this.completionStatus = completionStatus;
    }

    /**
     * Returns the Name of the restaurant.
     * @return description Name of the restaurant.
     */
    @Override
    public String toString() {
        return (description);
    }

    /**
     * Updates the completion status of the restaurant, marking it as having been visited.
     */
    public void markComplete() {
        this.completionStatus = "C";
    }

    /**
     * Returns the completion status of the restaurant.
     * @return completionStatus Completion status of the restaurant.
     */
    public String getCompletionStatus() {
        return completionStatus;
    }
}
