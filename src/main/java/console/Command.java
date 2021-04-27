package console;

public class Command {
    private String username;
    private String message;

    public Command(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String username() {
        return username;
    }

    public String message() {
        return message;
    }
}