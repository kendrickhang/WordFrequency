import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {

        Map<String, Integer> wordCounts = new TreeMap<>();

        Scanner inFile = new Scanner(new File("tale.txt"));

        while(inFile.hasNext()) {
            String word = inFile.next();

            if(wordCounts.containsKey(word)) {
                //increment the count
                int value = wordCounts.get(word);

                value++;

                wordCounts.put(word, value);
            }
            else {
                //add word to the map with value of 1
                wordCounts.put(word,1);
            }
        }
    }
}