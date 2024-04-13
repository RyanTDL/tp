package seedu.flirtfork;

import java.util.ArrayList;
import java.util.Random;

import seedu.flirtfork.exceptions.FlirtForkException;

/**
 * Represents a list of food options.
 */
public class FoodList {
    private ArrayList<Food> foods;

    /**
     * Constructs an empty food list.
     */
    public FoodList() {
        this.foods = new ArrayList<>();
    }

    /**
     * Constructs a food list with the specified food options.
     *
     * @param foods The list of food options.
     */
    public FoodList(ArrayList<Food> foods) {
        this.foods = foods;
    }

    /**
     * Retrieves the number of food options in the list.
     *
     * @return The number of food options.
     */
    public int size() {
        return foods.size();
    }

    /**
     * Retrieves the food option at the specified index.
     *
     * @param i The index of the food option to retrieve.
     * @return The food option at the specified index.
     */
    public Food get(int i) {
        return foods.get(i);
    }

    /**
     * Adds a new food option to the list.
     *
     * @param newFood The food option to add.
     */
    public void add(Food newFood) {
        foods.add(newFood);
    }

    /**
     * Retrieves a random food option from the list.
     *
     * @return A random food option.
     */
    public Food getRandomFood() {
        Food randomFood;
        do {
            Random random = new Random();
            int foodIndex = random.nextInt(foods.size());
            randomFood = foods.get(foodIndex);
        } while (randomFood.completionStatus.equals("C"));
        return randomFood;
    }

    /**
     * Retrieves a filtered food option based on preferred location and price.
     *
     * @param preferredLocation The preferred location.
     * @param preferredPrice The preferred price.
     * @return A filtered food option.
     * @throws FlirtForkException If not enough food options are available.
     */
    public Food getFilteredFood(String preferredLocation, String preferredPrice) throws FlirtForkException{
        ArrayList<Food> filteredFoods = new ArrayList<>();
        for (Food eachFood : foods) {
            if (eachFood.location.equals(preferredLocation) && 
                    eachFood.price.equals(preferredPrice) && eachFood.completionStatus.equals("U")) {
                filteredFoods.add(eachFood);
            }
        }
        
        if (filteredFoods.size()<=1) {
            throw new FlirtForkException("Not enough food options");
        } else {
            Random random = new Random();
            int filteredFoodIndex = random.nextInt(filteredFoods.size());
            return filteredFoods.get(filteredFoodIndex);
        }
    }

    /**
     * Retrieves a customised food option based on preferred location and cuisine.
     *
     * @param preferredLocation The preferred location.
     * @param preferredCuisine The preferred cuisine.
     * @return A customised food option.
     * @throws FlirtForkException If not enough food options are available.
     */
    public Food getCustomisedFood(String preferredLocation, String preferredCuisine) throws FlirtForkException{
        ArrayList<Food> filteredFoods = new ArrayList<>();
        for (Food eachFood : foods) {
            if (eachFood.location.equals(preferredLocation) && 
                    eachFood.cuisine.equals(preferredCuisine) && eachFood.completionStatus.equals("U")) {
                filteredFoods.add(eachFood);
            }
        }
        
        if (filteredFoods.size()<=1) {
            throw new FlirtForkException("Not enough food options");
        } else {
            Random random = new Random();
            int filteredFoodIndex = random.nextInt(filteredFoods.size());
            return filteredFoods.get(filteredFoodIndex);
        }
    }
}


