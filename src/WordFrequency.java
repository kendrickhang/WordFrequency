import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //scan in the file



        Map<String, Integer> wordCounts = new TreeMap<>();

        try {
            Scanner infile = new Scanner(new File("tale.txt"));

            while (infile.hasNext()){
                String word = infile.next();
                //check if word is in the map
                if(wordCounts.containsKey(word)){

                    //get the existing value
                    int value = wordCounts.get(word);
                    //increment the count
                    value++;
                    //update/put the update value back in
                    wordCounts.put(word,value);
                } else {
                    //add to the map
                    wordCounts.put(word,1);
                }

            }
        } catch (FileNotFoundException e){
            System.out.println("File not Found");
        }




        //write a loop to walk through (visit) items in the map print out each one
        for (String key: wordCounts.keySet()){
            int value = wordCounts.get(key);
            System.out.println("word " + key + " appears " + value + " times ");
        }


        //Keep track of the max value of count
        int maxValue = 0;
        String maxString = "";
        for (String key: wordCounts.keySet()){

            int value = wordCounts.get(key);
            if (value > maxValue){
                maxValue = value;
                maxString = key;
            } else if (value == maxValue){
                maxString += (", " + key);
            }

        }
        System.out.println();
        System.out.println();
        System.out.println("Max Word(s): " + maxString);
        System.out.println("Frequency: " + maxValue);
    }
}