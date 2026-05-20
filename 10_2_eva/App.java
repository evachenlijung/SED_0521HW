import java.util.*;

public class App{
    private Document doc;
    private static Map<String, MenuItem> menu;

    public App(Document doc){
        this.doc = doc;
        menu = new LinkedHashMap<>();
        menu.put("cut", new MenuItem(new Cut(doc)));
        menu.put("copy", new MenuItem(new Copy(doc)));
        menu.put("paste", new MenuItem(new Paste(doc)));
    }

    public void setDocument(Document doc){
        this.doc = doc;
    }

    public Map<String, MenuItem> getMenu(){
        return menu;
    }
}