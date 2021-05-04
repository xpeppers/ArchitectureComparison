package console;

public class Parser {
    public Command parse(String string) {
        String[] tokens = string.split(" -> ");
        String username = tokens[0];
        String message = tokens.length == 2 ? tokens[1] : null;
        return new Command(username, message);
    }
}
