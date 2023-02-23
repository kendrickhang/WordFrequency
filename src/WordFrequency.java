import javax.crypto.spec.PSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args){
        System.out.println("Hello world!");

        Map<String, Integer> wordCount = new TreeMap<>();

        int mostAppears = 0;
        List<String> mostWord = new ArrayList<>();

        try{
            Scanner inFile = new Scanner(new File("tinyTale.txt"));
            while (inFile.hasNext()){
                String word = inFile.next();

                //check to see if the word is in the Map
                if(wordCount.containsKey(word)){
                    //get the existing value out
                    int value = wordCount.get(word);

                    //increment the value
                    value++;

                    //put the updated value back in
                    wordCount.put(word, value);

                    if(value > mostAppears){
                        mostAppears = value;
                        mostWord.clear();
                        mostWord.add(word);
                    }else if (value == mostAppears){
                        mostWord.add(word);
                    }
                }else{
                    wordCount.put(word, 1);
                }
            }//end of while loop

        }catch (FileNotFoundException e){
            System.out.println("File not found " + e.getMessage());
        }catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }

        //print out the most frequently words
        if (mostWord.size() == 1) { //if there is only one word
            System.out.println("The word that appears most frequently is: " + mostWord.get(0) + " ("
                    + mostAppears + " times)");
        } else { //if there are multiple words that have the same highest frequency
            System.out.println("The words that appear most frequently are:");
            for (String word : mostWord) {
                System.out.println(word);
            }
            System.out.println("(" + mostAppears + " times each)");
        }

        //write a loop to walk through items in the map
        for(String key:wordCount.keySet()){
            int value = wordCount.get(key);
            System.out.println("Word " + "'" + key + "'" + " appears " + value + " times.");
        }
    }
}