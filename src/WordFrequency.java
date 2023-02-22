import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args)  {
        System.out.println("Hello world!");

        //cannot have identical key values

        //building a table VVV
        //       keys                     values
        //   domain names       |      internet addresses
        //------------------------------------------------
        //  greenriver.edu      |      128.104.20.204
        //  superbow.net        |      201.120.100.3

        //have the type for the keys (string) and the type for the values (string)
        Map<String, String> dnsTable = new TreeMap<String, String>();

        // put a few items into the map
        //These are our key value pairs, they have both the key and the value
        dnsTable.put("geenriver.edu", "128.105.20.204");
        dnsTable.put("superbowl.net", "201.120.100.3");
        dnsTable.put("google.com", "101.101.101.101");

        System.out.println(dnsTable);
        // if i used a TreeMap keys would be printed out in order
        // HashMap keys are printed out randomly

        // get: you give it a key and it brings back the value
        // you cant give it a value to bring back a key
        String  answer = dnsTable.get("superbowl.net");
        System.out.println(answer);

        // change the value
        //cannot create a second key for greenriver.edu
        // replaces values for existing key
        dnsTable.put("greenriver.edu", "1.2.3.4");

        System.out.println(dnsTable.get("greenriver.edu"));

        Map<String, Integer> wordCounts = new TreeMap<>();

        Scanner infile = null;
        try {
            infile = new Scanner(new File("tinyTale.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (infile.hasNext()) {
            String word = infile.next(); //grab the next word from the file and save it into a string called word

            //check to see if the word is in the map
            if (wordCounts.containsKey(word)) {
                //get the existing value out
                int value = wordCounts.get(word);

                // then increment the value
                value++;

                // then update/put the value back in
                wordCounts.put(word, value);
            } else {
                //add the work to the map with a value of 1
                wordCounts.put(word, 1);
            }

        } //end of while loop

        System.out.println(wordCounts);

        //write a loop to walk through (visit) items in the map
        for (String key : wordCounts.keySet()) {
            int value = wordCounts.get(key);
            System.out.println("word " + key + " appears " + value + " times." );
        }

        //getting us the values
        for (int value : wordCounts.values()) {
            System.out.println(value);
        }

    }

}