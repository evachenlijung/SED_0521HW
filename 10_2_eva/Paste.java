public class Paste extends Action{
    public Paste(Document doc){
        super(doc);
    }

    public void execute(){
        doc.paste();
    }
}