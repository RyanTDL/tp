package seedu.flirtfork;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import seedu.flirtfork.exceptions.FlirtForkException;

public class ActivityListTest {

    @Test
    void addActivity_validActivity_addedToActivityList() {
        Activity myActivity = new Activity("Skydiving", "C", "C", "U");
        ActivityList activities = new ActivityList();
        activities.add(myActivity);
        assertEquals(1, activities.size());
    }

    @Test
    void get_emptyList_throwsIndexOutOfBoundsException() {
        ActivityList activities = new ActivityList();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            activities.get(2);
        });
    }

    @Test
    void get_validList_correctActivityRetrieved() {
        String description = "Dancing";
        Activity myActivity = new Activity(description, "C", "C", "U");
        ActivityList activities = new ActivityList();
        activities.add(myActivity);
        assertEquals(description, activities.get(0).toString());
    }

    @Test
    void getFilteredActivity_noAvailableOptions_throwsFlirtForkException() {
        ActivityList activities = new ActivityList();
        Activity myActivity1 = new Activity("Dancing", "C", "C", "U");
        Activity myActivity2 = new Activity("Skydiving", "C", "C", "U");
        activities.add(myActivity1);
        activities.add(myActivity2);
        assertThrows(FlirtForkException.class, () -> {
            activities.getFilteredActivity("W", "C");
        });
    }
}
