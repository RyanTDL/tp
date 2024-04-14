package seedu.flirtfork;

import java.util.ArrayList;
import java.util.Random;

import seedu.flirtfork.exceptions.FlirtForkException;

public class FoodList {
    private ArrayList<Food> foods;

    public FoodList() {
        this.foods = new ArrayList<>();
    }

    public FoodList(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public int size() {
        return foods.size();
    }

    public Food get(int i) {
        return foods.get(i);
    }

    public void add(Food newFood) {
        foods.add(newFood);
    }
    
    public Food getRandomFood() {
        Food randomFood;
        do {
            Random random = new Random();
            int foodIndex = random.nextInt(foods.size());
            randomFood = foods.get(foodIndex);
        } while (randomFood.completionStatus.equals("C"));
        return randomFood;
    }

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


    public ArrayList<Food> findFood(String keyword) {
        ArrayList<Food> matchingFoods = new ArrayList<>();

        for(Food food : foods) {
            String description = food.getDescription();
            if (description.contains(keyword)) { //need to make sure the search is not case-sensitive
                matchingFoods.add(food);
            }
        }
        return matchingFoods;
    }
}


