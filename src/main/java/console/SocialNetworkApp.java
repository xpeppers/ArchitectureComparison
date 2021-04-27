package console;

public class SocialNetworkApp {
    public static final String NULL_COMMAND = "";
    private SocialNetworkConsole console;
    private SocialNetworkController interpreter;

    public SocialNetworkApp(SocialNetworkConsole console, SocialNetworkController interpreter) {
        this.console = console;
        this.interpreter = interpreter;
    }

    public void run() {
        while (true) {
            String string = console.read();
            if (NULL_COMMAND.equals(string)) return;

            String output = interpreter.accept(string);
            console.write(output);
        }
    }
}
