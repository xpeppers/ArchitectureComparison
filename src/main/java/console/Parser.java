package console;

public class Parser {
    public Command parse(String string) {
        String username = string.split(" -> ")[0];
        String message = string.split(" -> ")[1];
        return new Command(username, message);

    }
}
