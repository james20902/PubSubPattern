public class Publisher{

    EventHandler.topics topic;
    Object message = "Default message, did you not set a new one?";
    boolean killed = false;

    public Publisher(EventHandler.topics topic){
        this.topic = topic;
    }

    public Publisher(EventHandler.topics topic, Object message){
        this.topic = topic;
        this.message = message;
    }

    public void killPublisher(){
        killed = true;
    }

    public void setMessage(Object message){
        this.message = message;
    }

    public void setTopic(EventHandler.topics topic){
        this.topic = topic;
    }

    public void push(){
        EventHandler.getInstance().pushToStack(new Event(topic, message));
    }

}
