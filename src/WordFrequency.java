import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This class reads through a text file and counts the number
 * of times a word occurs in the text file - uses Map, Scanner, and Linked Map classes.
 *
 * @author Jasmine David
 */
public class WordFrequency {

    public static void main(String[] args) {
        Map<String, Integer> wordCounts = new TreeMap<>();
        String maxWord = "";
        int maxCount = 0;

        // create scanner to read the file
        try(Scanner inFile = new Scanner(new File("tinyTale.txt"))) {

            // grab next word in file and save in String called word
            while (inFile.hasNext()) {
                String word = inFile.next();

                // check to see if the word is in the map
                if (wordCounts.containsKey(word)) { // if in the table
                    // get the existing value out
                    int value = wordCounts.get(word);
                    // increment the value
                    value++;
                    // update/put the updated value back in
                    wordCounts.put(word, value);

                    // Find word with the highest frequency count
                    if (value > maxCount) {
                        maxCount = wordCounts.get(word);
                        maxWord = word;
                    }

                    } else { // if not in table
                    // add the word to the map with a value of 1
                    wordCounts.put(word, 1);
                }
            } // end of the while loop

            System.out.println(wordCounts);
            System.out.println(maxWord + " appeared the most at " + maxCount + " times");


        }
        catch (FileNotFoundException e){
            System.out.println("ERROR - File Not Found");
        }

    }
}