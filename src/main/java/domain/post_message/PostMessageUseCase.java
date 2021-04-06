package domain.post_message;

import domain.entity.Message;
import domain.entity.User;

public class PostMessageUseCase {
    private MessageStore messageStore;

    public PostMessageUseCase(MessageStore messageStore) {
        this.messageStore = messageStore;
    }

    public void postMessage(User user, Message message) {
        messageStore.addMessageForUser(user, message);
    }
}
