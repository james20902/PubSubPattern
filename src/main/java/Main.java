public class Main {

    public static Publisher test;
    public static Publisher test2;

    public static void main(String []args){
        test = new Publisher(EventHandler.topics.Example);
        test2 = new Publisher(EventHandler.topics.Example2);
        test2.setMessage("Only object 2 should see this");

        (new Thread(new Subscriber(EventHandler.topics.Example, 500))).start();
        (new Thread(new Subscriber(EventHandler.topics.Example2, 1000))).start();

        while(true){
            test.push();
            test2.push();
            EventHandler.getInstance().poll();
        }
    }

}
