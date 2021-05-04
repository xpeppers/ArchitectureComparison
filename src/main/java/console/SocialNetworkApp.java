package console;

import datastore.InMemoryMessageStore;
import domain.post_message.PostMessageUseCase;
import domain.read_messages.ReadMessagesUseCase;

public class SocialNetworkApp {
    public static final String NULL_COMMAND = "";
    private SocialNetworkConsole console;
    private SocialNetworkController controller;

    private SocialNetworkApp(SocialNetworkConsole console, SocialNetworkController controller) {
        this.console = console;
        this.controller = controller;
    }

    public static SocialNetworkApp main(SocialNetworkConsole console) {
        Parser parser = new Parser();
        InMemoryMessageStore messageStore = new InMemoryMessageStore();
        PostMessageUseCase postMessageUseCase = new PostMessageUseCase(messageStore);
        ReadMessagesUseCase readMessageUseCase = new ReadMessagesUseCase(messageStore);
        SocialNetworkController controller = new SocialNetworkController(parser, postMessageUseCase, readMessageUseCase);

        return new SocialNetworkApp(console, controller);
    }

    public void run() {
        while (true) {
            String string = console.read();
            if (NULL_COMMAND.equals(string)) return;

            String output = controller.accept(string);
            console.write(output);
        }
    }
}
