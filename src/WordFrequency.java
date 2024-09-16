import java.util.*;
import java.io.*;

public class WordFrequency {
    public static void main(String[] args) {
        Map<String, Integer> words = new TreeMap<>();

        String mostFrequentWord = "";
        int mostAppearances = 0;

        try {
            Scanner inFile = new Scanner(new File("tinyTale.txt"));
            while (inFile.hasNext()) {
                String word = inFile.next();

                // check to see if the word is in the map
                if (words.containsKey(word)) {
                    // increment the value
                    int value = words.get(word);
                    value++;
                    words.put(word, value);
                    // if the current word's value is less than mostAppearances
                    if (words.get(word) > mostAppearances) {
                        // assign mostAppearances equal to that value and mostFrequentWord
                        // equal to the current word in the file
                        mostAppearances = words.get(word);
                        mostFrequentWord = word;
                    }

                } else {
                    // add it to the map with a value of 1
                    words.put(word, 1);
                }
            }
            System.out.println("The most frequent word is " + mostFrequentWord +
                    ", with " + mostAppearances + " appearances.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}