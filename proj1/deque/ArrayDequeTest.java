package deque;
import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void addLastTest(){
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0 ; i< 8; i++){
            ad.addLast(i);
        }
        for (int i = 0;i<8;i++){
            System.out.println(ad.get(i));
        }
    }

}
