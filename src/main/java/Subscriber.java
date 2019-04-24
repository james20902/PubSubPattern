public class Subscriber implements Runnable{

    private Event currentEvent;
    private EventHandler.topics listener;
    private long timing;

    public Subscriber(EventHandler.topics topic){
        listener = topic;
        timing = 5;
        EventHandler.getInstance().registerSubscriber(this);
    }

    public Subscriber(EventHandler.topics topic, long timing){
        listener = topic;
        this.timing = timing;
        EventHandler.getInstance().registerSubscriber(this);
    }

    public EventHandler.topics returnTopic(){
        return listener;
    }

    public void recieveEvent(Event currentEvent){
        this.currentEvent = currentEvent;
    }

    public void setNewTiming(long timing){
        this.timing = timing;
    }

    public void run(){
        while(true){
            try {
                if(currentEvent != null){
                    System.out.println(this.toString() + " " + currentEvent.getEventMessage());
                }
                Thread.sleep(timing);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
