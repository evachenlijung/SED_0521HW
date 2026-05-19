public class VariableRefNode extends Node{
    public VariableRefNode(String name){
        super(name);
    }

    @Override
    public void apply(Operator op){
        op.onNode(this);
    }

    public String toString(){
        return this.name;
    }
}