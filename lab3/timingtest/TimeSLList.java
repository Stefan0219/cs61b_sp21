package timingtest;
import afu.org.checkerframework.checker.igj.qual.I;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;

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
        final int [] a = {10000,20000,40000,80000,160000,320000,640000,1280000};
        for (int i = 0;i<a.length;i++){
            SLList<Integer> slList = new SLList<>();
            AList<Double> time = new AList<>();
            AList<Integer> N = new AList<>();
            AList<Integer> ops = new AList<>();
            ops.addLast(10000);
            N.addLast(a[i]);
            for (int j = 0;j<a[i];j++){
                slList.addLast(3);
            }
            //Stopwatch sw = new Stopwatch();
            //System.out.println(ti);
            time.addLast(slList.getLast());
            printTimingTable(N,time,N);
        }
    }

}
