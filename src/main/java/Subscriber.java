public class Subscriber implements Runnable{

    private Event currentEvent;
    private long timing;

    public Subscriber(EventHandler.topics topic){
        EventHandler.getInstance().registerSubscriber(topic, this);
        timing = 5;
    }

    public Subscriber(EventHandler.topics topic, long timing){
        EventHandler.getInstance().registerSubscriber(topic, this);
        this.timing = timing;
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
                System.out.println(this.toString() + " " + currentEvent.getEventMessage());
                Thread.sleep(timing);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
                System.out.println(this.toString() + " no message");
            }
        }
    }
}
