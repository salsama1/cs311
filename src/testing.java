import java.util.Scanner;

public class testing {
    Scanner kb= new Scanner(System.in);

		    // Brute Force String Match
		    public static int bruteForceMatch(String text, String pattern) {
		        int n = text.length();
		        int m = pattern.length();
		        
		        for (int i = 0; i <= n - m; i++) {
		            int j;
		            for (j = 0; j < m; j++) {
		                if (text.charAt(i + j) != pattern.charAt(j)) {
		                    break;
		                }
		            }
		            if (j == m) {
		                return i;  // Pattern found at index i
		            }
		        }
		        return -1;  // Pattern not found
		    }

		    // KMP Algorithm
		    public static void kmpSearch(String text, String pattern) {
		        int M = pattern.length();
		        int N = text.length();
		        int lps[] = new int[M];
		        int j = 0;  // length of previous longest prefix suffix

		        computeLPSArray(pattern, M, lps);

		        int i = 0;  // index for txt[]
		        while (i < N) {
		            if (pattern.charAt(j) == text.charAt(i)) {
		                j++;
		                i++;
		            }
		            if (j == M) {
		                System.out.println("KMP: Found pattern at index " + (i - j));
		                j = lps[j - 1];
		            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
		                if (j != 0) {
		                    j = lps[j - 1];
		                } else {
		                    i = i + 1;
		                }
		            }
		        }
		    }

		    private static void computeLPSArray(String pat, int M, int lps[]) {
		        int len = 0;
		        int i = 1;
		        lps[0] = 0;

		        while (i < M) {
		            if (pat.charAt(i) == pat.charAt(len)) {
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
		    }

		    // Boyer-Moore Algorithm
		    public static void boyerMoore(String text, String pattern) {
		        int n = text.length();
		        int m = pattern.length();
		        int[] last = new int[256]; // the ASCII table

		        // initialize all occurrences as -1
		        for (int i = 0; i < 256; i++)
		            last[i] = -1;
		        
		        // Fill the actual value of last occurrence of a character
		        for (int i = 0; i < m; i++)
		            last[pattern.charAt(i)] = i;
		        
		        int s = 0;  // s is shift of the pattern with respect to text
		        while (s <= (n - m)) {
		            int j = m - 1;

		            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j))
		                j--;

		            if (j < 0) {
		                System.out.println("Boyer-Moore: Patterns occur at shift = " + s);
		                s += (s + m < n) ? m - last[text.charAt(s + m)] : 1;
		            } else {
		                s += Math.max(1, j - last[text.charAt(s + j)]);
		            }
		        }
		    }
}
