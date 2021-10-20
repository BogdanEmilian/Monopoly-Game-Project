public class Main{
    public static void main(String[] args){

        InputDevice in = new InputDevice();
        OutputDevice out = new OutputDevice();

        Application app = new Application(in,out);
        app.run();
    }
}