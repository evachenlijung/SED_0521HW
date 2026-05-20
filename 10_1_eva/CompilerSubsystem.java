public class CompilerSubsystem{
    public static MyScanner scanner = new MyScanner();
    public static MyParser parser = new MyParser();
    public static MyProgramNode programNdoe = new MyProgramNode();
    public static MyBytecodeStream bytecodeStream = new MyBytecodeStream();
    
    public CompilerSubsystem(){}

    public void compile(){
        parser.execute();
        System.out.println();
        scanner.execute();
        System.out.println();
        programNdoe.execute();
        System.out.println();
        bytecodeStream.execute();
    }
}