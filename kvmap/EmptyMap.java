package kvmap;

import java.util.*;

/**
 * To represent the EmptyMap class
 * @author Hussein Abou Nassif Mourad
 * @version 05-16-2014
 * @param <K> the key
 * @param <V> the value
 */
public class EmptyMap<K, V> extends AList<K, V> {
    /** Store the comparator */
    Comparator<K> comp;

    /**
     * Empty constructor method for this class
     */
    EmptyMap() {
        /** Empty constructor for KVMap */
    }

    /**
     * Returns instance of Assign
     * @param key to store the Key
     * @param val to store the Value
     * @return a new instance of Assign
     */
    public KVMap<K, V> assign(K key, V val) {
        return new Assign<K, V>(key, val, this);
    }

    /**
     * Is this map empty?
     * @return boolean representing if map is empty or not
     */
    public boolean isEmpty() {
        return true;
    }

    /** 
     * Return size of this map
     * @return int which is the size of this map
     */
    public int size() {
        return 0;
    }

    /**
     * Checks if this map contains the given Key
     * @param key to check if the map has the given key
     * @return boolean if the map contains the key
     */
    public boolean containsKey(K key) {
        return false;
    }

    /**
     * Checks if this map contains the given Value
     * @param val to check if the map has the given value
     * @return boolean if the map contains the value
     */
    public boolean containsValue(V val) {
        return false;
    }

    /**
     * Checks the map for value of the given key
     * @param key to check for the value
     * @return value that has the given key
     */
    public V get(K key) {
        throw new RuntimeException("Can't use get from an emptyMap");
    }

    /**
     * Compute a unique hashCode for this map
     * @return int of the unique hashCode
     */
    public int hashCode() {
        return 41;
    }

    /**
     * Create a unique list of keys
     * @param keysList the unique list of keys
     * @return a unique list of keys
     */
    protected ArrayList<K> createKeyList(ArrayList<K> keysList) {
        return keysList;
    }

    /**
     * Accept method for the KVMap
     * @param vis the visitor
     * @return the new KVMap after being modified
     */
    public KVMap<K, V> accept(KVMapVisitor<K, V> vis) {
        return this;
    }

    /**
     * AcceptRBT method for the KVMap
     * @param vis the visitor
     * @param <R> the type R
     * @return the new KVMap after being modified
     */
    public <R> R acceptRBT(RBTVisitor<K, V, R> vis) {
        throw new UnsupportedOperationException("Can't from Empty class");
    }
}
