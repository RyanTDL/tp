package seedu.flirtfork;

/**
 * Represents a potential date itinerary to be adopted by the user.
 * Each date idea consist of 2 food options, and 2 activity options.
 * The food and activity categories will be based on user 'price' and 'location' inputs.
 */
public class Itinerary {
    private Food food1;
    private Food food2;
    private Activity activity1;
    private Activity activity2;

    /**
     * Constructs a date itinerary with 2 specific food options and 2 activity options.
     *
     * @param food1 The first selected food option retrieved.
     * @param food2 The second selected food option retrieved.
     * @param activity1 The first selected activity option retrieved.
     * @param activity2 The second selected activity option retrieved.
     */
    public Itinerary(Food food1, Food food2, Activity activity1, Activity activity2) {
        this.food1 = food1;
        this.food2 = food2;
        this.activity1 = activity1;
        this.activity2 = activity2;
    }

    /**
     * Returns the description of the date itinerary.
     * @return String description of the first activity and food, followed by the second activity and food.
     */
    @Override
    public String toString() {
        return "Here is a rough itinerary for your date: \n" + 
                "We begin with lunch at " + food1 + ", followed by some fun at " + activity1 + ".\n" +
                "We proceed to have dinner at " + food2 + ", and finish the night at " + activity2 + ".\n";
    }
}
