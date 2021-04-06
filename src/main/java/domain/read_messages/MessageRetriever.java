package domain.read_messages;

import domain.entity.Messages;
import domain.entity.User;

public interface MessageRetriever {
    Messages getMessagesBy(User user);
}
