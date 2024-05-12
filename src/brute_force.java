


public class brute_force {

    public static void bruteforce(String text, String pattern){
        
        boolean first = true;
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            boolean match = true;

            for (int j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match && first) {
                first = false;
                //System.out.print("Pattern found at index " + i);
            }
            else if (match){
                //System.out.print(" " +i);
            }
        }
    
    }
}
