public class Publisher{

    EventHandler.topics topic;
    Object message = "Hello World";
    boolean killed = false;

    public Publisher(EventHandler.topics topic){
        this.topic = topic;
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
        if(message != null){
            EventHandler.getInstance().pushToStack(new Event(topic, message));
        } else {
            EventHandler.getInstance().pushToStack(new Event(topic, ""));
        }
    }

}
