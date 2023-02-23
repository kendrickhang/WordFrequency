import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {

    public static void wordFrequency(String fileName) {
        Map<String, Integer> wordMap = new TreeMap<>();
        //hashmap = randomly
        //treemap = orderly alphabetically

        try (Scanner s = new Scanner(new File(fileName))) {
            while (s.hasNext()) {
                String current = s.next();

                if (wordMap.containsKey(current)) {
                    int currentCount = wordMap.get(current);
                    currentCount++;
                    wordMap.put(current, currentCount);
                } else {
                    wordMap.put(current, 1);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }

        for (String key : wordMap.keySet()) {
            System.out.println(key + " appears " + wordMap.get(key) + " times");
        }
        //max word count display
        if(MaxWordCount(wordMap).size() > 1){
            System.out.print("The words that appear the most often are");
            int count = MaxWordCount(wordMap).size();
            for(String key : MaxWordCount(wordMap).keySet()){
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
            System.out.print("The word that appears the most often is ");
            for(String key : MaxWordCount(wordMap).keySet()) {
                System.out.println("\"" + key + "\".");
            }
        }

    }
    //max word count
    public static Map<String, Integer> MaxWordCount(Map<String, Integer> currentMap){
        int max = 0;
        Map<String, Integer> MaxWordCount = new HashMap<>();
        for(String key : currentMap.keySet()){
            if(currentMap.get(key) > max){
                max = currentMap.get(key);
                MaxWordCount = new HashMap<>();
                MaxWordCount.put(key, currentMap.get(key));

            }else if(currentMap.get(key) == max){
                MaxWordCount.put(key, currentMap.get(key));
            }
        }
        return MaxWordCount;
    }
    // main method
    public static void main(String[] args) {
        wordFrequency("tinyTale.txt");
        System.out.println("");
        wordFrequency("tinytinyTale.txt");
        System.out.println("");
        wordFrequency("Tale.txt");
        System.out.println("");
        wordFrequency("medTale.txt");
    }

}
