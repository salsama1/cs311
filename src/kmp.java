public class kmp {

       
    
        // Function to perform KMP algorithm to find all occurrences of a pattern in the given text
        public void KMPMatch(String text, String pattern) {
            int[] lps = computeLPSArray(pattern);
            int i = 0;
            int j = 0;
            boolean first = true;
    
            while (i < text.length()) {
                if (pattern.charAt(j) == text.charAt(i)) {
                    i++;
                    j++;
                }
                if (j == pattern.length() && first) {
                    first = false;
                    //System.out.print("Found pattern at index " + (i - j) + " ");
                    j = lps[j - 1];
                }
                else if (j == pattern.length()){
                    first = false;
                    //System.out.print((i - j) + " ");
                    j = lps[j - 1];
                }
                else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                    if (j != 0) {
                        j = lps[j - 1];
                    } else {
                        i = i + 1;
                    }
                }
            }
        }
    
        private int[] computeLPSArray(String pattern) {
            int[] lps = new int[pattern.length()];
            int len = 0;
            int i = 1;
            lps[0] = 0;
    
            while (i < pattern.length()) {
                if (pattern.charAt(i) == pattern.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                } else {
                    if (len != 0) {
                        len = lps[len - 1];
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }
            return lps;
        }
    
    
}
