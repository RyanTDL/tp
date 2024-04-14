package seedu.flirtfork;

import java.util.ArrayList;

/**
 * Represents a list of favorite items.
 */
public class FavouritesList {
    private ArrayList<Favourites> favourites;

    /**
     * Constructs an empty list of favorite items.
     */
    public FavouritesList() {
        this.favourites = new ArrayList<>();
    }

    /**
     * Constructs a list of favorite items from an existing ArrayList.
     *
     * @param favourites The ArrayList containing favorite items.
     */
    public FavouritesList(ArrayList<Favourites> favourites) {
        this.favourites = favourites;
    }

    /**
     * Adds a favorite item to the list.
     *
     * @param favourite The favorite item to add.
     */
    public void addFavourite(Favourites favourite) {
        favourites.add(favourite);
    }

    /**
     * Deletes a favorite item from the list at the specified index.
     *
     * @param index The index of the favorite item to delete.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public void deleteFavourite(int index) throws IndexOutOfBoundsException{
        if (index >= 0 && index < favourites.size()) {
            favourites.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
        }
    }

    /**
     * Retrieves the list of favorite items.
     *
     * @return The ArrayList containing favorite items.
     */
    public ArrayList<Favourites> getFavourites() {
        return favourites;
    }

    /**
     * Checks if the list of favorite items is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return favourites.isEmpty();
    }

    /**
     * Formats the list of favorite items into a string.
     *
     * @return A formatted string representation of the list of favorite items.
     */
    public String getFormattedFavourites() {
        if(favourites.isEmpty()) {
            return "A blank canvas! Let's fill it with some love~";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < favourites.size(); i++) {
                sb.append((i + 1)).append(". ").append(favourites.get(i).toString()).append("\n");
            }
            return sb.toString().trim();
        }
    }
}
