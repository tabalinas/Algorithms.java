
import java.util.List;
import java.util.Random;


public class ShuffleCards<T> {
    
    private final Random random;
    
    public ShuffleCards(long seed) {
        this.random = new Random(seed);
    }
    
    public void shuffle(List<T> cards) {
        for(int i = 0; i < cards.size(); i++) {
            swap(cards, i, getRandom(i, cards.size() - 1));
        }
    }
    
    private int getRandom(int start, int end) {
        return random.nextInt(end - start + 1) + start;
    }

    private <T> void swap(List<T> cards, int index1, int index2) {
        T buf = cards.get(index1);
        cards.set(index1, cards.get(index2));
        cards.set(index2, buf);
    }
    
}
