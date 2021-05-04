import console.SocialNetworkApp;
import console.SocialNetworkConsole;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PostAndReadMessagesAcceptanceTest {

    private SocialNetworkConsole console = mock(SocialNetworkConsole.class);

    @Test
    void post_a_message_and_print_empty_output() {
        SocialNetworkApp app = SocialNetworkApp.main(console);
        when(console.readLine())
                .thenReturn("Alice -> I love the weather today")
                .thenReturn("");

        app.run();

        verify(console).writeLine("");
    }

    @Test
    void post_and_read_a_message() {
        SocialNetworkApp app = SocialNetworkApp.main(console);
        when(console.readLine())
                .thenReturn("Alice -> I love the weather today")
                .thenReturn("Alice")
                .thenReturn("");

        app.run();

        verify(console).writeLine("");
        verify(console).writeLine("I love the weather today");
    }
}
