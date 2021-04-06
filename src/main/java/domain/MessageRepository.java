package domain;

public interface MessageRepository {
    void addMessageForUser(Username username, Message message);
}
