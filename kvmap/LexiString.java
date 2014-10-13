package kvmap;
import java.util.*;

/**
 * Representing comparison by Strings
 * @author Hussein Abou Nassif Mourad
 * @version 05-21-2014
 */
public class LexiString implements Comparator<String> {

    /** 
     * Comparing the strings
     * @param firstS the first string
     * @param otherS the second string
     * @return number which is after comparing
     */
    public int compare(String firstS, String otherS) {
        return firstS.compareTo(otherS);
    }

}
