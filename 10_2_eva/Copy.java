public class Copy extends Action{
    public Copy(Document doc){
        super(doc);
    }

    public void execute(){
        doc.copy();
    }
}