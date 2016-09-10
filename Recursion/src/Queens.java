
import java.util.HashSet;


public class Queens {
    
    HashSet<HashSet<Cell>> result;
    int size;
    
    public HashSet<HashSet<Cell>> solve(int size) {
        result = new HashSet<>();
        this.size = size;
        
        locateQueen(0, new HashSet<>());
        
        return result;
    }

    private void locateQueen(int row, HashSet<Cell> positions) {
        if(row >= size) {
            result.add(positions);
            return;
        }
        
        for(int col = 0; col < size; col++) {
            Cell cell = new Cell(row, col);
            if(isSafe(cell, positions)) {
                HashSet<Cell> newPositions = (HashSet<Cell>)positions.clone();
                newPositions.add(cell);
                locateQueen(row + 1, newPositions);
            }
        }
    }
    
    private boolean isSafe(Cell cell, HashSet<Cell> positions) {
        for(Cell c : positions) {
            if(cell.getCol() == c.getCol() || cell.getRow() == c.getRow() || cell.isSameDiagonal(c))
                return false;
        }
        return true;
    }
    
    public static class Cell {
        int row;
        int col;
        
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        private int getCol() {
            return col;
        }

        private int getRow() {
            return row;
        }
        
        public boolean isSameDiagonal(Cell cell) {
            return Math.abs(row - cell.getRow()) == Math.abs(col - cell.getCol());
        }
        
        public boolean equals(Cell cell) {
            return cell.getCol() == col && cell.getRow() == row;
        }
        
        public int hashCode() {
            return row * 31 + col;
        }
        
        public String toString() {
            return String.format("(%d, %d)", row, col);
        }
    }
}
