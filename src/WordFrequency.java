import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {
    public static void main(String[] args) {

        // creates an empty map (empty symbol table)
        Map<String, String> petTable = new TreeMap<>();
        // TreeMap keys are in order, HashMap keys are random

        // put a few itesm into map
        petTable.put("Leo", "Husky");
        petTable.put("Chester", "Labrador Retriever");
        petTable.put("Buddy", "Golden Retriever");

        System.out.println(petTable);

        // use get method key to return value. Does not work the other way
        String find = petTable.get("Leo");
        System.out.println(find);

        // change the value
        petTable.put("Leo", "The Golden doodle");
        System.out.println(petTable.get("Leo"));

        // keys | values
        // "the" | 12
        // "city" | 1
        Map<String, Integer> wordCounts = new TreeMap<>();
        try {
            Scanner scan = new Scanner(new File("tale.txt"));
            while (scan.hasNext()) {
                String word = scan.next();
                if(wordCounts.containsKey(word)) {
                    // increment the count (value)
                    // get the existing value out then increment
                    int value = wordCounts.get(word);
                    value++;
                    // update and put the updated value
                    wordCounts.put(word,value);
                } else {
                    // add words to the map with a value of 1
                    wordCounts.put(word,1);
                }
            } // end of while
            System.out.println(wordCounts);

            // write a loop to talk through items in map
            for (String key : wordCounts.keySet()) {
                int value = wordCounts.get(key);
                System.out.println("words " + key + " appears " + value);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}