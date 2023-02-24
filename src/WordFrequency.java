import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        Map<String, Integer> wordCounts = new TreeMap<>();
        //Had to use absolute pathing - scanner would not find the file otherwise.
        File tale = new File("C:\\Users\\USMC_\\Desktop\\Classes\\SDEV 333\\WordFrequency\\tale.txt");
        Scanner inFile = null;
        try {
            inFile = new Scanner(tale);
            while (inFile.hasNext()) {
                String word = inFile.next();

                if (wordCounts.containsKey(word)) {
                    //increment the count
                    int value = wordCounts.get(word);

                    value++;

                    wordCounts.put(word, value);
                } else {
                    //add word to the map with value of 1
                    wordCounts.put(word, 1);
                }//end of if else statement
            }//end of while loop
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        //write a loop to walk through items in the map and print how many times they occur
        for (String key : wordCounts.keySet()) {
            int value = wordCounts.get(key);
            System.out.println("word " + key + " appears " + value + " times");
        }
    }
}