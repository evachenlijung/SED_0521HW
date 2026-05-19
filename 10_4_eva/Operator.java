public interface Operator{
    public void onNode(Node node);
    public void onNode(VariableRefNode vnode);
    public void onNode(AssignmentNode anode);
}