import java.nio.file.Files;
import java.nio.file.Path;

public class TextApp extends App{

    public TextApp(){
        acceptedDocType = "txt";
    }

    @Override
    public Document createDocument(String docPath){
        String content = null;
        try{
            content = Files.readString(Path.of(docPath));
        }
        catch(Exception e){
            System.err.print(e.getMessage());
        }
        return new TextDocument(content);
    }

    @Override
    public void addDocument(Document doc){
        super.addDocument(doc);
    }
}