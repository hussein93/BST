package kvmap;



import java.util.*;

/**
 * To represent the KVMap class
 * @author Hussein Abou Nassif Mourad
 * @version 05-16-2014
 * @param <K> the key
 * @param <V> the value
 */
public class EmptyBranch<K, V> extends BST<K, V> {
    /** Storing the comparator */
    private Comparator<K> comp;

    /** Color of this tree */
    private boolean treeBlack;

    /**
     * Constructor for the EmptyBranch class
     * @param com the comparator
     */
    EmptyBranch(Comparator<K> com) {
        this.comp = com;
        this.treeBlack = true;
    }

    /**
     * Return a new BST with the given key and value inserted (assigned)
     * @param ke the key being inserted to the BST
     * @param va the value being inserted to the BST
     * @return a new BST that has the key and value assigned in it
     */
    public BST<K, V> assign(K ke, V va) {
        return this.assignBalance(ke, va);
    }

    /**
     * Is this BST empty?
     * @return true since an EmptyBranch is empty
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * Return the size of this BST
     * @return number representing the size oft this BST
     */
    public int size() {
        return 0;
    }

    /**
     * Does this BST contain the given key?
     * @param k the key being searched for
     * @return boolean if this BST contains the key
     */
    public boolean containsKey(K k) {
        return false;
    }

    /**
     * Is the given value in this BST?
     * @param va the value being searched for
     * @return boolean whether or not the value is in this BST
     */
    public boolean containsValue(V va) {
        return false;
    }

    /**
     * Throw an exception since we can't get from an empty Branch
     * @param k the key to get back the value of it
     * @return exception since get is not available for EmptyBranch
     */
    public V get(K k) {
        throw new RuntimeException("Can't use get in an EmptyBranch");
    }

    /**
     * Return a unique hashCode for every Branch
     * @return unique number representing the hashCode
     */
    public int hashCode() {
        return 41;
    }

    /**
     * Generate an arrayList of unique keys of this BST
     * @param keysList is the unique list of keys
     * @return an arrayList of unique keys
     */
    protected ArrayList<K> createKeyList(ArrayList<K> keysList) {
        return keysList;
    }

    /**
     * Insert the key and value into the tree
     * @param k the key to be inserted
     * @param v the value to be inserted
     * @return a new BST with key and value inside it
     */
    protected BST<K, V> assignBalance(K k, V v) {
        return new Branch<K, V>(k, v, this, this, this.comp, false);
    }

    /**
     * Getter method for value
     * @return the value of this tree
     */
    protected V getValue() {
        throw new RuntimeException("Can't get value from empty.");
    }

    /**
     * Getter method for key
     * @return the key of this tree
     */
    protected K getKey() {
        throw new RuntimeException("Can't get key from empty.");
    }

    /**
     * Getter method for left BST
     * @return the left tree
     */
    protected BST<K, V> getLeftT() {
        throw new RuntimeException("EmptyBranch doesn't have any branches");
    }

    /**
     * Getter method for right BST
     * @return the right tree
     */
    protected BST<K, V> getRightT() {
        throw new RuntimeException("EmptyBranch doesn't have any branches");
    }

    /**
     * Is the tree colored black?
     * @return boolean representing whether or not the tree is black or not
     */
    protected boolean isColorBlack() {
        return this.treeBlack;
    }

    /**
     * Organize this BST by making it balanced according to the
     * picture in the class slides
     * @return the BST tree organized
     */
    protected BST<K, V> organized() {
        return this;
    }

    /**
     * Accept method for the BST
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
        if (this.treeBlack) {
            return vis.visitEmpty(this.comp, "BLACK");
        }
        else {
            return vis.visitEmpty(this.comp, "RED");
        }
    }

    /**
     * Make the tree black 
     * @return updated BST with black node
     */
    protected BST<K, V> changeBlack() {
        return this;
    }


}
