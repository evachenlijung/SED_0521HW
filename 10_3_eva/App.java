import java.nio.file.Files;
import java.nio.file.Path;

public class App{
    private Document doc;
    protected String acceptedDocType;

    public App(){
        doc = null;
        acceptedDocType = null;
    }

    public void openDocument(String docPath){
        if(isOpenable(docPath)){
            Document doc = createDocument(docPath);
            addDocument(doc);
            readDocument();
        }else System.out.print("Failed to read " + docPath);
    }

    public boolean isOpenable(String docPath){
        int lastDotIdx = docPath.lastIndexOf(".");
        if(lastDotIdx == -1) return false;
        String ext = docPath.substring(lastDotIdx + 1);
        if(!ext.equals(acceptedDocType)) return false;

        try{
            Path path = Path.of(docPath);
            return Files.exists(path) && Files.isRegularFile(path);
        }catch(Exception e){
            return false;
        }
    }

    public Document createDocument(String docPath){
        String content = null;
        try{
            content = Files.readString(Path.of(docPath));
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return new Document(content);
    }

    public void addDocument(Document doc){
        this.doc = doc;
    }

    public void readDocument(){
        String[] lines = doc.getContent().split("\n");
        System.out.print(String.join("\n", lines));
    }
}