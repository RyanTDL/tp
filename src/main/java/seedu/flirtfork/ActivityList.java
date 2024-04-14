package seedu.flirtfork;

import java.util.ArrayList;
import java.util.Random;

import seedu.flirtfork.exceptions.FlirtForkException;

/**
 * Represents a list of activities.
 */
public class ActivityList {
    private ArrayList<Activity> activities;

    /**
     * Constructs an empty activity list.
     */
    public ActivityList() {
        this.activities = new ArrayList<>();
    }

    /**
     * Constructs an activity list with the specified activities.
     *
     * @param activities The list of activities.
     */
    public ActivityList(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    /**
     * Retrieves the activity at the specified index.
     *
     * @param i The index of the activity to retrieve.
     * @return The activity at the specified index.
     */
    public Activity get(int i) {
        return activities.get(i);
    }

    /**
     * Adds a new activity to the list.
     *
     * @param newActivity The activity to add.
     */
    public void add(Activity newActivity) {
        activities.add(newActivity);
    }

    /**
     * Retrieves the number of activities in the list.
     *
     * @return The number of activities.
     */
    public int size() {
        return activities.size();
    }

    /**
     * Retrieves a random activity from the list.
     *
     * @return A random activity.
     */
    public Activity getRandomActivity() {
        Activity randomActivity;
        do {
            Random random = new Random();
            int activityIndex = random.nextInt(activities.size());
            randomActivity = activities.get(activityIndex);
        } while (randomActivity.completionStatus.equals("C"));
        return randomActivity;
    }

    /**
     * Retrieves a filtered activity based on preferred location and price.
     *
     * @param preferredLocation The preferred location.
     * @param preferredPrice The preferred price.
     * @return A filtered activity.
     * @throws FlirtForkException If not enough activity options are available.
     */
    public Activity getFilteredActivity(String preferredLocation, String preferredPrice) throws FlirtForkException {
        ArrayList<Activity> filteredActivities = new ArrayList<>();
        for (Activity eachActivity : activities) {
            if (eachActivity.location.equals(preferredLocation) && 
                    eachActivity.price.equals(preferredPrice) && eachActivity.completionStatus.equals("U")) {
                filteredActivities.add(eachActivity);
            }
        }

        if (filteredActivities.size()<=1) {
            throw new FlirtForkException("Not enough activity options");
        } else {
            Random random = new Random();
            int filteredActivityIndex = random.nextInt(filteredActivities.size());
            return filteredActivities.get(filteredActivityIndex);
        }

    }

    /**
     * Retrieves a customised activity based on user location.
     *
     * @param userLocation The user's location.
     * @return A customised activity.
     * @throws FlirtForkException If not enough activity options are available.
     */
    public Activity getCustomisedActivity(String userLocation) throws FlirtForkException {
        ArrayList<Activity> filteredActivities = new ArrayList<>();
        for (Activity eachActivity : activities) {
            if (eachActivity.location.equals(userLocation) && 
                    eachActivity.completionStatus.equals("U")) {
                filteredActivities.add(eachActivity);
            }
        }

        if (filteredActivities.size()<=1) {
            throw new FlirtForkException("Not enough activity options");
        } else {
            Random random = new Random();
            int filteredActivityIndex = random.nextInt(filteredActivities.size());
            return filteredActivities.get(filteredActivityIndex);
        }

    }
}
