import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {
    public static void main(String[] args) {

        Map<String, Integer> wordCounts = new TreeMap<>();

       try(Scanner infile = new Scanner(new File("medTale.txt"))) {

            while (infile.hasNext()) {
                String word = infile.next();

                //check to see it the word is in the map
                if (wordCounts.containsKey(word)) {
                    //get the existing value out
                    int value = wordCounts.get(word);

                    //increment the count (value)
                    value++;

                    //update/put the updated value back in
                    wordCounts.put(word, value);
                } else {
                    //add the word to the map with a value of 1
                    wordCounts.put(word, 1);
                }
            }// end of while loop

        System.out.println(wordCounts);

       }catch (FileNotFoundException exception){
           System.out.println("File Not Found");
       }

        // Find the word with the most frequency count
        String maxWord = "";
        int maxCount = 0;

        for (String currentWord : wordCounts.keySet()) {
            int currentCount = wordCounts.get(currentWord);
            if (currentCount > maxCount) {
                maxWord = currentWord;
                maxCount = currentCount;
            }
        }// this only shows you the first word with max numbers
        // (if there is more than one, it shows the first one by alphabetic order)

        System.out.println("\n The word to appear most times is {" + maxWord +
                "}, appearing " + maxCount + " times in this text.");

    }
}
