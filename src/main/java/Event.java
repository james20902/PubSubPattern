public class Event {

    private EventHandler.topics topic;
    private Object message;

    public Event(EventHandler.topics topic, Object message){
        this.topic = topic;
        this.message = message;
    }

    public EventHandler.topics getEventTopic(){
        return topic;
    }

    public Object getEventMessage(){
        return message;
    }

}
