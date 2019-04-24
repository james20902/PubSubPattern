public class Main {

    public static Publisher test;
    public static Publisher test2;
    public static Publisher test3;

    public static void main(String []args){
        test = new Publisher(EventHandler.topics.Example, "uwu");
        test2 = new Publisher(EventHandler.topics.Example2);
        test2.setMessage("Only object 2 should see this");
        test3 = new Publisher(EventHandler.topics.Example3, "This is so sad");

        (new Thread(new Subscriber(EventHandler.topics.Example, 500))).start();
        (new Thread(new Subscriber(EventHandler.topics.Example2, 1000))).start();
        (new Thread(new Subscriber(EventHandler.topics.Example2, 500))).start();
        (new Thread(new Subscriber(EventHandler.topics.Example3, 250))).start();

        while(true){
            test.push();
            test2.push();
            test3.push();
            EventHandler.getInstance().poll();
        }
    }

}
