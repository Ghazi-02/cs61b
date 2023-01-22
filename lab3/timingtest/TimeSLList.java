package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> Times = new AList<>();
        AList<Integer> OpCounts = new AList<>();
        for (int x = 1000; x <= 128000; x*=2){
            SLList<Integer> SLList = new SLList<>();
            for(int y=0; y<=x; y++){
                SLList.addLast(y);
            }

            int m = 1;
            Stopwatch sw = new Stopwatch();
            while (m < 10000){
                SLList.getLast();
                m++;
            }
            double timeInSeconds = sw.elapsedTime();
            Times.addLast(timeInSeconds);
            Ns.addLast(x);
            OpCounts.addLast(m);
        }
        printTimingTable(Ns,Times,OpCounts);
    }

}
