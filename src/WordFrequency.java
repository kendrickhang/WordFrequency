import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class WordFrequency {

    public static String mostFrequentWord(Map<String,Integer> wordCounts){
        String mostFrequentWord = "";
        int maxFrequency = 0;

        for (Map.Entry<String,Integer> entry : wordCounts.entrySet()){
            String word = entry.getKey();
            int frequency = entry.getValue();

            if(frequency > maxFrequency){
                mostFrequentWord = word;
                maxFrequency = frequency;
            }
        }


        return mostFrequentWord;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Map<String,Integer> wordCounts = new TreeMap<>();

        //instantiate a scanner variable, set it to null
        Scanner infile = null;


        // do a try-catch in order to read in file
        try
        {
            infile = new Scanner(new File("medTale.txt"));

            //loop through the file, and count the iterations of each word in the file
             while(infile.hasNext()){
                 String word = infile.next();

                 if(wordCounts.containsKey(word)) {
                      int value = wordCounts.get(word);

                      value++;

                      wordCounts.put(word, value);
                 } else {
                     wordCounts.put(word,1);
                 }

             }
            String mostFrequentWord = mostFrequentWord(wordCounts);
            System.out.println("Most frequent word: " + mostFrequentWord);


        }
        catch(FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }



        System.out.println(wordCounts);


    }
}