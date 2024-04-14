package seedu.flirtfork;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import seedu.flirtfork.exceptions.FlirtForkException;

public class FoodListTest {

    @Test
    void addFood_validFood_addedToFoodList() {
        Food myFood = new Food("Bistro Bar", "C", "C", "C", "U");
        FoodList foods = new FoodList();
        foods.add(myFood);
        assertEquals(1, foods.size());
    }

    @Test
    void get_emptyList_throwsIndexOutOfBoundsException() {
        FoodList foods = new FoodList();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            foods.get(2);
        });
    }

    @Test
    void get_validList_correctFoodRetrieved() {
        String description = "Bistro Bar";
        Food myFood = new Food("Bistro Bar", "C", "C", "C", "U");
        FoodList foods = new FoodList();
        foods.add(myFood);
        assertEquals(description, foods.get(0).toString());
    }

    @Test
    void getFilteredFood_noAvailableOptions_throwsFlirtForkException() {
        FoodList foods = new FoodList();
        Food myFood1 = new Food("Hwangs", "C", "C", "C", "U");
        Food myFood2 = new Food("Udon Bar", "C", "C", "C", "U");
        foods.add(myFood1);
        foods.add(myFood2);
        assertThrows(FlirtForkException.class, () -> {
            foods.getFilteredFood("W", "C");
        });
    }
}
