package console;

public class SocialNetworkApp {
    public static final String NULL_COMMAND = "";
    private SocialNetworkConsole console;
    private SocialNetworkController controller;

    public SocialNetworkApp(SocialNetworkConsole console, SocialNetworkController controller) {
        this.console = console;
        this.controller = controller;
    }

    public void run() {
        while (true) {
            String string = console.read();
            if (NULL_COMMAND.equals(string)) return;

            String output = controller.accept(string);
            console.write(output);
        }
    }
}
