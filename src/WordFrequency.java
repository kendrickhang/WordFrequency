import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Kevin Stone
 * SDEV 333: Data Structures
 * Assignment: Word Frequency Counter
 * - Read in a file and count up the number of times each word occurs in the file.
 */
public class WordFrequency {
    public static void main(String[] args) {

        Map<String, Integer> wordCounts = new TreeMap<>();

        try {
            Scanner infile = new Scanner(new File("medTale.txt"));

            while (infile.hasNext()) {
                String word = infile.next();

                // check to see if the word is in the map
                if (wordCounts.containsKey(word)) {

                    // get the existing value
                    int value = wordCounts.get(word);

                    // increment the count (value)
                    value++;

                    // update the updated value back in
                    wordCounts.put(word, value);
                }
                else {
                    // add the word to he map with a value of 1
                    wordCounts.put(word, 1);
                }
            }

            System.out.println(wordCounts);


            // write a loop to walk through (visit) items in the map
            for ( String key : wordCounts.keySet() ) {
                int value = wordCounts.get(key);
                System.out.println("The word '" + key + "' appears " +
                        value + " times.");
            }

        }
        catch ( FileNotFoundException exception) {

        }
    }
}