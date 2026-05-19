public class PrintOperator implements Operator{
    @Override
    public void onNode(Node node){}
    
    @Override
    public void onNode(VariableRefNode vnode){
        System.out.print(vnode);
    }

    @Override
    public void onNode(AssignmentNode anode){
        if(anode.getNode() == null)
            System.out.print(String.format("AssignmentNode(%s, %s)", anode.getName(), anode.getValue()));
        else
            System.out.print(String.format("AssignmentNode(%s, VariableRefNode(%s))", anode.getName(), anode.getNode()));
    }
}