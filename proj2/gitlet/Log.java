package gitlet;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Log {
    private static File log = Utils.join(Repository.GITLET_DIR,"log");
    private static String logTempString;
    public static void appendLog(String s) throws IOException {
        logTempString = readLog();
        if (logTempString==null){
            logTempString = s;
        }else {
            logTempString = logTempString + "\n"+s;
        }
        storeLog();
    }
    public static void storeLog() throws IOException {
        if (!log.exists()){
            log.createNewFile();
        }
        Utils.writeContents(log,logTempString);
    }
    public static String readLog(){
        if (!Log.log.exists()){
            System.exit(0);
            return null;
        }
        return Utils.readContentsAsString(log);
    }
}
