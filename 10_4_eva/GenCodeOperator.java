public class GenCodeOperator implements Operator{
    @Override
    public void onNode(Node node){}
    
    @Override
    public void onNode(VariableRefNode vnode){
        System.out.print(vnode);
    }

    @Override
    public void onNode(AssignmentNode anode){
        System.out.print(anode);
    }
}