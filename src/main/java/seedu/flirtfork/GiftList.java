package seedu.flirtfork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Manages a collection of gifts, including operations to get a random gift
 * and track which gifts have been suggested using a hashset.
 */
public class GiftList {

    private ArrayList<Gift> gifts;
    private HashSet<Gift> suggestedGifts = new HashSet<>();

    /**
     * Constructs a GiftList with an initial list of gifts.
     *
     * @param gifts The initial list of gifts.
     */
    public GiftList(ArrayList<Gift> gifts) {
        this.gifts = gifts;
    }

    public int size() {
        return gifts.size();
    }

    public Gift get(int i) {
        return gifts.get(i);
    }

    /**
     * Retrieves a random gift from the list that matches the specified gender
     * and has not been suggested or marked as complete.
     * If all gifts have been suggested, it clears the record of suggested gifts and returns null.
     *
     * @param gender The gender filter for the gift suggestions (M, F, U, or any).
     * @return A random, unsuggested gift that matches the gender filter, or null if all have been suggested.
     */
    public Gift getRandomGift(String gender) {
        List<Gift> filteredGifts = gifts.stream()
                .filter(g -> (gender.equals("any") || g.getGender().equalsIgnoreCase(gender))
                        && !g.getCompletionStatus().equals("C") && !suggestedGifts.contains(g))
                .collect(Collectors.toList());

        if (filteredGifts.isEmpty()) {
            suggestedGifts.clear();
            return null;
        }

        Random random = new Random();
        Gift randomGift = filteredGifts.get(random.nextInt(filteredGifts.size()));
        suggestedGifts.add(randomGift);
        return randomGift;
    }
}
