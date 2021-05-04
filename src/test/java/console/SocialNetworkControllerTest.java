package console;

import domain.post_message.PostMessageUseCase;
import domain.read_messages.ReadMessagesUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SocialNetworkControllerTest {
    Parser parser = mock(Parser.class);
    ReadMessagesUseCase readMessageUseCase = mock(ReadMessagesUseCase.class);
    PostMessageUseCase postMessageUseCase = mock(PostMessageUseCase.class);

    private SocialNetworkController controller;

    @BeforeEach
    void setUp() {
        controller = new SocialNetworkController(parser, postMessageUseCase, readMessageUseCase);
    }

    @Test
    void when_string_contains_username_and_text_invokes_post_message_use_case() {
        String inputString = "Alice -> I love the weather today";
        when(parser.parse(inputString)).thenReturn(new Command("Alice", "I love the weather today"));

        controller.accept(inputString);

        verify(postMessageUseCase).postMessage("Alice", "I love the weather today");
    }

    @Test
    void when_string_contains_only_username_invokes_read_messages_use_case() {
        String inputString = "Bob";
        when(parser.parse(inputString)).thenReturn(new Command("Bob"));

        controller.accept(inputString);

        verify(readMessageUseCase).getMessagesOf("Bob");
    }
}