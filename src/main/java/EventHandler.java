import java.util.EnumMap;
import java.util.Map;
import java.util.Stack;

public class EventHandler {

    private static EventHandler instance;
    private Stack<Object> stack = new Stack<>();
    private Map<topics, Subscriber> map = new EnumMap<>(topics.class);

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

    public void registerSubscriber(topics topic, Subscriber sub){
        map.put(topic, sub);
    }

    public void pushToStack(Event message){
        stack.push(message);
    }

    public void poll(){
        while(!stack.empty()){
            Event event = (Event)stack.pop();
            for(Map.Entry<topics, Subscriber> entry : map.entrySet()){
                if(event.getEventTopic() == entry.getKey()){
                    entry.getValue().recieveEvent(event);
                }
            }
        }
    }

}
