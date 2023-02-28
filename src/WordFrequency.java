import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class WordFrequency {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Map<String, Integer> wordCounts = new TreeMap<>();

        Scanner inFile = null;
        try {
            inFile = new Scanner(new File("tinyTale.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(inFile.hasNext()) {
            String word = inFile.next();
            //System.out.println(word);
            // TODO: use functions to clean word up for better reading
            word = cleanWord(word);


            //check to see if the word is in the map
            if(wordCounts.containsKey(word)) {
                //increment count (value)
                //get the existing value out
                int value = wordCounts.get(word);
                //increment the value
                value++;

                //put the updated value back in
                wordCounts.put(word, value);

            } else {
                //add the word to the map with a value of 1
                wordCounts.put(word, 1);

            }

        }//end of while loop

        System.out.println(wordCounts);

        // TODO: figure out the word that appears most frequently
        //for loop loops through keySet, compares value of word to las
        String frequent = null;
        int last = 0;
        for (String word : wordCounts.keySet()) {
            if(wordCounts.get(word) > last) {
                last = wordCounts.get(word);
                frequent = word;
            }
        }
        System.out.println(frequent);


    }

    /**
     *
     * @param word
     * @return word after using replaceAll method to clean word up by following regex pattern & replacing
     * non-aplhanumeric in string.
     */
    public static String cleanWord(String word) {
        word = word.replaceAll("[^a-zA-Z0-9]", "");

        return word;

    }
}