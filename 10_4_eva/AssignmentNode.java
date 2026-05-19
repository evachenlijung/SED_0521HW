public class AssignmentNode extends Node{
    private String value;
    private Node node = null;

    public AssignmentNode(String name, String value){
        super(name);
        this.value = value;
    }

    public AssignmentNode(String name, Node node){
        super(name);
        this.node = node;
    }

    @Override
    public void apply(Operator op){
        op.onNode(this);
    }

    public String getValue(){
        return value;
    }

    public Node getNode(){
        return node;
    }

    public String toString(){
        if(node == null) return name + " = " + value;
        else return name + " = " + node; 
    } 
}