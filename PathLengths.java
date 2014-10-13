
import java.util.*;

import kvmap.KVMap;
import kvmap.RBTVisitor;

/**
 * Implementing the PathLength class
 * @author Hussein Abou Nassif Mourad hassuni9
 * @version June 3, 2014
 * 
 * @param <K> the key type
 * @param <V> the value type
 */
public class PathLengths<K, V> implements RBTVisitor<K, V, ArrayList<Integer>> {
    /**
     * Constructor for the PathLengths class
     */
    PathLengths() {
        /** Empty Constructor */
    }

    /**
     * Visiting empty
     * @param comp the comparator
     * @param color the color of the tree
     * @return the list of lengths in the array list
     */
    public ArrayList<Integer> visitEmpty(Comparator<? super K> comp,
            String color) {   
        ArrayList<Integer> emptyBranches = new ArrayList<Integer>();
        emptyBranches.add(0);
        return emptyBranches;
    }

    /** 
     * Increment the array list by 1 
     * @param alist the list to increment by 1
     * @return the incremented list
     */
    private ArrayList<Integer> incOne(ArrayList<Integer> alist) {
        for (int index = 0; index < alist.size(); index++) {
            alist.set(index, alist.get(index) + 1);
        }
        return alist;
    }

    /**
     * The visitNode method
     * @param comp the comparator
     * @param color the color of the tree
     * @param k the key
     * @param v the value
     * @param left the left tree
     * @param right the right tree
     * @return the list of lengths
     */
    public ArrayList<Integer> visitNode(Comparator<? super K> comp,
            String color, K k, V v, KVMap<K, V> left, KVMap<K, V> right) {
        /** Set up a temporary array list that will recur on the left first */
        ArrayList<Integer> leftRecur = left.acceptRBT(this);

        /** This will add all the right recursions to the previous array list */
        leftRecur.addAll(right.acceptRBT(this));

        /** Increment the above modified array list by 1, since we go 1 more 
         * depth per recursion */
        return incOne(leftRecur);    
    }
}
