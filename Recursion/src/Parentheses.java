
import java.util.HashSet;


public class Parentheses {
    
    HashSet<String> results;
    int count;
    
    public HashSet<String> generate(int count) {
        results = new HashSet<>();
        this.count = count;
        
        generate(0, 0, "");
        
        return results;
    }

    private void generate(int open, int close, String result) {
        if(open == close && open == count) {
            results.add(result);
            return;
        }
        
        if(open < count) {
            generate(open + 1, close, result + "(");
        }
        
        if(open > close) {
            generate(open, close + 1, result + ")");
        }
    }
    
}
