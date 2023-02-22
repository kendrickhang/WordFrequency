import java.util.*;
import java.io.*;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> wordCounts = new TreeMap<>();

        Scanner infile = new Scanner(new File("tinyTale.txt").getAbsolutePath());

        while(infile.hasNext()){
            String word = infile.next();

            if (wordCounts.containsKey(word)){
                int value = wordCounts.get(word);
                value++;
                wordCounts.put(word, value);
            }
            else {
                wordCounts.put(word, 1);
            }
        }

        System.out.println(wordCounts);
    }

}