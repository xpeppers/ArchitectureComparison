package datastore;

import domain.message.Message;
import domain.message.Messages;
import domain.message.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InMemoryMessageStoreTest {
    @Test
    void store_and_get_user_messages() {
        InMemoryMessageStore messageStore = new InMemoryMessageStore();
        User user = new User("Bob");
        messageStore.addMessageForUser(user, new Message("hello"));

        Messages messages = messageStore.getMessagesBy(user);

        assertThat(messages.get(0)).isEqualTo(new Message("hello"));
    }
}