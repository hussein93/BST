package kvmap;

/**
 * To represent the BST ADT class
 * @author Hussein Abou Nassif Mourad
 * @version 05-21-2014
 * @param <K> the key
 * @param <V> the value
 */
public abstract class BST<K, V> extends KVMap<K, V> {

    /**
     * Insert the key and value into the tree
     * @param k the key to be inserted
     * @param v the value to be inserted
     * @return a new BST with key and value inside it
     */
    protected abstract BST<K, V> assignBalance(K k, V v);

    /**
     * Organize this BST by making it balanced according to the
     * picture in the class slides
     * @return the BST tree organized
     */
    protected abstract BST<K, V> organized();

    /**
     * Getter method for value
     * @return the value of this tree
     */
    protected abstract V getValue();

    /**
     * Getter method for key
     * @return the key of this tree
     */
    protected abstract K getKey();

    /**
     * Getter method for left BST
     * @return the left tree
     */
    protected abstract BST<K, V> getLeftT();

    /**
     * Getter method for right BST
     * @return the right tree
     */
    protected abstract BST<K, V> getRightT();

    /**
     * Is the tree colored black?
     * @return boolean representing whether or not the tree is black or not
     */
    protected abstract boolean isColorBlack();

    /**
     * Make the tree black 
     * @return updated BST with black node
     */
    protected abstract BST<K, V> changeBlack();
}
