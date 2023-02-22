import java.util.*;
import java.io.*;

public class WordFrequency {
    public static void main(String[] args){
        String file1 = "tinyTale.txt";
        String file2 = "tale.txt";

        //Map of all words appeared in files
        System.out.println("Map of " + file1 + " file: " + countWords("333/WordFrequency/" + file1));
        System.out.println("Map of " + file2 + " file: " + countWords("333/WordFrequency/" + file2));

        //This will print out the most frequent word in the files
        System.out.println(mostAppearWord(file1));
        System.out.println(mostAppearWord(file2));
    }
    public static Map<String, Integer> countWords(String fileName){

        Map<String, Integer> wordCounts = new TreeMap<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.toLowerCase().trim().split("[\\W\\d]+");
                for (String word : words) {
                    if (!word.isEmpty()) { // ignore empty strings
                        if (!wordCounts.containsKey(word)) {
                            wordCounts.put(word, 1);
                        } else {
                            wordCounts.put(word, wordCounts.get(word) + 1);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return wordCounts;
    }
    public static String mostAppearWord(String fileName){
        Map<String, Integer> wordCounts = countWords("333/WordFrequency/" + fileName);
        int mostAppeared = 0;
        String wordMostAppear = "";
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > mostAppeared) {
                mostAppeared = entry.getValue();
                wordMostAppear = entry.getKey();
            }
        }
        return "The word \"" + wordMostAppear + "\" is the most appeared in " + fileName + " file with " + mostAppeared + " times.";
    }
}