package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max() {
        return max(comparator);
    }

    public T max(Comparator<T> c) {
        int maxDex = 0;
        for (int x = 0; x < size(); x++) {
            int cmp = c.compare(get(maxDex), get(x));
            if (cmp < 0) {
                maxDex = x;
            }
        }
        return get(maxDex);
    }
}
