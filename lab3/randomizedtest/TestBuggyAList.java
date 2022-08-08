package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();
        for (int i = 1 ;i<4;i++){
            aListNoResizing.addLast(i*5);
            buggyAList.addLast(i*5);
        }
        assertEquals(buggyAList.size(),aListNoResizing.size());
        for (int i = 0 ;i<3;i++){
            assertEquals(aListNoResizing.removeLast(),buggyAList.removeLast());
        }
    }

    @Test
    public void test() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            switch (operationNumber){
                case 0:
                    int randVal = StdRandom.uniform(0, 100);
                    aListNoResizing.addLast(randVal);
                    buggyAList.addLast(randVal);
                    break;
                case 1:
                    int size = aListNoResizing.size();
                    break;
                case 2:
                    if (aListNoResizing.size()==0){
                        continue;
                    }else {
                        int verified = aListNoResizing.getLast();
                        int buggy = buggyAList.getLast();
                        assertEquals(verified,buggy);
                    }
                    break;
                case 3:
                    if (aListNoResizing.size() == 0){
                        continue;
                    } else {
                        int verified = aListNoResizing.removeLast();
                        int buggy = buggyAList.removeLast();
                        assertEquals(verified,buggy);
                    }
                    break;
            }
        }
    }
}

