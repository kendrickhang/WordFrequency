import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {
    public static void main(String[] args) {
        //use try-catch block to handle fileNotFound error
        try {
            //create file object and give pathname
            File file = new File("tinyTale.txt");
            //pass in the file object called file to new constructed scanner after using import.util
            Scanner fileIn = new Scanner(file);
            // Create a TreeMap to store the frequency of each word that will point to a value,being frequency
            Map<String, Integer> wordFrequency = new TreeMap<>();
            //use while loop to go through entire file using hasNext method and save each word
            while (fileIn.hasNext()) {
                //could convert all to lower case?
                String word = fileIn.next();
                // Remove any other characters from the word using regex replace with empty space
                //and save back into to variable, word
                word = word.replaceAll("[^a-zA-Z]", "");
                //use if else to check if the word is in there and fi so increment count
                //If the word is not yet in the TreeMap, we add it with a frequency count of 1.
                //could also use ++ to increment
                    if (wordFrequency.containsKey(word)) {
                        int count = wordFrequency.get(word);
                        wordFrequency.put(word, count + 1);
                    } else {
                        wordFrequency.put(word, 1);
                    }
                }


            // Print the frequency of each word using for each loop
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            //close file

            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
