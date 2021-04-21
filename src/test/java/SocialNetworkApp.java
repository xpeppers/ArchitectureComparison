public class SocialNetworkApp {
    private SocialNetworkConsole console;
    private SocialNetworkInterpreter interpreter;

    public SocialNetworkApp(SocialNetworkConsole console, SocialNetworkInterpreter interpreter) {
        this.console = console;
        this.interpreter = interpreter;
    }

    public void run() {
        String string = null;
        do {
            string = console.read();
            String output = interpreter.accept(string);
            console.write(output);
        } while (!string.equals(""));
    }
}
