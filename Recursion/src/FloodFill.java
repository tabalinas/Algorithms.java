
public class FloodFill {
    public static class Image {

        private final int[][] bits;
        private int height;
        private int width;
        
        public int[][] getBits() {
            return bits;
        }
        
        public Image(int[][] bits) {
            this.bits = bits;
            this.height = bits.length;
            this.width = bits[0].length;
        }

        public void fill(int x, int y, int targetColor) {
            int srcColor = this.bits[y][x];
            
            if(srcColor == targetColor)
                return;
            
            fill(x, y, srcColor, targetColor);
        }

        private void fill(int x, int y, int srcColor, int targetColor) {
            if(x < 0 || x >= this.width || y < 0 || y >= this.height || this.bits[y][x] != srcColor)
                return;
            
            this.bits[y][x] = targetColor;
            
            fill(x - 1, y, srcColor, targetColor);
            fill(x + 1, y, srcColor, targetColor);
            fill(x, y - 1, srcColor, targetColor);
            fill(x, y + 1, srcColor, targetColor);
        }
    
    }
}
