package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // assertEquals(<expected>, <actual>);
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> CL = new AListNoResizing<>();
        BuggyAList<Integer> BL = new BuggyAList<>();
        CL.addLast(4);
        CL.addLast(5);
        CL.addLast(6);
        CL.removeLast();

        BL.addLast(4);
        BL.addLast(5);
        BL.addLast(6);
        BL.removeLast();
        assertEquals(BL.removeLast(), CL.removeLast());
        assertEquals(BL.removeLast(), CL.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> BL = new BuggyAList<>();
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
                System.out.println("AListNoResizing size: " + size);
                System.out.println("BuggyAList size: " + size2);
            } else if (operationNumber == 2 && L.size() > 0) {
                int last = L.getLast();
                int last2 = BL.getLast();
                BL.removeLast();
                L.removeLast();
                System.out.println("Removed last value of AListNoResizing: " + last);
                System.out.println("Removed last value of BuggyAList : " + last2);
            }


        }
    }
}
