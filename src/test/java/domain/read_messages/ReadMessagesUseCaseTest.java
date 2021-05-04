package domain.read_messages;

import domain.message.Message;
import domain.message.Messages;
import domain.message.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReadMessagesUseCaseTest {

    private final MessageRetriever messageRetriever = mock(MessageRetriever.class);

    @Test
    void get_all_messages_posted_by_a_user() {
        ReadMessagesUseCase useCase = new ReadMessagesUseCase(messageRetriever);
        Messages messages = new Messages();
        messages.add(new Message("hi!"));
        messages.add(new Message("what?!"));

        when(messageRetriever.getMessagesBy(new User("Alice"))).thenReturn(messages);

        List<String> actualMessages = useCase.readMessagesOf("Alice");

        assertThat(actualMessages).isEqualTo(asList("hi!", "what?!"));
    }
}
