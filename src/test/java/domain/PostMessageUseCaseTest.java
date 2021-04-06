package domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class PostMessageUseCaseTest {

    @Test
    void a_user_can_post_a_message() {
        MessageRepository messageRepository = Mockito.mock(MessageRepository.class);
        PostMessageUseCase postMessage = new PostMessageUseCase(messageRepository);
        Username username = new Username("Alice");
        Message message = new Message("I love the weather");
        postMessage.postMessage(username, message);

        verify(messageRepository).addMessageForUser(username, message);
    }
}
