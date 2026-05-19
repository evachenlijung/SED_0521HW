public class TypeCheckOperator implements Operator{
    @Override
    public void onNode(Node node){}
    
    @Override
    public void onNode(VariableRefNode vnode){
        System.out.print("VariableRefNode");
    }

    @Override
    public void onNode(AssignmentNode anode){
        System.out.print("AssignmentNode");
    }
}