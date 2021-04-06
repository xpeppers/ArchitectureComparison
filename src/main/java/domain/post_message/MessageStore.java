package domain.post_message;

import domain.entity.Message;
import domain.entity.User;

public interface MessageStore {
    void addMessageForUser(User user, Message message);
}
