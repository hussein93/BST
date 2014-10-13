import java.util.Comparator;
import kvmap.KVMap;
import kvmap.RBTVisitor;

/**
 * Implementing the GCD class
 * @author Hussein Abou Nassif Mourad
 * @param <K> the key
 * @param <V> the value
 * @version Summer1 2014
 */
public class BlackHeight<K, V> implements RBTVisitor<K, V, Integer> {

    /**
     * Visiting in the empty
     * @param comp the comparator
     * @param color the color of the tree
     * @return 0 since empty has no size
     */
    public Integer visitEmpty(Comparator<? super K> comp, String color) {
        return 0;
    }

    /**
     * The visit method for Node
     * @param comp the comparator
     * @param color the color of the tree
     * @param k the key
     * @param v the value
     * @param left the left tree
     * @param right the right tree
     * @return the size of the tree
     */
    public Integer visitNode(Comparator<? super K> comp, String color, K k,
            V v, KVMap<K, V> left, KVMap<K, V> right) {
        if (color.equals("BLACK")) {
            /** 
             * Either left or right, since left and right should
             * be same height for black nodes
             **/
            return 1 + right.acceptRBT(this);
        }
        else {
            return right.acceptRBT(this);
        }       
    }
}
