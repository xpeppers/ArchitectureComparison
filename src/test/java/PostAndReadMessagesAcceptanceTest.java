import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class PostAndReadMessagesAcceptanceTest {

    private SocialNetworkConsole console = mock(SocialNetworkConsole.class);
    private SocialNetworkInterpreter interpreter = mock(SocialNetworkInterpreter.class);

    @Test
    void post_a_message_and_print_empty_output() {
        SocialNetworkApp app = new SocialNetworkApp(console, interpreter);
        when(console.read())
                .thenReturn("Alice -> I love the weather today")
                .thenReturn("");
        when(interpreter.accept("Alice -> I love the weather today")).thenReturn("");

        app.run();

        verify(console).write("");
    }

    @Test
    void post_and_read_a_message() {
        SocialNetworkApp app = new SocialNetworkApp(console, interpreter);
        when(console.read())
                .thenReturn("Alice -> I love the weather today")
                .thenReturn("Alice")
                .thenReturn("");
        when(interpreter.accept("Alice -> I love the weather today")).thenReturn("");
        when(interpreter.accept("Alice")).thenReturn("I love the weather today");

        app.run();

        verify(console).write("");
        verify(console).write("I love the weather today");
        verify(console).write("");
    }
}
