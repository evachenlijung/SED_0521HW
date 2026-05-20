public class MenuItem{
    private Action action;

    public MenuItem(Action action){
        this.action = action;
    }

    public void click(){
        action();
    }

    public void action(){
        action.execute();
    }
}