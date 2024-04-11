package seedu.flirtfork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GiftList {

    private ArrayList<Gift> gifts;

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
                .filter(g -> (g.getGender().equalsIgnoreCase(gender) || gender.equalsIgnoreCase("any"))
                        && !g.getCompletionStatus().equals("C"))
                .collect(Collectors.toList());

        if (filteredGifts.isEmpty()) {
            return null;
        }

        Random random = new Random();
        return filteredGifts.get(random.nextInt(filteredGifts.size()));
    }
}
