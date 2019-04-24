public class ButtonWrapper extends Publisher{

    int buttonID;

    public ButtonWrapper(int ID, EventHandler.topics topic) {
        super(topic);
        buttonID = ID;
    }

    public ButtonWrapper(int ID, EventHandler.topics topic, Object message) {
        super(topic, message);
        buttonID = ID;
    }

    public void pollJoystick(){
        //if button pressed, push
        //TODO add some debounce stuff so that publisher can toggle or only send a message once
        if(true){
            push();
        }
    }
}
