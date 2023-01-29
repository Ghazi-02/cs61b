package deque;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Comparator;

public class MaxArrayDequeTest {
    private static class StrLengthComparator implements Comparator<String> {
        public int compare(String x, String y) {
            if (x.length() > y.length()) {
                return 1;
            } else if (x.length() == y.length()) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    private static class AbsIntComparator implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            if (x * x > y * y) {
                return 1;
            } else if (x * x == y * y) {
                return 0;
            } else {
                return -1;
            }
        }
    }


    @Test
    public void StringMaxArrayDeque() {
        MaxArrayDeque<String> test = new MaxArrayDeque<>(new StrLengthComparator());
        test.addFirst("potato");
        test.addLast("fat");
        test.addLast("ogre");
        test.addFirst("smell");
        test.addFirst("head");

        assertEquals("potato", test.max());
    }

    @Test
    public void AbsIntegerMaxArrayDeque() {
        MaxArrayDeque<Integer> test = new MaxArrayDeque<>(new AbsIntComparator());
        test.addFirst(324);
        test.addFirst(657);
        test.addLast(0);
        test.addFirst(-325);
        test.addLast(342);

        assertEquals(657, (int) test.max());
    }
}
