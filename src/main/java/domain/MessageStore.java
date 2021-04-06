package domain;

public interface MessageStore {
    void addMessageForUser(Username username, Message message);
}
