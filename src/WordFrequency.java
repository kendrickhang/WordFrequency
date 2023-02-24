import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world!");

        // creates an empty map (empty symbol table)
        Map<String, String> dnsTable = new TreeMap<>();

        // put a few items into the map
        // key-value pair (key and a value)
        dnsTable.put("greenriver.edu", "128.105.20.204");
        dnsTable.put("superbowl.net", "201.120.100.3");
        dnsTable.put("google.com", "101.101.101.101");

        System.out.println(dnsTable);

        // get: you give it a key, it brings back the value
        String answer = dnsTable.get("greenriver.edu");
        System.out.println(answer);

        // change the value
        // cannot creat a second key for greenriver.edu
        //replaces value for existing key
        dnsTable.put("greenriver.edu","1.2.3.4");

        System.out.println(dnsTable.get("greenriver.edu"));

        // keys     | values
        // "the"    |   13

        Map<String, Integer> wordCounts = new TreeMap<>();

        Scanner infile = new Scanner(new File("tinyTale.txt"));

        while (infile.hasNext()) {
            String word = infile.next();
            // use functions to clean word up to remove punctuations
            // check to see if the word is in the map
            if (wordCounts.containsKey(word)) {
                // get the existing value out
                int value = wordCounts.get(word);
                // increment the count value
                value++;
                // update/put the updated value back in
                wordCounts.put(word,value);

            } else {
                // add the word to the map with a value of 1
                wordCounts.put(word,1);
            }
        } // end of while loop

        System.out.println(wordCounts);

        // write a loop to walk through (visit) item in the map
        for (String key : wordCounts.keySet()) {
            int value = wordCounts.get(key);
            System.out.println("word " + key + " appears " + value + " times.");
        }

        for (int value : wordCounts.values()) {
            System.out.println(value);
        }

        LinkedMap<String,Integer> smallEx = new LinkedMap<>();
        smallEx.put("S",0);
        smallEx.put("E",1);
        smallEx.put("A",2);
        smallEx.put("R",3);
        smallEx.put("C",4);
        smallEx.put("H",5);
    }
}