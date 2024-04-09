package seedu.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStream;

public class Storage {
    private static final String USER_DETAILS_FILE = "./data/UserDetails.txt";
    private static final String FAVOURITES_DETAILS_FILE = "./data/Favourites.txt";
    private static final String FOOD_DETAILS_FILE = "./data/FoodList.txt";
    private static final String ACTIVITIES_DETAILS_FILE = "./data/ActivityList.txt";
    private static final String GIFTS_DETAILS_FILE = "./src/main/resources/GiftList.txt";
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public FavouritesList loadFavourites() throws FileNotFoundException {
        try {
            ArrayList<Favourites> loadedFavourites = new ArrayList<>();
            File file = new File(FAVOURITES_DETAILS_FILE);
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    Favourites favourites = new Favourites(line);
                    loadedFavourites.add(favourites);
                }
                scanner.close();
                return new FavouritesList(loadedFavourites);
            }
        } catch (FileNotFoundException e) {
            System.out.println("OOPS! No saved tasks found, starting with an empty list ~");
        }
        return new FavouritesList();
    }

    public void saveFavourites(ArrayList<Favourites> favourites) throws IOException {
        try {
            File file = new File(FAVOURITES_DETAILS_FILE);
            File parentDir = file.getParentFile();

            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }

            FileWriter writer = new FileWriter(file);
            for (Favourites favourite : favourites) {
                writer.write(favourite.toFileFormat() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("OOPS! An error occurred while saving tasks.");
            e.printStackTrace();
        }
    }

    public void saveUserDetails(UserDetails userDetails) {
        try {
            File file = new File(USER_DETAILS_FILE);
            File parentDir = file.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(userDetails.toFileFormat());
            writer.close();
        } catch (IOException e) {
            System.out.println("OOPS! An error occurred while saving user details.");
            e.printStackTrace();
        }
    }

    public UserDetails loadUserDetails() {
        try {
            File file = new File(USER_DETAILS_FILE);
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] details = line.split(" \\| ");
                    scanner.close();
                    return new UserDetails(details[0], details[1], details[2], details[3], details[4],
                            details[5], details[6]);
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("OOPS! No saved user details found.");
        }
        return new UserDetails();
    }

    public ArrayList<Activity> loadActivity() throws FileNotFoundException {
        ArrayList<Activity> loadedActivities = new ArrayList<>();

        File file = new File(ACTIVITIES_DETAILS_FILE);
        Scanner scanner1 = new Scanner(file);
        // File is not empty, aka not the first time JAR is being run
        if (scanner1.hasNextLine()) {
            while (scanner1.hasNextLine()) {
                String line = scanner1.nextLine();
                // Parse the line into an Activity object and add it to the list
                loadedActivities.add(Parser.parseActivity(line));
            }
            scanner1.close();
        } else {
            // If file does not exist, aka the first time JAR file is loaded
            scanner1.close();
            InputStream is = getClass().getClassLoader().getResourceAsStream("ActivityList.txt");
            if (is == null) {
                throw new FileNotFoundException("Activity list file not found");
            }
            try (Scanner scanner2 = new Scanner(is)) {
                while (scanner2.hasNextLine()) {
                    String line = scanner2.nextLine();
                    // Parse the line into an Activity object and add it to the list
                    loadedActivities.add(Parser.parseActivity(line));
                }
            }
        }
        return loadedActivities;
    }

    public void saveFood(FoodList foods) {
        try {
            File file = new File(FOOD_DETAILS_FILE);
            File parentDir = file.getParentFile();

            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }

            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < foods.size(); i++) {
                Food oneFood = foods.get(i);
                writer.write(oneFood.description + " | " + oneFood.location + " | " +
                        oneFood.price + " | " + oneFood.cuisine + " | " + oneFood.completionStatus + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("OOPS! An error occurred while saving tasks.");
            e.printStackTrace();
        }
    }

    public ArrayList<Food> loadFood() throws FileNotFoundException {
        ArrayList<Food> loadedFoods = new ArrayList<>();
        File file = new File(FOOD_DETAILS_FILE);
        Scanner scanner1 = new Scanner(file);
        // If file already exist
        if (scanner1.hasNextLine()) {
            while (scanner1.hasNextLine()) {
                String line = scanner1.nextLine();
                // Parse the line into an Activity object and add it to the list
                loadedFoods.add(Parser.parseFood(line));
            }
            scanner1.close();
        // If file does not exist, aka the first time JAR file is loaded
        } else {
            scanner1.close();
            InputStream is = getClass().getClassLoader().getResourceAsStream("FoodList.txt");
            if (is == null) {
                throw new FileNotFoundException("Food list file not found");
            }
            try (Scanner scanner2 = new Scanner(is)) {
                while (scanner2.hasNextLine()) {
                    String line = scanner2.nextLine();
                    // Parse the line into a Food object and add it to the list
                    loadedFoods.add(Parser.parseFood(line));
                }
            }
        }
        return loadedFoods;
    }

    public void saveActivity(ActivityList activities) {
        try {
            File file = new File(ACTIVITIES_DETAILS_FILE);
            File parentDir = file.getParentFile();

            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }

            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < activities.size(); i++) {
                Activity oneActivity = activities.get(i);
                writer.write(oneActivity.description + " | " + oneActivity.location + " | " +
                        oneActivity.price + " | " + oneActivity.completionStatus + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("OOPS! An error occurred while saving tasks.");
            e.printStackTrace();
        }
    }

    public ArrayList<Gift> loadGift() throws FileNotFoundException {
        ArrayList<Gift> loadedGift = new ArrayList<>();
        InputStream is = getClass().getClassLoader().getResourceAsStream("GiftList.txt");
        if (is == null) {
            throw new FileNotFoundException("Gift list file not found");
        }
        try (Scanner scanner = new Scanner(is)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Parse the line into an Activity object and add it to the list
                loadedGift.add(Parser.parseGift(line));
            }
        }
        return loadedGift;
    }

    public void saveGift(GiftList gifts) {
        try (FileWriter writer = new FileWriter(GIFTS_DETAILS_FILE)) {
            for (int i = 0; i < gifts.size(); i++) {
                Gift oneGift = gifts.get(i);
                writer.write(oneGift.description + " | " + oneGift.completionStatus + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("OOPS! An error occurred while saving tasks.");
            e.printStackTrace();
        }
    }
}
