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

    }

    public static void main(String[] args) {

        System.out.println("Hello world!");
        wordFrequency("tinyTale.txt");
    }




}