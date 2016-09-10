
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;


public class QueensTest {

    @Test
    public void testQueensProblem() {
        int size = 4;
        
        HashSet<HashSet<Queens.Cell>> expectedResult = new HashSet<>();
        expectedResult.add(prepareSolution(1, 0, 3, 1, 0, 2, 2, 3));
        expectedResult.add(prepareSolution(2, 0, 0, 1, 3, 2, 1, 3));
        
        HashSet<HashSet<Queens.Cell>> actualResult = new Queens().solve(size);
        
        assertEquals(expectedResult.size(), actualResult.size());
        for(HashSet<Queens.Cell> result : actualResult) {
            expectedResult.contains(result);
        }
    }
    
    private HashSet<Queens.Cell> prepareSolution(int row1, int col1, int row2, int col2, int row3, int col3, int row4, int col4) {
        HashSet<Queens.Cell> result = new HashSet<>();
        result.add(new Queens.Cell(row1, col1));
        result.add(new Queens.Cell(row2, col2));
        result.add(new Queens.Cell(row3, col3));
        result.add(new Queens.Cell(row4, col4));
        return result;
    }
    
}
