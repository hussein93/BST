package kvmap;
import java.util.*;

/**
 * To represent the KVMap class
 * @author Hussein Abou Nassif Mourad
 * @version 05-16-2014
 * @param <K> the key
 * @param <V> the value
 */
public class Branch<K, V> extends BST<K, V> {
    /** Representing the left branch */
    private BST<K, V> leftB;

    /** Representing the right branch */
    private BST<K, V> rightB;

    /** Representing the key of this branch */
    private K key;

    /** Representing the value of this branch */
    private V val;

    /** Storing the comparator */
    private Comparator<K> comp;

    /** Storing the size of this BST */
    private int size;

    /** Storing the color of the tree (red or black) */
    private boolean treeBlack;

    /**
     * Constructor for Branch class
     * @param lB the left branch of BST
     * @param rB the right branch of BST
     * @param k the key of this branch
     * @param v the value of this branch
     * @param com the comparator
     * @param tc the tree color of this branch
     */
    Branch(K k, V v, BST<K, V> lB, BST<K, V> rB, Comparator<K> com,
            boolean tc) {
        this.key = k;
        this.val = v;
        this.leftB = lB;
        this.rightB = rB;
        this.comp = com;
        this.treeBlack = tc;

        /** Initializing the size once for efficiency */
        this.size = 1 + this.leftB.size() + this.rightB.size();
    }

    /**
     * Return a new BST with the given key and value inserted (assigned)
     * @param ke the key being inserted to the BST
     * @param va the value being inserted to the BST
     * @return a new BST that has the key and value assigned in it
     */
    public KVMap<K, V> assign(K ke, V va) {
        return this.assignBalance(ke, va).changeBlack();
    }

    /**
     * Insert the key and value according to balance
     * @param ke the key
     * @param va the value
     * @return the new updated branch
     */
    protected Branch<K, V> assignBalance(K ke, V va) {
        if (this.comp.compare(this.key, ke) > 0) {
            return new Branch<K, V>(this.key, 
                    this.val, 
                    this.leftB.assignBalance(ke, va), 
                    this.rightB,
                    this.comp,
                    this.treeBlack).organized();
        }
        else if (this.comp.compare(this.key, ke) == 0) {
            return new Branch<K, V>(ke,
                    va,
                    this.leftB,
                    this.rightB,
                    this.comp,
                    this.treeBlack);
        }
        else {
            return new Branch<K, V>(this.key,
                    this.val,
                    this.leftB,
                    this.rightB.assignBalance(ke, va), 
                    this.comp,
                    this.treeBlack).organized();
        }
    }

    /**
     * Is this BST empty?
     * @return false since a Branch is not empty
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Return the size of this BST
     * @return number representing the size oft this BST
     */
    public int size() {
        return this.size;
    }

    /**
     * Does this BST contain the given key?
     * @param k the key to search for
     * @return boolean if this BST contains the key
     */
    public boolean containsKey(K k) {
        if (this.comp.compare(this.key, k) == 0) {
            return true;
        }
        else if (this.comp.compare(this.key, k) > 0) {
            return this.leftB.containsKey(k);
        }
        else {
            return this.rightB.containsKey(k);
        }
    }

    /**
     * Is the given value in this BST?
     * @param va the value being searched for
     * @return boolean whether or not the value is in this BST
     */
    public boolean containsValue(V va) {
        return  this.leftB.containsValue(va) || this.val.equals(va) || 
                this.rightB.containsValue(va);
        //        if (this.leftB.containsValue(va)) {
        //            return true;
        //        }
        //        else if (this.rightB.containsValue(va)) {
        //            return true;
        //        }
        //        else {
        //            return this.get(this.key).equals(va);
        //        }
    }

    /**
     * Return the value of the given key
     * @param k being the value being searched for
     * @return the value corresponding to the given key
     */
    public V get(K k) {
        if (this.comp.compare(this.key, k) == 0) {
            return this.val;
        }
        else if (this.comp.compare(this.key, k) > 0) {
            return this.leftB.get(k);
        }
        else {
            return this.rightB.get(k);
        }
    }

    /**
     * Return a unique hashCode for every Branch
     * @return unique number representing the hashCode
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
     * Generate an arrayList of unique keys of this BST
     * @param keysList is the unique list of keys
     * @return an arrayList of unique keys
     */
    protected ArrayList<K> createKeyList(ArrayList<K> keysList) {
        /** Adding the leftKeys, this key, and rightKeys in order */
        keysList.add(this.key);

        /** Adding the keys from the left and right KVMap */
        ArrayList<K> leftKeys = this.leftB.createKeyList(new ArrayList<K>());
        ArrayList<K> rightKeys = this.rightB.createKeyList(new ArrayList<K>());
        keysList.addAll(leftKeys);
        keysList.addAll(rightKeys);

        /** Sorting the list of keys according to this comparator */
        Collections.sort(keysList, this.comp);

        /** Return the ArrayList of non duplicates */
        return keysList;
    }

    /**
     * Getter method for value
     * @return the value of this tree
     */
    protected V getValue() {
        return this.val;
    }

    /**
     * Getter method for key
     * @return the key of this tree
     */
    protected K getKey() {
        return this.key;
    }

    /**
     * Getter method for left BST
     * @return the left tree
     */
    protected BST<K, V> getLeftT() {
        return this.leftB;
    }

    /**
     * Getter method for right BST
     * @return the right tree
     */
    protected BST<K, V> getRightT() {
        return this.rightB;
    }

    /**
     * Is the tree colored black?
     * @return boolean representing whether or not the tree is black or not
     */
    protected boolean isColorBlack() {
        return this.treeBlack;
    }

    /**
     * Representing the first graph case
     * @param temp the temporary BST
     * @return the updated Branch
     */
    private Branch<K, V> firstGraph(BST<K, V> temp) {
        return new Branch<K, V>(temp.getKey(),
                temp.getValue(), 
                temp.getLeftT().changeBlack(), 
                new Branch<K, V>(this.key, 
                        this.val, temp.getRightT(), this.getRightT(), this.comp,
                        true), this.comp, false);
    }

    /**
     * Representing the second graph
     * @param other the other BST
     * @param temp the temporary BST
     * @return the updated Branch
     */
    private Branch<K, V> secondGraph(BST<K, V> other, BST<K, V> temp) {
        return new Branch<K, V>(other.getKey(),
                other.getValue(),
                new Branch<K, V>(temp.getKey(),
                        temp.getValue(),
                        temp.getLeftT(),
                        other.getLeftT(),
                        this.comp, 
                        true),
                        new Branch<K, V>(this.key, this.val, other.getRightT(),
                                this.getRightT(), this.comp, true),
                                this.comp, 
                                false);
    }

    /**
     * Representing the third graph case
     * @param temp the temporary BST
     * @return the updated Branch
     */
    private Branch<K, V> thirdGraph(BST<K, V> temp) {
        return new Branch<K, V>(temp.getKey(),
                temp.getValue(),
                new Branch<K, V>(this.key, this.val, this.getLeftT(), 
                        temp.getLeftT(), this.comp, true),
                        temp.getRightT().changeBlack(),
                        this.comp, 
                        false);
    }

    /**
     * Representing the last case of the RBT cases
     * @param other the other graph
     * @param temp the temporary graph
     * @return the updated BST
     */
    private Branch<K, V> fourthGraph(BST<K, V> other, BST<K, V> temp) {
        return new Branch<K, V>(other.getKey(),
                other.getValue(),
                new Branch<K, V>(this.key, this.val, this.getLeftT(),
                        other.getLeftT(), this.comp, true),
                        new Branch<K, V>(temp.getKey(), temp.getValue(),
                                other.getRightT(), temp.getRightT(),
                                this.comp, true),
                                this.comp,
                                false);
    }

    /**
     * Organize this BST by making it balanced according to the
     * picture in the class slides
     * @return the BST tree organized
     */
    protected Branch<K, V> organized() {
        if (this.isColorBlack()) {
            /** Check for the first two graph cases */
            if (!this.getLeftT().isEmpty()
                    && !this.getLeftT().isColorBlack()) {
                BST<K, V> temp = this.getLeftT();
                /** First test graph according to the class graphs */
                if (!temp.getLeftT().isEmpty()
                        && !temp.getLeftT().isColorBlack()) {
                    /** Return the first case graph BST */
                    return this.firstGraph(temp);
                }
                /** Second test graph according to the class graphs */
                else if (!temp.getRightT().isEmpty()
                        && !temp.getRightT().isColorBlack()) {
                    BST<K, V> other = temp.getRightT();
                    /** Return the second case graph BST */
                    return secondGraph(other, temp);
                }
            }
            /** Check for the other two graph cases */
            else if (!this.getRightT().isEmpty()
                    && !this.getRightT().isColorBlack()) {
                BST<K, V> temp = this.getRightT();
                /** Third test graph according to the class graphs */
                if (!temp.getRightT().isEmpty()
                        && !temp.getRightT().isColorBlack()) {
                    /** Return the third case graph BST */
                    return this.thirdGraph(temp);
                }
                /** Fourth test graph according to the class graphs */
                else if (!temp.getLeftT().isEmpty()
                        && !temp.getLeftT().isColorBlack()) {
                    BST<K, V> other = temp.getLeftT();
                    /** Return the fourth and last case graph BST */
                    return this.fourthGraph(other, temp);
                }
            }
        }
        /** Return this Branch if above cases fail */
        return this;
    }

    /**
     * Accept method for the BST
     * @param vis the visitor
     * @return the new KVMap after being modified
     */
    public KVMap<K, V> accept(KVMapVisitor<K, V> vis) {
        // For some reason m.accept(v).containsKey(k) doesn't pass, although
        // containsKey and accept
        //        BST<K, V> newL = (BST<K, V>) this.leftB.accept(vis);
        //        BST<K, V> newR = (BST<K, V>) this.rightB.accept(vis);
        /** Return a new modified KVMap */
        return new Branch<K, V>(this.key, vis.visit(this.key, this.val), 
                (BST<K, V>) this.leftB.accept(vis), 
                (BST<K, V>) this.rightB.accept(vis), this.comp, this.treeBlack);
    }

    /**
     * AcceptRBT method for the KVMap
     * @param vis the visitor
     * @param <R> the type R
     * @return the new KVMap after being modified
     */
    public <R> R acceptRBT(RBTVisitor<K, V, R> vis) {
        /** Casting for the visitNode method */
        KVMap<K, V> newLeft = (KVMap<K, V>) this.leftB;
        KVMap<K, V> newRight = (KVMap<K, V>) this.rightB;

        if (this.treeBlack) {
            return vis.visitNode(this.comp, "BLACK", this.key, this.val, 
                    newLeft, newRight);
        }
        else {
            return vis.visitNode(this.comp, "RED", this.key, this.val, 
                    newLeft, newRight);
        }
    }

    /**
     * Make the tree black 
     * @return updated BST with black node
     */
    protected BST<K, V> changeBlack() {
        return new Branch<K, V>(this.key, this.val, this.leftB, this.rightB, 
                this.comp, true);
    }
}