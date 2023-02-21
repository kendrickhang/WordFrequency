import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**

 *
 * @author Jack Ruiz
 * 
 */
public class WordFrequency {

    private static void testIncrement(Map<String, Integer> map, String s) {
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
    }


    private static void printMap(Map<String, Integer> map) {
        System.out.printf("%14s | %s%n", "Word", "Occurances");
        for (String s: map.keySet()) {
            System.out.printf("%15s, %d%n", s, map.get(s));
        }
        System.out.println();
    }


    private static void printFromList(Map<String, Integer> map) {

        System.out.printf("%14s | %s%n", "Word", "Occurances");


        Set<Integer> valueSet = new TreeSet<>(map.values());

        Integer[] valueArray = valueSet.toArray(new Integer[0]);


        for (int i = valueArray.length - 1; i >= 0; i--) {

            for (String s: map.keySet()) {
                if (map.get(s).equals(valueArray[i])) {
                    System.out.printf("%15s, %d%n", s, map.get(s));
                }
            }
        }

    }


    public static void main(String[] args) {
        System.out.println("Hello world!");

        String fileName = "tinyTale.txt";

        if (args.length > 0) {
            fileName = (String)args[0];
        }



        Map<String, Integer> map = new HashMap<>();

        System.out.println("Attempting to read from file: " + fileName);


        try(Scanner fileIn = new Scanner(new File(fileName))){

            while(fileIn.hasNext()) {


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


        printFromList(map);
    }
}