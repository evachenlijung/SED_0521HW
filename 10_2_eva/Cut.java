public class Cut extends Action{
    public Cut(Document doc){
        super(doc);
    }

    public void execute(){
        doc.cut();
    }
}