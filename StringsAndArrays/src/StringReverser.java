
public class StringReverser {

    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        
        for(int i = 0; i < str.length() / 2; i++) {
            swap(chars, i, str.length() - i - 1);
        }
        
        return new String(chars);
    }
    
    private static void swap(char[] arr, int i1, int i2) {
        char ch = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = ch;
    }
}
