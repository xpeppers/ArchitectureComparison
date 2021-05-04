package console;

public class Command {
    private final String username;
    private final String message;

    public Command(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public Command(String username) {
        this(username, null);
    }

    public String username() {
        return username;
    }

    public String message() {
        return message;
    }
}