/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author artemtabalin
 */
public class MatrixRotater {

    public static void rotate(int[][] matrix) {
        for(int layer = 0; layer < matrix.length / 2; layer++) {
            rotateLayer(matrix, layer);
        }
    }

    private static void rotateLayer(int[][] matrix, int layer) {
        int max = matrix.length - layer - 1;
        int direction = 1;
        char axis = 'x';
        int x = layer;
        int y = layer;
        int nextX = x;
        int nextY = y;
        
        while(true) {
            if(axis == 'x') {
                nextX += direction;
            } else {
                nextY += direction;
            }
            
            if(nextX == x && nextY == y)
                break;
            
            swap(matrix, x, y, nextX, nextY);
            
            if(axis == 'x' && (nextX == x || nextX == max)) {
                axis = 'y';
                direction = (nextY == y) ? 1 : -1;
            } else if(axis == 'y' && (nextY == y || nextY == max)) {
                axis = 'x';
                direction = (nextX == x) ? 1 : -1;
            }
        }
    }

    private static void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int buf = matrix[y1][x1];
        matrix[y1][x1] = matrix[y2][x2];
        matrix[y2][x2] = buf;
    }
    
}
