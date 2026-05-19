import java.util.*;

public class AST{
    private List<Node> nodes;

    public AST(){
        nodes = new ArrayList<>();
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public List<Node> getNodes(){
        return nodes;
    }
}