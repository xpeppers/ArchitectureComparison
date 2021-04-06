package domain;

public class PostMessageUseCase {
    private MessageStore messageStore;

    public PostMessageUseCase(MessageStore messageStore) {
        this.messageStore = messageStore;
    }

    public void postMessage(Username username, Message message) {
        messageStore.addMessageForUser(username, message);
    }
}
