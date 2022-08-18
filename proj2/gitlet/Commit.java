package gitlet;

// TODO: any imports you need here
import java.io.File;
import java.io.Serializable;
import java.util.Date; // TODO: You'll likely use this in this class
import java.util.Map;


/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author Stefan Tian
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private String commitMessage;


    /**HEAD points to previous commit.*/
    public static File HEAD = Utils.join(Repository.GITLET_DIR,"Head");

    /** The time when this commit was created*/

    Date commitDate;
    /** The Sha-1 id which belongs to current commit.*/
    String commitId;

    /**The id which belongs to previous commit.*/
    String parentId;

    /** This map stores all the corresponding version a.k.a. blob for every file in this commit.*/
    Map<String,String> fileVer;
    /* TODO: fill in the rest of this class. */

    public String getCommitMessage(){
        return this.commitMessage;
    }

    public String genShaId(){
        String dateString = commitDate.toString();
        if (fileVer!=null){
            String fileMapString = fileVer.toString();
            return Utils.sha1(commitDate.toString(),fileVer.toString(), commitMessage);
        }
        return Utils.sha1(commitDate.toString(), commitMessage);
    }

    /**init gitlet*/
    Commit(){
        this.commitMessage = "initial commit";
        commitDate =  new Date();
        this.commitId = genShaId();
        this.parentId = null;
        storeHead(commitId);
    }

    /**Command commit*/
    Commit(String []args){
        //TODO
        if (args[1]==null){
            //commit with nothing identifier is prohibited.
            System.exit(0);
        }
        else {
            this.commitMessage = args[1];
            commitDate = new Date();
            this.commitId = genShaId();
            this.parentId = readHead();
        }
    }
    public static void storeHead(String s){
        Utils.writeContents(HEAD,s);
    }

    public static String readHead(){
        return Utils.readContentsAsString(HEAD);
    }
}
