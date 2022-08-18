package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author Stefan Tian
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        if (args.length==0){
            System.out.println("Please enter a command.");
            return;
        }
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                Commands.init();
                break;
            case "add":
                if (args.length<=1){
                    break;
                }
                Commands.add(args);
                break;
            case "status":
                Commands.status();
                //TODO need to add untracked file.
                break;
                //this is used for testing.
            case "resetStaging":
                Commands.resetStaging();
                break;
            case "log":
                Commands.log();
                break;
            case "commit":
                Commands.commit(args);
                break;
            default:
                System.out.println("No command with that name exists.");
        }
    }
}
