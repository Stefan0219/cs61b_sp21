package gitlet;



import java.io.File;
import java.io.IOException;

public class Blob {
    public String shaId;
    public File storedDir;

    private File contentFile;
    private byte[] contentet;
    private byte[] convert2bytes(File file){
        if (file.exists()){
            return Utils.readContents(file);
        }
        System.out.println("This file doesn't exists. " + file.getName());
        return null;
    }

    public String getBlobShaID(){
        String shaId;
        shaId = Utils.sha1(contentet,storedDir);
        return shaId;
    }

    public void storeBlob() throws IOException {
        File store = Utils.join(storedDir,shaId);
        store.createNewFile();
        Utils.writeContents(store,contentet);
    }

    Blob(File source,File storedDir){
        this.contentFile = source;
        this.storedDir = storedDir;
    }
}
