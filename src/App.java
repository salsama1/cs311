import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) throws Exception {
        int wordLength = 100; // Length of the random word
        int patternlength = 20;
        Double total = 0.0;
       

        while (wordLength <= 1000){
            String text = generate(wordLength);
            text = preprocessText(text);
    
    
            String pattern = pattern(text, patternlength);
           for(int i = 0; i < 10; i++){
            

        

 
        /*testing oBrute_force = new testing();

        long startTime = System.nanoTime();
        System.out.println("brute force:");
        oBrute_force.bruteForceMatch(text, pattern);
        long endTime = System.nanoTime();
        total += ((endTime - startTime) *  0.00001);
        System.out.println("Execution time: " + ((endTime - startTime) *  0.00001) + " nanoseconds");*/ 

        testing matcher = new testing();
        long startTimekmp = System.nanoTime();
        System.out.println("kmp :");
        matcher.kmpSearch(text, pattern);
        long endTimekmp = System.nanoTime();
        total += ((endTimekmp - startTimekmp) *  0.00001);

        System.out.println("Execution time: " + ((endTimekmp - startTimekmp) *  0.00001) + " nanoseconds");


        /*long startTimebm = System.nanoTime();
        bm oBm = new bm();
        System.out.println("bm :");
        oBm.boyerMooreSearch(text, pattern);
        long endTimebm = System.nanoTime();
        total += ((endTimebm - startTimebm) *  0.00001);


        System.out.println("Execution time: " + ((endTimebm - startTimebm) *  0.00001) + " nanoseconds");*/
        
           }
           wordLength = wordLength + 100;
           patternlength = patternlength +10;
           System.out.println(total);
           Double data = total/10.0 ;
            String filepath = "output.txtkmp";
            try (PrintWriter out = new PrintWriter(new FileOutputStream(filepath, true))) {
                out.println(data);
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            }
            total = 0.0;

        }


        
        
    }



    public static String preprocessText(String text) {
        text = text.toLowerCase();
        text = text.replaceAll("\\s+", " ");
        text = text.replaceAll("[^a-zA-Z0-9\\s]", "");
        return text;
    }

    public static String generate(int wordLength) {
        
        StringBuilder word = new StringBuilder(wordLength);
        Random random = new Random();

        for (int i = 0; i < wordLength; i++) {
            char c = (char) ('a' + random.nextInt(26)); // Generating a random lowercase letter
            word.append(c);
        }

        String randomWord = word.toString();
       // System.out.println("Generated Random Word: " + randomWord);
        return randomWord;
        

    }

    public static String pattern(String text, int length){
        Random random = new Random();
        int startIndex = random.nextInt(text.length() - (length -1)); // Adjust index range to fit 20 characters
        String randomSubstring = text.substring(startIndex, startIndex + length);
        return randomSubstring;
        
    }
    
}


