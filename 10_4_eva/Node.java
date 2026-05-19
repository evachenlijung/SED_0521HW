public class Node{
    protected String name;

    public Node(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void apply(Operator op){
        op.onNode(this);
    }
}