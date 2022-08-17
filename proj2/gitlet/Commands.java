package gitlet;

import java.io.File;
import java.util.HashSet;
public class Commands {
    public static void init(){
        Repository.GITLET_DIR.mkdir();
        Commit commit = new Commit();
        //TODO
        return;
    }
    /**Save the added files to the staging area*/
    public static void add(String args[]){
        if (!Repository.GITLET_DIR.exists()){
            System.out.println("Not in an initialized Gitlet directory.");
            System.exit(0);
        }else{
            Staging.Files = new HashSet<>();
            for (int i = 1 ;i< args.length;i++){
                File tempFile = Utils.join(Staging.CWD,args[i]);
                if (!tempFile.exists()){
                    System.out.println(args[i]+" doesn't exist.");
                    System.exit(0);
                }else {
                    Staging.Files.add(tempFile);
                    Staging.store();
                }
            }
        }
    }

    public static void status(){
        System.out.println(Staging.read());
    }

    public static void validateNumCheck(String [] args, int n){
        if (args.length!=n){
            System.out.println("Incorrect operands.");
            System.exit(0);
        }
    }
}
