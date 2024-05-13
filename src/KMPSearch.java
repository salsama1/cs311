
public class KMPSearch {
	 public static int search(String text, String pattern) {
	        int n = text.length();
	        int m = pattern.length();
	        int[] lps = computeLPSArray(pattern);
	        int i = 0; // index for text
	        int j = 0; // index for pattern

	        while (i < n) {
	            if (pattern.charAt(j) == text.charAt(i)) {
	                i++;
	                j++;
	            }
	            if (j == m) {
	                return i - j; // pattern found at index (i - j)
	            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
	                if (j != 0) {
	                    j = lps[j - 1];
	                } else {
	                    i = i + 1;
	                }
	            }
	        }
	        return -1; // pattern not found
	    }

	    private static int[] computeLPSArray(String pattern) {
	        int length = 0; // length of the previous longest prefix suffix
	        int i = 1;
	        int[] lps = new int[pattern.length()];
	        lps[0] = 0; // lps[0] is always 0

	        while (i < pattern.length()) {
	            if (pattern.charAt(i) == pattern.charAt(length)) {
	                length++;
	                lps[i] = length;
	                i++;
	            } else {
	                if (length != 0) {
	                    length = lps[length - 1];
	                } else {
	                    lps[i] = 0;
	                    i++;
	                }
	            }
	        }
	        return lps;
	    }
}
