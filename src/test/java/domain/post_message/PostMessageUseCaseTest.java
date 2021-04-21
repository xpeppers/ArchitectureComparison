package domain.post_message;

import domain.message.Message;
import domain.message.User;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PostMessageUseCaseTest {

    private final MessageStore messageStore = mock(MessageStore.class);

    @Test
    void a_user_can_post_a_message() {
        PostMessageUseCase postMessage = new PostMessageUseCase(messageStore);

        postMessage.postMessage("Alice", "I love the weather");

        verify(messageStore).addMessageForUser(new User("Alice"), new Message("I love the weather"));
    }
}
