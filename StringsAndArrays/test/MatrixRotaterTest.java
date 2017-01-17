
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author artemtabalin
 */
public class MatrixRotaterTest {
    
    @Test
    public void testRotateMatrix() {
        int[][] array = new int[][] {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 },
        };
        
        int[][] expectedResult = new int[][] {
            { 5, 1, 2, 3 },
            { 9, 10, 6, 4 },
            { 13, 11, 7, 8 },
            { 14, 15, 16, 12 },
        };
        
        MatrixRotater.rotate(array);
        
        assertArrayEquals(expectedResult, array);
    }
    
    @Test
    public void testRotateDoubleDimensionMatrix() {
        int[][] array = new int[][] {
            { 1, 2 },
            { 4, 3 }
        };
        
        int[][] expectedResult = new int[][] {
            { 4, 1 },
            { 3, 2 }
        };
        
        MatrixRotater.rotate(array);
        
        assertArrayEquals(expectedResult, array);
    }
    
    @Test
    public void testRotateSingleElementMatrix() {
        int[][] array = new int[][] {
            { 1 }
        };
        
        int[][] expectedResult = new int[][] {
            { 1 },
        };
        
        MatrixRotater.rotate(array);
        
        assertArrayEquals(expectedResult, array);
    }
    
}
