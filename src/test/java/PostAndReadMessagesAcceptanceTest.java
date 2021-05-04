import console.Parser;
import console.SocialNetworkApp;
import console.SocialNetworkConsole;
import console.SocialNetworkController;
import datastore.InMemoryMessageStore;
import domain.post_message.PostMessageUseCase;
import domain.read_messages.ReadMessagesUseCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PostAndReadMessagesAcceptanceTest {

    private SocialNetworkConsole console = mock(SocialNetworkConsole.class);
    private SocialNetworkController controller
            = new SocialNetworkController(new Parser(), new PostMessageUseCase(new InMemoryMessageStore()), new ReadMessagesUseCase(null));

    @Test
    void post_a_message_and_print_empty_output() {
        SocialNetworkApp app = new SocialNetworkApp(console, controller);
        when(console.read())
                .thenReturn("Alice -> I love the weather today")
                .thenReturn("");

        app.run();

        verify(console).write("");
    }

    @Test
    @Disabled
    void post_and_read_a_message() {
        SocialNetworkApp app = new SocialNetworkApp(console, controller);
        when(console.read())
                .thenReturn("Alice -> I love the weather today")
                .thenReturn("Alice")
                .thenReturn("");

        app.run();

        verify(console).write("");
        verify(console).write("I love the weather today");
    }
}
