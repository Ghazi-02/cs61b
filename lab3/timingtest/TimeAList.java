
package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }


    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> XList = new AList<>();
        AList<Integer> L  = new AList<>();
        AList<Double> LTimes = new AList<>();
        Stopwatch sw = new Stopwatch();
        for (int x =   1000; x <= 128000; x *= 2){
         for (int y = 0 ; y <= x; y++) {
             L.addLast(x);
         }
         double tIS = sw.elapsedTime();
         LTimes.addLast(tIS);
         XList.addLast(x);
        }
        printTimingTable(XList,LTimes,XList);
    }

}
