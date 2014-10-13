import java.util.Comparator;

/**
 * The comparator for int
 * @author Hussein Abou Nassif Mourad hassuni9
 * @version June 4, 2014
 */
public class IntComp implements Comparator<Integer> {

    /**
     * Compares two integers
     * @param o1 the first integer
     * @param o2 the second integer
     * @return the difference in integer
     */
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }

}
