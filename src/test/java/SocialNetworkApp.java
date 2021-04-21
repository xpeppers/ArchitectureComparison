public class SocialNetworkApp {
    public static final String NULL_COMMAND = "";
    private SocialNetworkConsole console;
    private SocialNetworkInterpreter interpreter;

    public SocialNetworkApp(SocialNetworkConsole console, SocialNetworkInterpreter interpreter) {
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
