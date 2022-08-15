package deque;
import org.junit.Test;
import static org.junit.Assert.*;

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

    @Test
    public void addFirstTest(){
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0 ; i< 8; i++){
            ad.addFirst(i);
        }
        for (int i = 0;i<8;i++){
            System.out.println(ad.get(i));
        }
    }

    @Test
    public void equalsTest(){
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        for (int i = 0;i<8;i++){
            ad1.addFirst(i);
            ad2.addFirst(i);
        }
        assertTrue(ad1.euqals(ad2));
        assertTrue(ad1.euqals(ad1));
        ad2.addFirst(3);
        assertFalse(ad1.euqals(ad2));

    }

    @Test
    public void test(){
        System.out.println(-1%3);
    }

}
