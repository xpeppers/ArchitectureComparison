package domain.post_message;

import domain.message.Message;
import domain.message.User;

public interface MessageStore {
    void addMessageForUser(User user, Message message);
}
