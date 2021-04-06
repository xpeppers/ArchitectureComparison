package domain.read_messages;

import domain.entity.Messages;
import domain.entity.Username;

public interface MessageRetriever {
    Messages getMessagesBy(Username username);
}
