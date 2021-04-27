package console;

import domain.post_message.PostMessageUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class SocialNetworkControllerTest {

    @Test
    void when_string_contains_username_and_text_invokes_post_message_use_case() {
        PostMessageUseCase postMessageUseCase = mock(PostMessageUseCase.class);
        Parser parser = mock(Parser.class);
        String string = "Alice -> I love the weather today";

        when(parser.parse(string)).thenReturn(new Command("Alice", "I love the weather today"));

        SocialNetworkController controller = new SocialNetworkController(parser, postMessageUseCase);

        controller.accept(string);

        verify(postMessageUseCase).postMessage("Alice", "I love the weather today");
    }

    @Test
    void when_string_contains_only_username_invokes_read_messages_use_case() {
        fail("not implemented");
    }
}