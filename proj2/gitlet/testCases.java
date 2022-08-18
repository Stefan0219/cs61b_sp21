package gitlet;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class testCases {
    @Test
    public void test(){
        //System.out.println(a.getClass());
        File ab = Repository.CWD;
        var a = ab.listFiles();
        for (var f : a  ){
            System.out.println(f.getName());
        }
    }

    @Test
    public void logTest() throws IOException {
        Log.appendLog("sad");
        Log.storeLog();
        System.out.println(Log.readLog());
    }
}
