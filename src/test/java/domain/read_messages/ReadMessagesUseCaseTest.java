package domain.read_messages;

import domain.entity.Messages;
import domain.entity.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReadMessagesUseCaseTest {

    private final MessageRetriever messageRetriever = mock(MessageRetriever.class);

    @Test
    void get_all_messages_posted_by_a_user() {
        ReadMessagesUseCase useCase = new ReadMessagesUseCase(messageRetriever);
        Messages messages = new Messages();

        when(messageRetriever.getMessagesBy(new User("Alice"))).thenReturn(messages);

        Messages actualMessages = useCase.getMessagesBy("Alice");

        assertThat(actualMessages).isEqualTo(messages);
    }
}