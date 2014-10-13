package kvmap;



import java.util.*;

/**
 * To represent the Assign class
 * @author Hussein Abou Nassif Mourad 
 * @version 05-16-2014
 * @param <K> is the key 
 * @param <V> is the value
 */
public class Assign<K, V> extends AList<K, V> {
    /** Stores the Key */
    private K key;

    /** Stores the Value */
    private V val;

    /** Store the KVMap to use recursion */
    private KVMap<K, V> kMap;

    /**
     * Constructor for Assign Class for recursion
     * @param k the key to store
     * @param v the value to store
     * @param m the map to store
     */
    Assign(K k, V v, KVMap<K, V> m) {
        this.key = k;
        this.val = v;
        this.kMap = m; 
    }

    /**
     * Returns instance of Assign
     * @param k to store the Key
     * @param v to store the Value
     * @return a new instance of Assign
     */
    public KVMap<K, V> assign(K k, V v) {
        return new Assign<K, V>(k, v, this);
    }

    /**
     * Is this map empty?
     * @return boolean representing if map is empty or not
     */
    public boolean isEmpty() {
        return false;
    }

    /** 
     * Return size of this map
     * @return int which is the size of this map
     */
    public int size() {
        if (this.kMap.containsKey(this.key)) {
            return this.kMap.size();
        }
        else {
            return (1 + this.kMap.size());
        }
    }

    /**
     * Checks if this map contains the given Key
     * @param k to check if the map has the given key
     * @return boolean if the map contains the key
     */
    public boolean containsKey(K k) {
        return k.equals(this.key) || this.kMap.containsKey(k);
    }

    /**
     * Checks if this map contains the given Value
     * @param v to check if the map has the given value
     * @return boolean if the map contains the value
     */
    public boolean containsValue(V v) {
        return (this.get(this.key).equals(v)) ||
                this.createKeyList(new ArrayList<K>()).contains(v);
    }

    /**
     * Checks the map for value of the given key
     * @param k to check for the value
     * @return value that has the given key
     */
    public V get(K k) {
        if (this.key.equals(k)) {
            return this.val;
        }
        else {
            return this.kMap.get(k);  
        }
    }

    /**
     * Compute the hashCode for this method
     * @return the unique hashCode for this class
     */
    public int hashCode() {
        ArrayList<K> keysList = this.createKeyList(new ArrayList<K>());
        int answer = 1;

        /** Navigate through the keys in the arrayList */
        for (int i = 0; i < keysList.size(); i++) {
            answer = this.get(keysList.get(i)).hashCode() + answer
                    + keysList.get(i).hashCode();
        }

        /** add the size to the answer */
        answer += this.size();

        /** Return the answer */
        return answer;
    }

    /**
     * Create a List of Keys
     * @param keysList is the arrayList of keys
     * @return an updated array list of keys
     */
    protected ArrayList<K> createKeyList(ArrayList<K> keysList) {
        if (keysList.contains(this.key)) {
            return this.kMap.createKeyList(keysList); 
        }
        else {
            /** Add this key into the array list */
            keysList.add(this.key);

            /** Return the updated list of keys */
            return this.kMap.createKeyList(keysList); 
        }
    }

    /**
     * Accept method for the KVMap
     * @param vis the visitor
     * @return the new KVMap after being modified
     */
    public KVMap<K, V> accept(KVMapVisitor<K, V> vis) {
        KVMap<K, V> answer = KVMap.emptyMap();
        for (K k : this) {
            V newValue = vis.visit(k, this.get(k));
            answer = answer.assign(k, newValue);
        }

        /** Return the answer */
        return answer;
    }

    /**
     * AcceptRBT method for the KVMap
     * @param vis the visitor
     * @param <R> the type R
     * @return the new KVMap after being modified
     */
    public <R> R acceptRBT(RBTVisitor<K, V, R> vis) {
        throw new UnsupportedOperationException("Can't from Assign class");
    }
}
