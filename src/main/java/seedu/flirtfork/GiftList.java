package seedu.flirtfork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GiftList {

    private ArrayList<Gift> gifts;
    private HashSet<Gift> suggestedGifts = new HashSet<>();

    public GiftList(ArrayList<Gift> gifts) {
        this.gifts = gifts;
    }

    public int size() {
        return gifts.size();
    }

    public Gift get(int i) {
        return gifts.get(i);
    }

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
