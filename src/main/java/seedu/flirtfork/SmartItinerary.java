package seedu.flirtfork;

public class SmartItinerary {
    private Food food1;
    private Food food2;
    private Activity activity1;
    private Activity activity2;

    public SmartItinerary(Food food1, Food food2, Activity activity1, Activity activity2) {
        this.food1 = food1;
        this.food2 = food2;
        this.activity1 = activity1;
        this.activity2 = activity2;
    }

    @Override
    public String toString() {
        return "Here is a smart itinerary for your date (the afternoon is planned around your base preferences!): \n" + 
                "We begin with lunch at " + food1 + ", followed by some fun at " + activity1 + ".\n" +
                "We proceed to have dinner at " + food2 + ", and finish the night at " + activity2 + ".\n";
    }
}
