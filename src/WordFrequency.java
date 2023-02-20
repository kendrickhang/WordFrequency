import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
    public static void wordFrequency(String fileName) {
        Map<String, Integer> wordMap = new HashMap<>();


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

        for(String key : wordMap.keySet()){
            System.out.println(key + " appears " + wordMap.get(key) + " times");
        }
        Map<String, Integer> maxWords = findMax(wordMap);
        if(maxWords.size() > 1){
            System.out.print("The words that appear the most times are");
            int count = maxWords.size();
            for(String key : maxWords.keySet()){
                System.out.print(" \"" + key + "\"");
                if(count > 2){
                    System.out.print(",");
                }
                else if(count > 1){
                    System.out.print(", and");
                }
                count--;
            }
            System.out.println(".");
        }else{
            System.out.print("The word that appears the most times is ");
            for(String key : maxWords.keySet()) {
                System.out.println("\"" + key + "\".");
            }
        }

    }

    public static Map<String, Integer> findMax(Map<String, Integer> thisMap){
        int max = 0;
        Map<String, Integer> maxMap = new HashMap<>();
        for(String key : thisMap.keySet()){
            if(thisMap.get(key) > max){
                max = thisMap.get(key);
                maxMap = new HashMap<>();
                maxMap.put(key, thisMap.get(key));

            }else if(thisMap.get(key) == max){
                maxMap.put(key, thisMap.get(key));
            }
        }
        return maxMap;
    }

    public static void main(String[] args) {

        System.out.println("Hello world!");
        wordFrequency("medTale.txt");
    }




}