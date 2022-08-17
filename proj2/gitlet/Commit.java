package gitlet;

// TODO: any imports you need here
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
    private String message;

    /** The time when this commit was created*/

    Date commitDate;
    /** The id which belongs to current commit.*/
    String commitId;

    /**The id which belongs to previous commit.*/
    String parentId;

    /** This map stores all the corresponding version a.k.a. blob for every file in this commit.*/
    Map<String,String> fileVer;
    /* TODO: fill in the rest of this class. */

    public String getMessage(){
        return this.message;
    }

    public String genShaId(){
        String dateString = commitDate.toString();
        if (fileVer!=null){
            String fileMapString = fileVer.toString();
            return Utils.sha1(commitDate.toString(),fileVer.toString(),message);
        }
        return Utils.sha1(commitDate.toString(),message);
    }

    /**init gitlet*/
    Commit(){
        this.message = "initial commit";
        commitDate =  new Date();
        this.commitId = genShaId();
        this.parentId = null;
        System.out.println(commitId);
    }
}
