package datastore;

import domain.message.Message;
import domain.message.User;
import domain.post_message.MessageStore;

import java.util.HashMap;
import java.util.Map;

public class InMemoryMessageStore implements MessageStore {

    private final Map<User, Message> messages = new HashMap<>();

    @Override
    public void addMessageForUser(User user, Message message) {
        messages.put(user, message);
    }
}
