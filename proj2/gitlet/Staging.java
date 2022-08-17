package gitlet;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class Staging implements Serializable {
    public static File CWD = Repository.CWD;
    public static File STAGING = Utils.join(Repository.GITLET_DIR,"staging");
    public static HashMap<File,String> map;
    public static HashSet<File> Files;

    public static void store(){
        Utils.writeObject(STAGING,Files);
    }
    public static String read(){
        Files = new HashSet<>();
        Object temp = Utils.readObject(STAGING,Files.getClass());
        HashSet<File> files = (HashSet<File>)temp;
        StringBuilder ret = new StringBuilder();
        for (File file : files){
            ret.append(file.getName()).append(" ");
        }
        return ret.toString();
    }
}
