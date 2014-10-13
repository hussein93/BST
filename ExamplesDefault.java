import java.util.ArrayList;
import java.util.Comparator;

import kvmap.KVMap;
import kvmap.LexiString;
import tester.Tester;


/**
 * To represent the examples class
 * @author Hussein Abou Nassif Mourad
 * @version 05-17-2014
 */
public class ExamplesDefault {
    /**
     * Run the test programs according to comparators (if any)
     * @param t the tester
     */
    public void testPathLengths(Tester t) {
        /** Examples of classes */
        PathLengths<String, Integer> pl1 = new PathLengths<String, Integer>();
        BlackHeight<String, Integer> bh1 = new BlackHeight<String, Integer>();
        StringWithNumber swn = new StringWithNumber();
        GCD gcd1 = new GCD();

        /** Comparators */
        Comparator<String> lexiComp = new LexiString();
        Comparator<Integer> intComp = new IntComp();

        /** Examples of Binary Search Trees */
        KVMap<String, Integer> treeEmptyNoComp = KVMap.emptyMap();
        KVMap<String, Integer> treeEmpty = KVMap.emptyMap(lexiComp);
        KVMap<String, Integer> tree1 = treeEmpty.assign("f", 88);
        KVMap<String, Integer> tree2 = tree1.assign("c", 35);
        KVMap<String, Integer> tree3 = tree2.assign("z", 11);
        KVMap<String, Integer> tree4 = tree3.assign("g", 15);

        KVMap<String, Integer> tree5 = treeEmptyNoComp.assign("c", 35);

        /** Example of int comparator */
        KVMap<Integer, Integer> treeEmpty34 = KVMap.emptyMap();
        KVMap<Integer, Integer> treeEmpty3 = KVMap.emptyMap(intComp);
        KVMap<Integer, Integer> treeI1 = treeEmpty3.assign(1, 2);

        KVMap<Integer, Integer> treeEmptyN = KVMap.emptyMap(intComp);
        KVMap<Integer, Integer> treeI11 = treeEmptyN.assign(1, 1);

        /** Examples of KVMap Trees */
        KVMap<Integer, String> treeEmpty1 = KVMap.emptyMap();
        KVMap<Integer, String> tree11 = treeEmpty1.assign(88, "f");

        KVMap<Integer, String> treeEmpty11 = KVMap.emptyMap();
        KVMap<Integer, String> tree111 = treeEmpty11.assign(88, "f 88");

        /** New forms of array lists */
        ArrayList<Integer> alist1 = new ArrayList<Integer>();
        alist1.add(0);

        /** New forms of array lists */
        ArrayList<Integer> alist2 = new ArrayList<Integer>();
        alist2.add(1);
        alist2.add(1);

        /** New forms of array lists */
        ArrayList<Integer> alist3 = new ArrayList<Integer>();
        alist3.add(2);
        alist3.add(2);
        alist3.add(2);
        alist3.add(2);

        /** Testing the accept methods and changeBlack */
        t.checkExpect(tree11.accept(swn), tree111);
        t.checkExpect(treeEmpty3.accept(gcd1), treeEmpty3);
        t.checkExpect(intComp.compare(new Integer(1), new Integer(2)), 
                new Integer(-1));
        t.checkExpect(treeEmpty34.accept(gcd1), treeEmpty34);

        try {
            t.checkExpect(treeEmptyNoComp.acceptRBT(pl1), tree111);
        }
        catch (Exception e) {
            System.out.println("Can't from Empty class");
            System.out.println(e);
        }

        /** Array Lists */
        ArrayList<Integer> num = new ArrayList<Integer>();
        num.add(1);
        num.add(1);

        ArrayList<Integer> num2 = new ArrayList<Integer>();
        num2.add(2);
        num2.add(2);
        num2.add(3);
        num2.add(3);
        num2.add(2);

        try {
            t.checkExpect(tree1.acceptRBT(pl1), num);
            t.checkExpect(tree4.acceptRBT(pl1), num2);
            t.checkExpect(treeI1.accept(gcd1), treeI11);
            t.checkExpect(treeEmpty3.accept(gcd1), treeEmpty3);
            t.checkExpect(tree5.acceptRBT(pl1), treeEmpty3);
        }
        catch (Exception e) {
            System.out.println("Can't from Assign class");
            System.out.println(e);
        }

        /** Equals */
        //    t.checkExpect(treeEmpty1.equals(treeEmpty3), true); 

        /** Testing the acceptRBT methods */
        t.checkExpect(treeEmpty.acceptRBT(bh1), 0);
        t.checkExpect(tree1.acceptRBT(bh1), 0);
        t.checkExpect(tree3.acceptRBT(bh1), 1); 
        t.checkExpect(tree4.acceptRBT(bh1), 1); 
        t.checkExpect(treeEmpty.acceptRBT(pl1), alist1);
        t.checkExpect(tree1.acceptRBT(pl1), alist2);
        t.checkExpect(tree3.acceptRBT(pl1), alist3); 

        /** Testing GCD */
        t.checkExpect(gcd1.visit(22, 44), 22);
        t.checkExpect(gcd1.visit(2, 4), 2);
        t.checkExpect(gcd1.visit(0, 15), 0);
        t.checkExpect(gcd1.visit(100, 0), 0);      
    }

}
