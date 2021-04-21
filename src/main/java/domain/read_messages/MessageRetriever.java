package domain.read_messages;

import domain.message.Messages;
import domain.message.User;

public interface MessageRetriever {
    Messages getMessagesBy(User user);
}
