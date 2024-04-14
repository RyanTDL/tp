package seedu.flirtfork;

/**
 * Represents a potential date idea to be adopted by the user.
 * Each date idea consist of 1 food option, and 1 activity option.
 */
public class Idea {
    private Food food;
    private Activity activity;

    /**
     * Constructs a date idea with a specific food option and activity option.
     *
     * @param food The selected food option retrieved.
     * @param activity The selected activity option retrieved.
     */
    public Idea(Food food, Activity activity) {
        this.food = food;
        this.activity = activity;
    }

    /**
     * Updates the date idea with a specific food option.
     * Overrides and replaces the existing food option.
     *
     * @param food The selected food option chosen.
     */    
    public void setFood(Food food) {
        this.food = food;
    }

    /**
     * Updates the date idea with a specific activity option.
     * Overrides and replaces the existing activity option.
     *
     * @param activity The selected activity option chosen.
     */    
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     * Returns the description of the date idea.
     * @return String description of the activity and food.
     */
    @Override
    public String toString() {
        return "You can do " + activity + " and have a nice meal at " + food;
    }
}
