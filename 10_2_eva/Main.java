import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Usage: java Main <input_file>");
            return;
        }
        try{
            Document doc = new Document();
            App app = new App(doc);
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            boolean first = true;
            while((line = reader.readLine()) != null){
                if(!first) System.out.println();
                first = false;
                String[] ss = line.trim().split("\\s+");
                switch(ss[0]){
                    case "Cut" -> {app.getMenu().get("cut").click(); }
                    case "Copy" -> {app.getMenu().get("copy").click(); }
                    case "Paste" -> {app.getMenu().get("paste").click(); }
                }
            }
            reader.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}