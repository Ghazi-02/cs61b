package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {


    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {


        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }
        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }
    @Test
    public void TestGet(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addLast(10);
        L.addLast(11);
        L.addLast(12);
        assertEquals("3",L.get(0).toString());
        assertEquals("2",L.get(1).toString());
        assertEquals("12",L.get(5).toString());
    }

    @Test
    public void TestGetRecur(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addLast(10);
        L.addLast(11);
        L.addLast(12);
        assertEquals("3",L.getRecursive(0).toString());
        assertEquals("2",L.getRecursive(1).toString());
        assertEquals("12",L.getRecursive (5).toString());
    }

    @Test
    public void LLDequeRandomTest(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        LinkedListDeque<Integer> BL = new LinkedListDeque<>();
        int N = 5000;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                //addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast((randVal));
                BL.addLast((randVal));
                System.out.println("addLast(" + randVal + ") to both Lists");
            } else if (operationNumber == 1) {
                //size
                int size = L.size();
                int size2 = BL.size();
                System.out.println("AList1 size: " + size);
                System.out.println("AList2 size: " + size2);
            } else if (operationNumber == 2 && L.size() > 0) {
                int last = L.get(L.size()-1);
                int last2 = BL.get(BL.size()-1);
                BL.removeLast();
                L.removeLast();
                System.out.println("Removed last value of AList2: " + last);
                System.out.println("Removed last value of AList1 : " + last2);
            }
        }
    }
    @Test
    public void AddFirstAddLast(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addLast(10);
        L.addLast(11);
        L.addLast(12);
        assertEquals(" 3 2 1 10 11 12",L.toString());

    }
    @Test
    public void RemoveFirst(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addLast(10);
        L.addLast(11);
        L.addLast(12);
        assertEquals("3", L.removeFirst().toString());
        assertEquals(" 2 1 10 11 12",L.toString());

    }
    @Test
    public void RemoveLast(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addLast(10);
        L.addLast(11);
        L.addLast(12);
        assertEquals("12", L.removeLast().toString());
        assertEquals(" 3 2 1 10 11",L.toString());

    }
    @Test
    public void TestIterator(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addLast(10);
        L.addLast(11);
        L.addLast(12);
        for(Integer x : L){
            System.out.println(x);
        }
    }
    @Test
    public void TestEqualsTrue(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addLast(10);
        L.addLast(11);
        L.addLast(12);
        LinkedListDeque<Integer> BL = new LinkedListDeque<>();
        BL.addFirst(1);
        BL.addFirst(2);
        BL.addFirst(3);
        BL.addLast(10);
        BL.addLast(11);
        BL.addLast(12);
        assertTrue("These should be equal",L.equals(BL));
    }
    @Test
    public void TestEqualsValueFalse(){
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addLast(10);
        L.addLast(11);
        L.addLast(12);
        ArrayDeque<Integer> BL = new ArrayDeque<>();
        BL.addFirst(1);
        BL.addFirst(2);
        BL.addFirst(3);
        BL.addLast(0);
        BL.addLast(11);
        BL.addLast(12);
        assertFalse("These shouldnt be equal",L.equals(BL));
    }
    @Test
    public void TestEqualsClassFalse(){
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addLast(10);
        L.addLast(11);
        L.addLast(12);
        LinkedListDeque<Integer> BL = new LinkedListDeque<>();
        BL.addFirst(1);
        BL.addFirst(2);
        BL.addFirst(3);
        BL.addLast(0);
        BL.addLast(11);
        BL.addLast(12);
        assertFalse("These shouldnt be equal",L.equals(BL));
    }


}



