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
    public void testThreeAddThreeRemove(){
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
        assertEquals(BL.removeLast(),CL.removeLast());
        assertEquals(BL.removeLast(),CL.removeLast());
    }


    }



}
