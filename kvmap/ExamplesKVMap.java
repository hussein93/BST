package kvmap;

import java.util.*;

import tester.*;

/**
 * To represent the examples class
 * @author Hussein Abou Nassif Mourad
 * @version 05-17-2014
 */
public class ExamplesKVMap {
    
    /** Creating instances of Comparators. String and Integer */
    private Comparator<Integer> cInt;
    private Comparator<String> cStr;
    private Comparator<String> lexiComp = new LexiString();

    /** ArrayList example */
    private ArrayList<String> alist = new ArrayList<String>();

    /** Iterators */
    private Iterator<Integer> i1 = new Iteration<Integer>(
            new ArrayList<Integer>(),
            cInt);
    private Iterator<String> i2 = new Iteration<String>(
            new ArrayList<String>(), cStr);

    /** Exceptions */
    private Exception exc = new NoSuchElementException("Can't iterate"
            + " anymore, it's done");

    /** Another exception */
    private Exception exc2 = new UnsupportedOperationException("Remove was "
            + "called");

    /** Examples of BST */
    private BST<String, Integer> emptyB =
            new EmptyBranch<String, Integer>(lexiComp);
    private BST<String, Integer> bst1 =
            (BST<String, Integer>) emptyB.assign("g", 5);
    private BST<String, Integer> bst2 =
            (BST<String, Integer>) bst1.assign("b", 1);
    private BST<String, Integer> bst3 =
            (BST<String, Integer>) bst2.assign("c", 11);
    private BST<String, Integer> bst4 =
            (BST<String, Integer>) bst3.assign("a", 35);
    private BST<String, Integer> bst5 =
            (BST<String, Integer>) bst4.assign("d", 102);
    private BST<String, Integer> bst6 =
            (BST<String, Integer>) bst5.assign("p", 2);
    private BST<String, Integer> bst7 =
            (BST<String, Integer>) bst6.assign("q", 41);
    private BST<String, Integer> bst8 =
            (BST<String, Integer>) bst7.assign("u", 22);
    private BST<String, Integer> bst9 =
            (BST<String, Integer>) bst8.assign("x", 1);
    private BST<String, Integer> bst10 =
            (BST<String, Integer>) bst9.assign("z", 7);
    private BST<String, Integer> bst11 =
            (BST<String, Integer>) bst10.assign("b", 31);
    private BST<String, Integer> bst12 =
            (BST<String, Integer>) bst11.assign("e", 3);

    private BST<String, Integer> bst13 = 
            new EmptyBranch<String, Integer>(lexiComp);
    private BST<String, Integer> bst14 = 
            new Branch<String, Integer>("b", 1, bst13, bst13, lexiComp, false);
    private BST<String, Integer> bst15 =
            new Branch<String, Integer>("c", 2, bst14, bst13, lexiComp, false);
    private BST<String, Integer> bst16 =
            new Branch<String, Integer>("a", 2, bst13, bst15, lexiComp, true);
    
    private BST<String, Integer> bst17 = 
            new EmptyBranch<String, Integer>(lexiComp);
    private BST<String, Integer> bst18 = 
            new Branch<String, Integer>("x", 1, bst17, bst17, lexiComp, false);
    private BST<String, Integer> bst19 =
            new Branch<String, Integer>("y", 2, bst18, bst13, lexiComp, false);
    private BST<String, Integer> bst20 =
            new Branch<String, Integer>("a", 2, bst19, bst17, lexiComp, true);
    
    private KVMap<String, Integer> bst21 = KVMap.emptyMap(lexiComp);
    private KVMap<String, Integer> bst22 = bst21.assign("x", 1);
    private KVMap<String, Integer> bst23 = bst22.assign("a", 2);
    private KVMap<String, Integer> bst24 = bst23.assign("y", 2);

    /** Examples of KVMaps */
    private KVMap<String, Integer> empty = new EmptyMap<String, Integer>();
    private KVMap<String, Integer> empty2 = new EmptyMap<String, Integer>();
    private KVMap<String, Integer> kvmap1 = new EmptyMap<String, Integer>();
    private KVMap<String, Integer> kvmap2 = new EmptyMap<String, Integer>();
    private KVMap<String, Integer> kvmap3 = new EmptyMap<String, Integer>();
    private KVMap<String, Integer> kvmap4 = new EmptyMap<String, Integer>();
    private KVMap<String, Integer> kvmap5 = new EmptyMap<String, Integer>();
    private KVMap<String, Integer> kvmap6 = new EmptyMap<String, Integer>();
    private KVMap<String, Integer> kvmap7 = new EmptyMap<String, Integer>();
    private KVMap<String, Integer> kvmap8 = new EmptyMap<String, Integer>();

    /** EmptyMaps */
    private KVMap<String, Integer> e1 = KVMap.emptyMap();

    /** Another EmptyMap */
    private KVMap<String, Integer> e2 = KVMap.emptyMap(cStr);

    /** Examples of Binary Search Trees */
    private KVMap<String, Integer> treeEmpty = KVMap.emptyMap(lexiComp);
    private KVMap<String, Integer> tree1 = treeEmpty.assign("f", 88);
    private KVMap<String, Integer> tree2 = tree1.assign("c", 35);
    private KVMap<String, Integer> tree3 = tree2.assign("i", 32);
    private KVMap<String, Integer> tree4 = tree3.assign("a", 2);
    private KVMap<String, Integer> tree5 = tree4.assign("z", 99);
    private KVMap<String, Integer> tree6 = tree5.assign("d", 12);
    private KVMap<String, Integer> tree7 = tree6.assign("g", 15);

    private KVMap<String, Integer> tree8 = tree1.assign("f", 15);

    private KVMap<String, Integer> treeEmpty2 = KVMap.emptyMap(lexiComp);
    private KVMap<String, Integer> tree11 = treeEmpty2.assign("f", 88);
    private KVMap<String, Integer> tree22 = tree11.assign("c", 35);

    private KVMap<String, Integer> tree33 = tree22.assign("i", 15);
    private KVMap<String, Integer> tree44 = tree33.assign("a", 1);
    
    /**
     * Will assign certain values
     */
    void initKVMap() {
        kvmap1 = empty.assign("a", 1);
        kvmap2 = kvmap1.assign("b", 2);
        kvmap3 = kvmap2.assign("b", 3);
        kvmap3 = kvmap3.assign("c", 2);

        kvmap4 = empty.assign("a", 1);
        kvmap4 = kvmap4.assign("a", 5);
        kvmap4 = kvmap4.assign("a", 35);

        kvmap5 = empty.assign("a", 1);
        kvmap5 = kvmap5.assign("b", 2);
        kvmap5 = kvmap5.assign("b", 3);
        kvmap5 = kvmap5.assign("c", 2);

        kvmap6 = empty.assign("a", 1);
        kvmap6 = kvmap6.assign("b", 5);
        kvmap6 = kvmap6.assign("a", 1);

        kvmap7 = empty.assign("a", 1);
        kvmap7 = kvmap7.assign("b", 5);

        kvmap8 = empty.assign("z", 81);
        kvmap8 = empty.assign("x", 8173);

        alist.add("a");
        alist.add("b");
        alist.add("c");
        i2 = new Iteration<String>(alist, cStr);

        kvmap4.iterator(cStr);
    }

    /**
     * Testing the isEmpty() method
     * @param t the tester
     * @return boolean if all tests pass
     */
    boolean testIsEmpty(Tester t) {
        initKVMap();
        return t.checkExpect(empty.isEmpty(), true) &&
                t.checkExpect(kvmap1.isEmpty(), false) &&
                t.checkExpect(treeEmpty.isEmpty(), true) &&
                t.checkExpect(tree2.isEmpty(), false) &&
                t.checkExpect(kvmap2.isEmpty(), false);
    }

    /**
     * Testing the size() method
     * @param t the tester
     * @return boolean if all tests pass
     */
    boolean testSizeAndGet(Tester t) {
        initKVMap();
        return t.checkExpect(empty.size(), 0) &&
                t.checkExpect(kvmap1.size(), 1) &&
                t.checkExpect(kvmap2.size(), 2) &&
                t.checkExpect(treeEmpty.size(), 0) &&
                t.checkExpect(tree3.size(), 3) &&
                t.checkExpect(tree5.size(), 5) &&
                t.checkExpect(kvmap3.size(), 3) &&
                t.checkExpect(tree1.get("f"), new Integer(88)) &&
                t.checkExpect(tree2.get("c"), new Integer(35)) &&
                t.checkExpect(tree3.get("i"), new Integer(32));
    }

    /**
     * Testing the containsKey() method
     * @param t the tester
     * @return boolean if all tests pass
     */
    boolean testContainsKey(Tester t) {
        initKVMap();
        return t.checkExpect(empty.containsKey("a"), false) &&
                t.checkExpect(kvmap1.containsKey("a"), true) &&
                t.checkExpect(kvmap1.containsKey("b"), false) &&
                t.checkExpect(treeEmpty.containsKey("b"), false) &&
                t.checkExpect(tree3.containsKey("j"), false) &&
                t.checkExpect(tree3.containsKey("i"), true) &&
                t.checkExpect(tree3.containsKey("c"), true) &&
                t.checkExpect(tree4.containsKey("a"), true) &&
                t.checkExpect(tree5.containsKey("z"), true) &&
                t.checkExpect(tree6.containsKey("d"), true) &&
                t.checkExpect(tree7.containsKey("j"), false) &&
                t.checkExpect(tree7.containsKey("z"), true) &&
                t.checkExpect(tree7.containsKey("g"), true) &&
                t.checkExpect(tree7.containsKey("d"), true) &&
                t.checkExpect(tree7.containsKey("h"), false) &&
                t.checkExpect(kvmap2.containsKey("a"), true) &&
                t.checkExpect(kvmap2.containsKey("a"), true) &&
                t.checkExpect(kvmap2.containsKey("c"), false);
    }

    /**
     * Testing the toString() method
     * @param t the tester
     * @return boolean if all tests pass
     */
    boolean testToString(Tester t) {
        initKVMap();
        String a1 = "{...[There are 0 unique key(s) mapped to value(s) in "
                + "this KVMap]...}";
        String a2 = "{...[There are 1 unique key(s) mapped to value(s) in "
                + "this KVMap]...}";
        return t.checkExpect(empty.toString(), a1) &&
                t.checkExpect(kvmap1.toString(), a2);
    }

    /**
     * Testing the containsValue() method
     * @param t the tester
     * @return boolean if all tests pass
     */
    boolean testContainsValue(Tester t) {
        initKVMap();
        return t.checkExpect(empty.containsValue(1), false) &&
                t.checkExpect(kvmap1.containsValue(1), true) &&
                t.checkExpect(treeEmpty.containsValue(30), false) &&
                t.checkExpect(tree3.containsValue(35), true) &&
                t.checkExpect(tree3.containsValue(32), true) &&
                t.checkExpect(tree4.containsValue(2), true) &&
                t.checkExpect(tree5.containsValue(99), true) &&
                t.checkExpect(tree6.containsValue(12), true) && 
                t.checkExpect(tree7.containsValue(12), true) && 
                t.checkExpect(tree7.containsValue(15), true) &&
                t.checkExpect(tree7.containsValue(1), false) &&
                t.checkExpect(kvmap1.containsValue(2), false) &&
                t.checkExpect(kvmap2.containsValue(1), false) &&
                t.checkExpect(kvmap2.containsValue(2), true) &&
                t.checkExpect(kvmap2.containsValue(3), false) &&
                t.checkExpect(kvmap4.containsValue(1), false) &&
                t.checkExpect(kvmap4.containsValue(5), false) &&
                t.checkExpect(kvmap4.containsValue(35), true);
    }

    /**
     * Testing the equals() method
     * @param t the tester
     * @return boolean if all tests pass
     */
    boolean testEquals(Tester t) {
        initKVMap();
        String s = "A";
        Integer i = new Integer(8);
        return t.checkExpect(empty.equals(empty2), true) &&
                t.checkExpect(empty.equals(kvmap1), false) &&
                t.checkExpect(e1.equals(e2), true) &&
                t.checkExpect(kvmap1.equals(kvmap1), true) &&
                t.checkExpect(kvmap3.equals(kvmap4), false) &&
                t.checkExpect(kvmap6.equals(kvmap7), true) &&
                
                
                
                
                t.checkExpect(kvmap3.equals(kvmap5), true) &&
                t.checkExpect(kvmap6.equals(8), false) &&
                t.checkExpect(kvmap1.equals(kvmap8), false) &&
                t.checkExpect(empty.equals(8), false) &&
                t.checkExpect(i1.equals(i2), false) &&
                t.checkExpect(kvmap3.equals(s), false) &&
                t.checkExpect(kvmap3.equals(i), false) &&
                t.checkExpect(kvmap3.equals(null), false) &&
                t.checkExpect(treeEmpty.equals(treeEmpty2), true) &&
                t.checkExpect(tree1.equals(tree11), true) &&
                t.checkExpect(tree2.equals(tree22), true) &&
                t.checkExpect(bst16.organized().equals(bst15), false) &&
                t.checkExpect(bst20.organized().equals(bst15), false) &&
                t.checkExpect(tree3.equals(tree33), false) &&
                t.checkExpect(bst24.equals(bst20), false) &&
                t.checkExpect(tree3.equals(tree33), false) &&
                t.checkExpect(bst16.organized().equals(bst2.organized()),
                        false) &&
                        t.checkExpect(bst4.organized().equals(bst5.organized()),
                                false) &&
                                t.checkExpect(tree4.equals(tree44), false);
    }

    /**
     * Testing hashCode
     * @param t the tester
     * @return if all tests pass
     */
    boolean testHashCode(Tester t) {
        initKVMap();
        return t.checkExpect(empty.hashCode() == empty2.hashCode(), true) &&
                t.checkExpect(empty.hashCode(), 41) &&
                t.checkExpect(empty.hashCode() == kvmap1.hashCode(), false) &&
                t.checkExpect(kvmap1.hashCode() == kvmap1.hashCode(), true) &&
                t.checkExpect(kvmap3.hashCode() == kvmap4.hashCode(), false) &&
                t.checkExpect(kvmap6.hashCode() == kvmap7.hashCode(), true) &&
                t.checkExpect(kvmap3.hashCode() == kvmap5.hashCode(), true) &&
                t.checkExpect(kvmap3.hashCode() == "s".hashCode(), false) &&
                t.checkExpect(treeEmpty.hashCode() == treeEmpty2.hashCode(), 
                true) &&
                t.checkExpect(tree1.hashCode() == tree11.hashCode(), true) &&
                t.checkExpect(tree2.hashCode() == tree22.hashCode(), true) &&
                t.checkExpect(tree4.hashCode() == tree44.hashCode(), false);
    }

    /**
     * Testing assign method
     * @param t the tester
     * @return if all tests pass
     */
    boolean testAssign(Tester t) {
        initKVMap();
        return t.checkExpect(treeEmpty.assign("f", 88), tree1) &&
                t.checkExpect(tree1.assign("c", 35), tree2) &&
                t.checkExpect(tree2.assign("i", 32), tree3) &&
                t.checkExpect(emptyB.organized(), emptyB) &&
                t.checkExpect(tree1.assign("f", 15), tree8);
    }

    /**
     * Testing assign method
     * @param t the tester
     * @return if all tests pass
     */
    boolean testColorBlack(Tester t) {
        initKVMap();
        return t.checkExpect(bst1.isColorBlack(), false) &&
                t.checkExpect(bst12.isColorBlack(), true) &&
                t.checkExpect(emptyB.isColorBlack(), true) &&
                t.checkExpect(bst5.isColorBlack(), true) &&
                t.checkExpect(emptyB.changeBlack(), emptyB) &&
                t.checkExpect(bst5.getLeftT().isColorBlack(), true) &&
                t.checkExpect(bst5.getRightT().isColorBlack(), true);
    }


    /**
     * Testing Iteration
     * @param t the tester
     * @return if all tests pass
     */
    boolean testIteration(Tester t) {
        initKVMap();
        return t.checkExpect(i1.hasNext(), false) &&
                t.checkExpect(i2.next(), "a") &&
                t.checkExpect(i2.hasNext(), true) &&
                t.checkException(exc, i1, "next") &&
                t.checkException(exc2, i1, "remove");
    }

    /**
     * Testing the empty get method
     * @param t the tester
     */
    void testGet(Tester t) {
        try {
            t.checkExpect(empty2.get("a"), new Integer(1));
            t.checkExpect(empty.get("a"), new Integer(1));
        }
        catch (Exception e) {
            System.out.println("Can't get from an emptyMap");
        }
    }

    /**
     * Testing the empty get method
     * @param t the tester
     */
    void testGetBST(Tester t) {
        try {
            t.checkExpect(treeEmpty.get("a"), new Integer(1));
        }
        catch (Exception e) {
            System.out.println("Can't get from an emptyMap");
        }
    }

    /**
     * Testing the empty get method
     * @param t the tester
     */
    void testGetKey(Tester t) {
        try {
            t.checkExpect(emptyB.getKey(), "a");
        }
        catch (Exception e) {
            System.out.println("Can't get key from empty.");
        }
    }

    /**
     * Testing the empty get method
     * @param t the tester
     */
    void testGetLeftT(Tester t) {
        try {
            t.checkExpect(emptyB.getLeftT(), emptyB);
            t.checkExpect(emptyB.getRightT(), emptyB);
        }
        catch (Exception e) {
            System.out.println("EmptyBranch doesn't have any branches");
        }
    }

    /**
     * Testing the empty get method
     * @param t the tester
     */
    void testGetRightT(Tester t) {
        try {
            t.checkExpect(emptyB.getRightT(), emptyB);
        }
        catch (Exception e) {
            System.out.println("EmptyBranch doesn't have any branches");
        }
    }

    /**
     * Testing the empty get method
     * @param t the tester
     */
    void testGetValue(Tester t) {
        try {
            t.checkExpect(emptyB.getValue(), new Integer(1));
        }
        catch (Exception e) {
            System.out.println("Can't get value from empty.");
        }
    }
}
