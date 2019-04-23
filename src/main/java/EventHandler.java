import java.util.ArrayList;
import java.util.Stack;

public class EventHandler {

    private static EventHandler instance;
    private Stack<Object> stack = new Stack<>();
    private ArrayList<Subscriber> list = new ArrayList<>();

    public enum topics{
        Example,
        Example2,
        Example3
    }

    public static EventHandler getInstance(){
        if(instance == null){
            instance = new EventHandler();
        }
        return instance;
    }

    public void registerSubscriber(Subscriber sub){
        list.add(sub);
    }

    public void pushToStack(Event message){
        stack.push(message);
    }

    public void poll(){
        while(!stack.empty()){
            Event event = (Event)stack.pop();
            for(Subscriber sub : list){
                if(event.getEventTopic() == sub.returnTopic()){
                    sub.recieveEvent(event);
                }
            }
        }
    }

}
