import java.io.*;
import java.util.*;

/**The main function of this class reads a data file filled with words and counts how many times that word appears in the file
 *  It then displays each word with the number of times that word occurs in the file, from most frequent to least
 *
 *  @author Adam Winter
 *  @version 2023-2-16
 *
 */
public class WordFrequency {

    /**main:  does nothing with any string arguments provided
     *
     *  @author Adam Winter
     *  @version 2023-2-16
     *  @param args  array of Strings not used for anything
     */
    public static void main(String[] args) {

        File theFile = null;
        Scanner scnr = null;
        Map<String, Integer> freqMap = new TreeMap<String, Integer>();

        //ComparableWord wordObj = null;

        try{
            theFile = new File("tale.txt");
            scnr = new Scanner(theFile);
        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }catch(Exception e) {
            System.out.println(e);
        }

        while(scnr.hasNext()){
            //System.out.println(scnr.next());
            String currentWord = scnr.next();
            if(!freqMap.containsKey(currentWord)){
                freqMap.put(currentWord, 1);
            }else{
                int count = freqMap.get(currentWord);
                count++;
                freqMap.put(currentWord, count);
            }//end else
        }//end while

        Set<String> keyWords = new HashSet<String>(freqMap.keySet());
        Set<Integer> tallies = new TreeSet<Integer>(freqMap.values());
        List<Integer> tallyList = new ArrayList<>(tallies);
        for(int i = tallyList.size()-1; i >= 0; i--){
            for(String key : keyWords){
                if(freqMap.get(key) == tallyList.get(i)){
                    System.out.println(key + " : " + tallyList.get(i));
                }//end if
            }//end for
        }//end for

    }//end main

}//end class