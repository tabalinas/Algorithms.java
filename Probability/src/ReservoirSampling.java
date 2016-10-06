
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ReservoirSampling {

    static <T> List<T> getSample(Iterator<T> iterator, int count) {
        ArrayList<T> result = new ArrayList<>(count);
        
        for(int i = 0; iterator.hasNext(); i++) {
            T item = iterator.next();
            
            if(i < count) {
                result.add(i, item);
                continue;
            } 
            
            int index = getRandom(0, i);
            if(index < count) {
                result.set(index, item);
            }
        }
        
        return result;
    }

    private static int getRandom(int start, int end) {
        return (int)Math.floor(Math.random() * (end - start + 1)) + start;
    }
    
}
