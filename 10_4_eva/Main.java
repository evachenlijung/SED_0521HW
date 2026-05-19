import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        if(args.length < 1){
            System.out.println("Usage: java Main <input_file>");
            return;
        }
        try{
            AST ast = new AST();
            TypeCheckOperator typeCheckOp = new TypeCheckOperator();
            GenCodeOperator genCodeOp = new GenCodeOperator();
            PrintOperator printOp = new PrintOperator();

            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            boolean first = true;
            while((line = reader.readLine()) != null){
                if(line.startsWith("AssignmentNode")){
                    String name = line.split("AssignmentNode\\(")[1].split(",")[0];
                    String value = line.split(",\\s*")[1];
                    int end = value.lastIndexOf(')');
                    value = value.substring(0, end);
                    if(value.startsWith("V")){
                        value = value.replace("VariableRefNode(", "").replace(")", "");
                        ast.addNode(new AssignmentNode(name, new VariableRefNode(value))); 
                    }else{
                        ast.addNode(new AssignmentNode(name, value));
                    }                   
                }else if(line.startsWith("VariableRefNode")){
                    String varName = line.replace("VariableRefNode(", "").replace(")", "");
                    ast.addNode(new VariableRefNode(varName));
                }else{
                    if(!first) System.out.println();
                    first = false;

                    String[] ss = line.trim().split("\\s+");
                    int idx = Integer.parseInt(ss[1]);
                    switch(ss[0]){
                        case "checkType" -> {ast.getNodes().get(idx).apply(typeCheckOp); }
                        case "generateCode" -> {ast.getNodes().get(idx).apply(genCodeOp); }
                        case "print" -> {ast.getNodes().get(idx).apply(printOp); }
                        default -> {}
                    }
                } 
            }
            reader.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}