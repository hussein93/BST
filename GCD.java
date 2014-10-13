import kvmap.KVMapVisitor;

/**
 * Implementing the GCD class
 * @author Hussein Abou Nassif Mourad
 * @version Summer1 2014
 *
 */
public class GCD implements KVMapVisitor<Integer, Integer> {

    /**
     * Override the visit method
     * @param k the first integer
     * @param v the second integer
     * @return the GCD between them
     */
    public Integer visit(Integer k, Integer v) {
        if (v == 0 || k == 0) {
            return 0;
        }
        else {
            return this.gcdHelper(v, new Integer((k % v)));
        }
    }

    /** 
     * Return the GCD
     * @param divisor the divisor
     * @param remainder the remainder after dividing
     * @return the GCD
     */
    private Integer gcdHelper(Integer divisor, Integer remainder) {
        if (remainder == 0) {
            return divisor;
        }
        else {
            return this.gcdHelper(remainder, (divisor % remainder));
        }
    }
}
