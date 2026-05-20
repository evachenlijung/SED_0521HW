import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        try{
            compile();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void compile(){
        CompilerSubsystem compiler = new CompilerSubsystem();
        compiler.compile();
    }
}