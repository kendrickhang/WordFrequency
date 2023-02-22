

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world!");


        Map<String,Integer> files = new TreeMap<>();
        //in method main, implement code to read in a file and count
        // up the number of times each word occurs in the file


        Scanner infile = new Scanner(new File("medTale.txt"));
        while (infile.hasNext()){
            String word = infile.next();
            //check to see if words is in the map
            if (files.containsKey(word)){
                //get the existing value out
                int value = files.get(word);

                //increment the count (value)
                value++;
                //update/put the value back in
                files.put(word,value);

            }else {
                //put word into the map
                files.put(word,1);

            }

        }//end of While loop
        System.out.println(files);


        //write a loop to walk through items in the map
        for (String key: files.keySet()){
            int value = files.get(key);
            System.out.println("word " + key + " appears " + value + " times");
        }

        for (int value : files.values()){
            System.out.println(value);
        }
        //cant look at value to get the key. only at key to get the value
    }
}