import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Katherine Watkins
 * SDEV 333
 * 02/20/2023
 * WordFrequency assignment
 */

public class WordFrequency {
     /**
     *
     * @param fileName is a String that the scanner uses to find the file
     * @return returns a Map with all the words and their frequency within the specified file
     */
    public static Map<String, Integer> wordFrequency(String fileName) {
        //map to store each word and it's frequency
        Map<String, Integer> wordMap = new TreeMap<>();
        //scanner in a try catch for FileNotFoundException
        try (Scanner s = new Scanner(new File(fileName))) {
            while (s.hasNext()) {
                String current = s.next();

                if(wordMap.containsKey(current)){
                    int currentCount = wordMap.get(current);
                    currentCount++;
                    wordMap.put(current, currentCount);
                }else{
                    wordMap.put(current, 1);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return wordMap;
    }

    /**
     * This method finds the most frequent word/words and prints those to the console.
     * @param thisMap takes in a map as a parameter that has words as keys and their frequency as values
     */
    public static void findMax(Map<String, Integer> thisMap){
        //int to keep track of max value found
        int max = 0;
        //new map to store highest value/values
        Map<String, Integer> maxMap = new HashMap<>();
        //iterate through the map to find the highest frequency word or words
        for(String key : thisMap.keySet()){
            //if current word has HIGHER value than previous max, reset the maxMap and put the new values
            if(thisMap.get(key) > max){
                max = thisMap.get(key);
                maxMap = new HashMap<>();
                maxMap.put(key, thisMap.get(key));

            }
            //if multiple words have the same max frequency, add them to maxMap
            else if(thisMap.get(key) == max){
                maxMap.put(key, thisMap.get(key));
            }
        }
        //Print out the word/words that appear most, if more than one word is in maxMap it will print differently than if there is only one
        if(maxMap.size() > 1){
            int num = 0;
            System.out.print("The words that appear the most times are");
            int count = maxMap.size();
            for(String key : maxMap.keySet()){
                num = maxMap.get(key);
                System.out.print(" \"" + key + "\"");
                if(count > 2){
                    System.out.print(",");
                }
                else if(count > 1){
                    System.out.print(", and");
                }
                count--;
            }
            System.out.println(". They each appear " + num + " times.");
        }else{
            System.out.print("The word that appears the most times is ");
            for(String key : maxMap.keySet()) {
                System.out.println("\"" + key + "\" and it appears " + maxMap.get(key) + " times.");
            }
        }
    }

    public static void main(String[] args) {
        //frequency Map stored in variable
        Map<String, Integer> wordMap = wordFrequency("tale.txt");
        //for loop to print out each word and it's frequency
        for(String key : wordMap.keySet()){
            System.out.println(key + " appears " + wordMap.get(key) + " times");
        }
        //call to findMax that will print out the most frequently used word/words
        findMax(wordMap);
    }
}