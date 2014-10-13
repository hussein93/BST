

import kvmap.KVMapVisitor;

/**
 * To represent the BST ADT class
 * @author Hussein Abou Nassif Mourad
 * @version June 4, 2014
 */
public class StringWithNumber implements KVMapVisitor<Integer, String> {

    /**
     * Overriding visit method
     * @param k the Integer
     * @param v the string
     * @return the resulting string
     */
    public String visit(Integer k, String v) {
        String s = v + " " + Integer.toString(k);

        /** Return above string */
        return s;
    }

}
