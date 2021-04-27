import console.SocialNetworkApp;
import console.SocialNetworkConsole;
import console.SocialNetworkController;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PostAndReadMessagesAcceptanceTest {

    private SocialNetworkConsole console = mock(SocialNetworkConsole.class);
    private SocialNetworkController controller = mock(SocialNetworkController.class);

    @Test
    void post_a_message_and_print_empty_output() {
        SocialNetworkApp app = new SocialNetworkApp(console, controller);
        when(console.read())
                .thenReturn("Alice -> I love the weather today")
                .thenReturn("");
        when(controller.accept("Alice -> I love the weather today")).thenReturn("");

        app.run();

        verify(console).write("");
    }

    @Test
    void post_and_read_a_message() {
        SocialNetworkApp app = new SocialNetworkApp(console, controller);
        when(console.read())
                .thenReturn("Alice -> I love the weather today")
                .thenReturn("Alice")
                .thenReturn("");
        when(controller.accept(any()))
                .thenReturn("")
                .thenReturn("I love the weather today");

        app.run();

        verify(console).write("");
        verify(console).write("I love the weather today");
    }
}
