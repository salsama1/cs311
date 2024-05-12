import java.util.Arrays;

public class bm {

    private static int[] preprocessBadCharacterHeuristic(String pattern) {
        int[] badChar = new int[256]; // For standard ASCII
        Arrays.fill(badChar, -1); // Initialize all occurrences as -1

        for (int i = 0; i < pattern.length(); i++) {
            badChar[(int) pattern.charAt(i)] = i; // Set the value of the character as the last position
        }
        return badChar;
    }

    public static void boyerMooreSearch(String text, String pattern) {
        int[] badChar = preprocessBadCharacterHeuristic(pattern);

        boolean first = true;
        int s = 0; // s is the shift of the pattern with respect to text
        while (s <= (text.length() - pattern.length())) {
            int j = pattern.length() - 1;

            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
                j--;
            }

            if (j < 0 && first) {
                //System.out.print("Pattern occurs at index " + s);
                first = false;
                // Shift the pattern so that the next character in text
                // aligns with the last occurrence of it in pattern.
                s += (s + pattern.length() < text.length()) ? pattern.length() - badChar[text.charAt(s + pattern.length())] : 1;

            } 
            else if(j < 0) {
                //System.out.print(" " + s);

                // Shift the pattern so that the next character in text
                // aligns with the last occurrence of it in pattern.
                s += (s + pattern.length() < text.length()) ? pattern.length() - badChar[text.charAt(s + pattern.length())] : 1;

            }
            else {
                // Shift the pattern to align the bad character in text with the rightmost
                // occurrence of it in pattern or move it one position past the mismatch
                s += Math.max(1, j - badChar[text.charAt(s + j)]);
            }
        }
    }

    
}