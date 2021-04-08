package domain.post_message;

import domain.entity.Message;
import domain.entity.User;

public class PostMessageUseCase {
    private final MessageStore messageStore;

    public PostMessageUseCase(MessageStore messageStore) {
        this.messageStore = messageStore;
    }

    public void postMessage(String user, String message) {
        messageStore.addMessageForUser(new User(user), new Message(message));
    }
}
