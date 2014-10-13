
import java.util.*;

import kvmap.KVMap;

/**
 * To represent the Testing Performance of my code class
 * @author Hussein Abou Nassif Mourad
 * @version 05/23/2014
 */
public class TestingMyCode {

    /**
     * The main method
     * @param args the arguments
     */
    public static void main(String [] args) {
        /** Creating an instance of TestingMyCode */
        TestingMyCode test = new TestingMyCode();

        try {
            test.runningIt();
        }
        catch (Exception e) {
            System.out.println("Program encountered an error while Performing"
                    + " the tasks!");
            System.out.println(e);
        }


    }

    /**
     * Run the test programs according to comparators (if any)
     */
    private void runningIt() {

        /** Header for what task is going to occur */
        System.out.println("****** THE FOLLOWING ARE TESTS FOR THE "
                + "NON-LITERATURE TEXTS ******");
        System.out.println();

        /** The Top Bar headers */
        System.out.println("Comparator - File - Num Strings - Size (#) - " + 
                "Build (ms) - Iterator (ms) - Iterate (ms) - Contains (ms) -"
                + " Num Contained");
        System.out.println();

        /** Create an instance of EmptyMap with no comparator */
        KVMap<String, Integer> empty = KVMap.emptyMap();

        /** Create an instance of EmptyMap with StringByLex comparator */
        KVMap<String, Integer> emptyLex = KVMap.emptyMap(new StringByLex());

        /** Create an instance of EmptyMap with StringReverseByLex comp */
        KVMap<String, Integer> emptyRevLex = 
                KVMap.emptyMap(new StringReverseByLex());

        /*****************************************************/
        /** PROCEDURE FOR FIRST SET OF FILES                 */
        /*****************************************************/

        /** The files represented as Strings */
        String text1 = "lexicographically_ordered.txt";
        String text2 = "reverse_ordered.txt";
        String text3 = "random_order.txt";

        /** Place the text file strings inside the array */
        ArrayList<String> fileList = new ArrayList<String>();
        fileList.add(text1);
        fileList.add(text2);
        fileList.add(text3);

        /** Call the corresponding methods */
        this.withoutComparators(fileList, empty);
        this.withComparators(fileList, emptyLex, emptyRevLex);

        /** Add some white space so not everything is stuck to each other */
        System.out.println();
        System.out.println();

        /** Header for what task is going to occur */
        System.out.println("****** THE FOLLOWING ARE TESTS FOR THE "
                + "LITERATURE TEXTS ******");
        System.out.println();

        /** The Top Bar headers */
        System.out.println("Comparator - File - Num Strings - Size (#) - " + 
                "Build (ms) - Iterator (ms) - Iterate (ms) - Contains (ms) -"
                + " Num Contained");
        System.out.println();

        /*****************************************************/
        /** PROCEDURE FOR SECOND SET OF FILES                */
        /*****************************************************/

        /** The files represented as Strings (The literature ones) */
        String text4 = "hippooath.txt";
        String text5 = "Confucius_The_Great_Learning.txt";
        String text6 = "Apology_Plato.txt";

        /** Record the number of words in the text files */
        int hipWords = this.countWords(new StringIterator("hippooath.txt"));
        int confWords = this.countWords(
                new StringIterator("Confucius_The_Great_Learning.txt"));
        int apoWords = this.countWords(new StringIterator("Apology_Plato.txt"));

        /** Place the text file strings inside the array */
        ArrayList<String> fileList2 = new ArrayList<String>();
        fileList2.add(text4);
        fileList2.add(text5);
        fileList2.add(text6);

        /** Run second set of files the tests with no comparator and null */
        this.pTest("No Comparator", empty, "hippooath.txt", hipWords);
        this.pTest("No Comparator", empty, 
                "Confucius_The_Great_Learning.txt", confWords);
        this.pTest("No Comparator", empty, "Apology_Plato.txt", apoWords);

        /** Run second set of files the tests with StringByLex */
        this.pTest("StringByLex", emptyLex, "hippooath.txt", 466);
        this.pTest("StringByLex", emptyLex, 
                "Confucius_The_Great_Learning.txt", confWords);
        this.pTest("StringByLex", emptyLex, "Apology_Plato.txt", apoWords);

        /** Run second set of files the tests with StringByLex */
        this.pTest("StringReverseByLex", emptyRevLex, 
                "hippooath.txt", hipWords);
        this.pTest("StringReverseByLex", emptyRevLex, 
                "Confucius_The_Great_Learning.txt", confWords);
        this.pTest("StringReverseByLex", emptyRevLex, 
                "Apology_Plato.txt", apoWords);
    }

    /**
     * Record the number of words in the file
     * @param it which is the file or text that will check counter of words
     * @return the number of words inside the file
     */
    private int countWords(Iterator<String> it) {
        int words = 0;
        while (it.hasNext()) {
            words++;
            it.next();
        }
        return words;
    }

    /**
     * Performing through elements of the list with no comparators
     * @param fList the list with the 3 files in it
     * @param noCompMap KVMap without comparator in it
     */
    private void withoutComparators(ArrayList<String> fList,
            KVMap<String, Integer> noCompMap) {

        for (String str: fList) {
            for (int words = 2000; words <= 16000; words *= 2) {
                this.pTest("No Comparator", noCompMap, str, words);
            }
        }
    }

    /**
     * Performing through elements of the list with comparators
     * @param fList the list with the files in it
     * @param compMap1 the kvmap containing the comparator
     * @param compMap2 the kvmap containing the second comparator
     */
    private void withComparators(ArrayList<String> fList,
            KVMap<String, Integer> compMap1, KVMap<String, Integer> compMap2) {

        /** StringByLex */
        for (String str: fList) {
            for (int words = 2000; words <= 16000; words *= 2) {
                this.pTest("StringByLex", compMap1, str, words);
            }
        }

        /** StringReverseByLex */
        for (String str: fList) {
            for (int words = 2000; words <= 16000; words *= 2) {
                this.pTest("StringReverseByLex", compMap2, str, words);
            }
        }
    }

    /**
     * Perform the actual tests and seeing the timing for each
     * @param str the comparator
     * @param kMap the file
     * @param fileStr file name
     * @param sizeWords how many words
     */
    private void pTest(String str, KVMap<String, Integer> kMap, String fileStr,
            int sizeWords) {

        /** Initialize time before it runs the test */
        long begin = System.currentTimeMillis();

        /** Get the first three headers filled in */
        System.out.print(str + " - " + fileStr + " - " + sizeWords + " - ");

        Iterator<String> sIterator = new StringIterator(fileStr);
        int i = 0;
        while (i < sizeWords && sIterator.hasNext()) {
            i++;
            kMap = kMap.assign(sIterator.next(), i);
        }

        /** Initialize time after it runs the test */
        long end = System.currentTimeMillis();

        /** The difference between ending and begin time */
        long diff = end - begin;

        /** Print the size as well as the difference in times */
        System.out.print(kMap.size() + " - " + diff + " - ");


        /*****************************************************/
        /** NEW PROCEDURE FOR CREATING AN ITERATOR FOR KVMAP */
        /*****************************************************/

        /** Replace the previous begin time with new set of times */
        begin = System.currentTimeMillis();

        /** create an iterator */
        Iterator<String> it = kMap.iterator();

        /** Replace the end time of this action */
        end = System.currentTimeMillis();

        /** replace the difference in times */
        diff = end - begin;

        /** Print out the time taken for the iterator action */
        System.out.print(diff + " - ");


        /**********************************************/
        /** NEW PROCEDURE FOR ITERATING THROUGH KVMAP */
        /**********************************************/

        /** Replace the previous begin time with new set of times */
        begin = System.currentTimeMillis();

        /** Iterate through it */
        while (it.hasNext()) { 
            it.next();
        }

        /** Replace the end time of this action */
        end = System.currentTimeMillis();

        /** replace the difference in times */
        diff = end - begin;

        /** Print out the time taken for the iterator action */
        System.out.print(diff + " - ");


        /**********************************************/
        /** NEW PROCEDURE FOR CONTAINSKEY IN KVMAP    */
        /**********************************************/

        /** Replace the previous begin time with new set of times */
        begin = System.currentTimeMillis();

        int found = 0;
        StringIterator si = new StringIterator("contains_list.txt");
        for (String s : si) {
            if (kMap.containsKey(s)) {
                found++;
            }
        }

        /** Replace the end time of this action */
        end = System.currentTimeMillis();

        /** replace the difference in times */
        diff = end - begin;

        /** Print out the time taken for checking string values in kvmap */
        System.out.println(diff + " - " + found);
    }

}
