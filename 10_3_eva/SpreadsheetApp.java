import java.nio.file.Files;
import java.nio.file.Path;

public class SpreadsheetApp extends App{

    public SpreadsheetApp(){
        acceptedDocType = "csv";
    }

    @Override
    public boolean isOpenable(String docPath){
        boolean fileExists = super.isOpenable(docPath);
        if(fileExists) return isValidCsv(docPath);
        else return false; 
    }

    public boolean isValidCsv(String docPath){
        Document doc = createDocument(docPath);
        String[] lines = doc.getContent().split("\n");
        int n_col = lines[0].split(",").length;
        for(int i=1; i<lines.length; i++){
            if(lines[i].split(",").length != n_col) return false;
        }
        return true;
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
        return new SpreadsheetDocument(content);
    }

    @Override
    public void addDocument(Document doc){
        super.addDocument(doc);
    }
}