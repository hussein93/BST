package kvmap;
import java.util.*;

/**
 * To represent the KVMap class
 * @author Hussein Abou Nassif Mourad
 * @version 05-16-2014
 * @param <K> the key
 * @param <V> the value
 */
public abstract class KVMap<K, V> implements Iterable<K> {

    /** Static Methods */

    /**
     * Return new instance of EmptyMap
     * @param <K> the key
     * @param <V> the value
     * @return instance of EmptyMap
     */
    public static <K, V> KVMap<K, V> emptyMap() {
        return new EmptyMap<K, V>();  
    }

    /**
     * Return new instance of EmptyMap
     * @param comp which is the comparator
     * @param <K> the key
     * @param <V> the value
     * @return instance of EmptyMap
     */
    public static <K, V> KVMap<K, V> emptyMap(Comparator<K> comp) {
        return new EmptyBranch<K, V>(comp);
    }

    /** Abstract Methods */

    /**
     * Returns instance of Assign
     * @param key to store the Key
     * @param val to store the Value
     * @return a new instance of Assign
     */
    public abstract KVMap<K, V> assign(K key, V val);

    /**
     * Is this map empty?
     * @return boolean representing if map is empty or not
     */
    public abstract boolean isEmpty();

    /** 
     * Return size of this map
     * @return int which is the size of this map
     */
    public abstract int size();

    /**
     * Checks if this map contains the given Key
     * @param k to check if the map has the given key
     * @return boolean if the map contains the key
     */
    public abstract boolean containsKey(K k);

    /**
     * Checks if this map contains the given Value
     * @param val to check if the map has the given value
     * @return boolean if the map contains the value
     */
    public abstract boolean containsValue(V val);

    /**
     * Checks the map for value of the given key
     * @param k to check for the value
     * @return value that has the given key
     */
    public abstract V get(K k);

    /**
     * Returns information of this map in the form of a string
     * @return string of information of this map
     */
    public String toString() {
        return "{...[There are " + this.size() +
                " unique key(s) mapped to " +
                "value(s) in this KVMap]...}";
    }

    /**
     * Returns if this object is the same as given object
     * @param o is the object being compared
     * @return if the two objects are the same
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o instanceof KVMap) {
            KVMap<K, V> temp = (KVMap<K, V>) o;

            /** Check the sizes */
            if (this.size() != temp.size()) {
                return false;
            }

            for (K cKey: this) {
                if (!(temp.containsKey(cKey)) ||
                        !(this.get(cKey).equals(temp.get(cKey)))) {
                    return false;
                }
            }

            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Compute a unique hashCode for this map
     * @return int of the unique hashCode
     */
    public abstract int hashCode();

    /**
     * Overrides the Iterator method
     * @return the Iterator after using it
     */
    public Iterator<K> iterator() {
        /** Create a list of keys */
        ArrayList<K> listOfKeys = this.createKeyList(new ArrayList<K>());

        return new Iteration<K>(listOfKeys);
    }

    /**
     * Overrides the Iterator method
     * @param comp the comparator to use when iterating
     * @return the Iterator after using it
     */
    public Iterator<K> iterator(Comparator<K> comp) {
        /** Create a list of keys */
        ArrayList<K> listOfKeys = this.createKeyList(new ArrayList<K>());

        return new Iteration<K>(listOfKeys, comp);
    }

    /**
     * Create a unique list of keys
     * @param keysList the unique list of keys
     * @return a unique list of keys
     */
    protected abstract ArrayList<K> createKeyList(ArrayList<K> keysList);
    
    /**
     * Accept method for the KVMap
     * @param vis the visitor
     * @return the new KVMap after being modified
     */
    public abstract KVMap<K, V> accept(KVMapVisitor<K, V> vis);
    
    /**
     * AcceptRBT method for the KVMap
     * @param vis the visitor
     * @param <R> the type R
     * @return R of type R
     */
    public abstract <R> R acceptRBT(RBTVisitor<K, V, R> vis);

}
