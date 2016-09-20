
public class KmpSearch {

    static int pos(String pattern, String txt) {
        int[] lps = prepareLps(pattern);
        return find(pattern, txt, lps);
    }

    private static int[] prepareLps(String txt) {
        int[] result = new int[txt.length()];
        
        int i = 1;
        int j = 0;
        
        while(i < txt.length()) {
            if(txt.charAt(i) == txt.charAt(j)) {
                j++;
                result[i] = j;
                i++;
                continue;
            }
            
            if(j > 0) {
                j = result[j - 1];
            } else {
                i++;
            }
        }
        
        return result;
    }

    private static int find(String pattern, String txt, int[] lps) {
        int i = 0;
        int j = 0;
        
        while(i < txt.length()) {
            if(txt.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length() - 1)
                    return i - j;
                
                i++;
                j++;
                continue;
            }
            
            if(j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        
        return -1;
    }
    
}
