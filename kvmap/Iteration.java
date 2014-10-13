package kvmap;
import java.util.*;

/** 
 * To represent my Iterator class
 * @author Hussein Abou Nassif Mourad
 * @version 05-16-2014
 * @param <K> the key
 */
public class Iteration<K> implements Iterator<K> {
    /** Store the ArrayList of keys */
    private ArrayList<K> listOfKeys;

    /** Storing the comparator */
    Comparator<K> comp;

    /**
     * Constructor of the Iteration class
     * @param lKeys to store the array list in this method
     */
    Iteration(ArrayList<K> lKeys) {
        this.listOfKeys = lKeys;
    }

    /**
     * Constructor of the Iteration class using Comparator
     * @param lKeys to store the array list in this method
     * @param c to store the comparator
     */
    Iteration(ArrayList<K> lKeys, Comparator<K> c) {
        this.listOfKeys = lKeys;
        this.comp = c;
        Collections.sort(this.listOfKeys, this.comp);
    }

    /**
     * Does the KVMap have a next item?
     * @return boolean representing whether or not there is another key
     */
    public boolean hasNext() {
        return this.listOfKeys.size() != 0;
    }

    /**
     * Return the next key in the array list
     * @return the current key and update Array List
     */
    public K next() {
        if (this.hasNext()) {
            /** Remove the first element */
            return this.listOfKeys.remove(0);

        }
        else {
            throw new NoSuchElementException("Can't iterate anymore, "
                    + "it's done");
        }
    }


    /**
     * Throw an exception every time this method is called
     */
    public void remove() {
        throw new UnsupportedOperationException("Remove was called");
    }

}
