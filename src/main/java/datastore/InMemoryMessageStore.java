package datastore;

import domain.message.Message;
import domain.message.Messages;
import domain.message.User;
import domain.post_message.MessageStore;
import domain.read_messages.MessageRetriever;

import java.util.HashMap;
import java.util.Map;

public class InMemoryMessageStore implements MessageStore, MessageRetriever {

    private final Map<User, Messages> messages = new HashMap<>();

    @Override
    public void addMessageForUser(User user, Message message) {
        Messages userMessages = messages.getOrDefault(user, new Messages());
        userMessages.add(message);
        messages.put(user, userMessages);
    }

    @Override
    public Messages getMessagesBy(User user) {
        return messages.getOrDefault(user, new Messages());
    }
}
