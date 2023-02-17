import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class reads in the given file, and counts the words in that file.
 * Results are printed in descending order. (not very efficiently)
 *
 * When reading in words punctuation is removed, as are spaces.  All words
 * are also converted to lower case so as to count words such as "The"
 * and "the" together.
 *
 * In addition, this program will take a command line argument for the
 * file name to read, otherwise it will default to the file "tinyTale.txt".
 *
 * @author Paul Woods, original Kendrick Hang
 * @version 2023-02-17
 */
public class WordFrequency {

    /*
     * This method takes a reference to our Map and the given String.
     * If the word exists, its counter is incremented in the Map,
     * otherwise it is added to the map as a new entry.
     */
    private static void testIncrement(Map<String, Integer> map, String s) {
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
    }

    /*
     * Helper method to simply print the map to output.  Not called in
     * final version of program, using printFromList() method below instead.
     */
    private static void printMap(Map<String, Integer> map) {
        System.out.printf("%14s | %s%n", "Word", "Occurances");
        for (String s: map.keySet()) {
            System.out.printf("%15s, %d%n", s, map.get(s));
        }
        System.out.println();
    }

    /*
     * This method takes the Map of String/Integers, and first converts
     * the Values (Integers) to a TreeSet (sortable, and one of each only).
     * This TreeSet is then converted to an array that we can read from in
     * reverse (highest to lowest), which allows us to then cycle through
     * our original Map looking for Keys that match those values.  When those
     * keys are found they are printed out, with the occurances of that
     * word in the text file.
     */
    private static void printFromList(Map<String, Integer> map) {

        System.out.printf("%14s | %s%n", "Word", "Occurances");

        // Sort by value, use Set so we have one of each
        Set<Integer> valueSet = new TreeSet<>(map.values());

        // Convert to array, utilize in for-loop below
        Integer[] valueArray = valueSet.toArray(new Integer[0]);

        // cycle through values from highest to lowest
        for (int i = valueArray.length - 1; i >= 0; i--) {

            // for each value, search entire map for words w/ that
            // number of occurances, and print
            for (String s: map.keySet()) {
                if (map.get(s).equals(valueArray[i])) {
                    System.out.printf("%15s, %d%n", s, map.get(s));
                }
            }
        }

    }

    /**
     * Main method, basis of our program.  It does take in an optional file
     * name, and if present, reads from that file.
     * @param args
     */
    public static void main(String[] args) {

        String fileName = "tinyTale.txt";

        if (args.length > 0) {
            fileName = (String)args[0];
        }

        //System.out.println("Hello world!");

        Map<String, Integer> map = new HashMap<>();

        System.out.println("Attempting to read from file: " + fileName);

        // try-catch will automatically close the scanner resource for us
        // Add de-formatted strings to HashMap, counting occurances
        try(Scanner fileIn = new Scanner(new File(fileName))){

            while(fileIn.hasNext()) {

                // remove special chars that might be attached, spaces, and
                // convert to lowercase (do not want mult entries due to case differences)
                String in = fileIn.next().replace(".","")
                        .replace(",","")
                        .replace("?","")
                        .replace("!","")
                        .trim().toLowerCase();

                testIncrement(map, in);
            }

        } catch(FileNotFoundException exception) {
            System.out.println("File not found: " + fileName);
        }

        // printMap(map);

        printFromList(map);
    }
}