import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Usage: java Main <input_file>");
            return;
        }
        try{
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            App app = null;
            boolean first = true;
            while((line = reader.readLine()) != null){
                String[] ss = line.trim().split("\\s+");
                if(ss.length == 2 && ss[1].equals("application")){
                    if(ss[0].equals("text")){
                        app = new TextApp();
                    }else if(ss[0].equals("spreadsheet")){
                        app = new SpreadsheetApp();
                    }
                }else if(ss.length == 2 && ss[0].equals("read")){
                    if(app != null){
                        if(!first) System.out.println();
                        first = false;
                        app.openDocument(ss[1]);
                    }
                }
            }
            reader.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}