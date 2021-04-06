package domain;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PostMessageUseCaseTest {

    private final MessageRepository messageRepository = mock(MessageRepository.class);

    @Test
    void a_user_can_post_a_message() {
        PostMessageUseCase postMessage = new PostMessageUseCase(messageRepository);
        Username username = new Username("Alice");
        Message message = new Message("I love the weather");

        postMessage.postMessage(username, message);

        verify(messageRepository).addMessageForUser(username, message);
    }
}
