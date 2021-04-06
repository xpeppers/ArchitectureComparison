package domain.post_message;

import domain.entity.Message;
import domain.entity.User;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PostMessageUseCaseTest {

    private final MessageStore messageStore = mock(MessageStore.class);

    @Test
    void a_user_can_post_a_message() {
        PostMessageUseCase postMessage = new PostMessageUseCase(messageStore);
        User user = new User("Alice");
        Message message = new Message("I love the weather");

        postMessage.postMessage(user, message);

        verify(messageStore).addMessageForUser(user, message);
    }
}
