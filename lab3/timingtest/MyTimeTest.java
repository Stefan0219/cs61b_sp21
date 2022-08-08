package timingtest;

import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;

public class MyTimeTest {
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
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        int addValue = 0x7ff;
        for (int i = 0; i < sizes.length; i++) {
            AList<Double> time = new AList<>();
            AList<Integer> N = new AList<>();
            N.addLast(sizes[i]);
            Slist<Integer> slist = new Slist<>();
            for (int j = 0; j < sizes[i]; j++) {
                slist.addFirst(11);
            }
            Stopwatch sw = new Stopwatch();
            slist.getLast();
            double etime = sw.elapsedTime();
            time.addLast(etime);
            printTimingTable(N,time,N);

        }
    }
}

