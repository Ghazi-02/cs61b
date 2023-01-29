package gh2;

import deque.Deque;
import deque.LinkedListDeque;

public class GuitarString {

    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        buffer = new LinkedListDeque<>();
        int capacity = (int) (SR / frequency);

        while (buffer.size() < Math.round(capacity)) {
            buffer.addLast((double) 0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        for (int x = 0; x < buffer.size(); x++) {
            double r = Math.random() - 0.5;
            buffer.removeFirst();
            buffer.addLast(r);
        }


    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double removed = buffer.removeFirst();
        double second = buffer.get(0);
        double decayed = DECAY * (0.5 * (removed + second));
        buffer.addLast(decayed);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {

        return buffer.get(0);
    }
}
