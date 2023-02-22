import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args)
    {
        Map<String,Integer> wordCounts = new TreeMap<>();
        String mostWord = "";
        int frequency = 0;
        try(Scanner infile = new Scanner(new File("tale.txt")))
        {
            while(infile.hasNext())
            {
                String word = infile.next();

                //check to see if the word is in the map
                if(wordCounts.containsKey(word))
                {
                    //increment the count (value)
                    // get the existing value out
                    int value = wordCounts.get(word);
                    // increment the value
                    value++;
                    // update/put the updated value back in
                    if(value >= frequency)
                    {
                        frequency = value;
                        mostWord = word;
                    }
                    wordCounts.put(word,value);
                }
                else
                {
                    // add the word to the map with a value of 1
                    wordCounts.put(word,1);
                }

                //put the word into the map

            } // end of while loop

            System.out.println(wordCounts);
            System.out.println("one of the words that appears most frequently is: \"" + mostWord + "\" it appears " + frequency + " times");


        }catch (FileNotFoundException exception)
        {
            System.out.println("File Not Found");
        }












    }
}