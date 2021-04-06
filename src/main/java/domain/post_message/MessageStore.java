package domain.post_message;

import domain.entity.Message;
import domain.entity.Username;

public interface MessageStore {
    void addMessageForUser(Username username, Message message);
}
