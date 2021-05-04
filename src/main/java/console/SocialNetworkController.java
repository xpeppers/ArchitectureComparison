package console;

import domain.post_message.PostMessageUseCase;
import domain.read_messages.ReadMessagesUseCase;

import java.util.List;

import static java.lang.String.join;

public class SocialNetworkController {
    private final Parser parser;
    private final PostMessageUseCase postMessageUseCase;
    private final ReadMessagesUseCase readMessageUseCase;

    public SocialNetworkController(Parser parser, PostMessageUseCase postMessageUseCase, ReadMessagesUseCase readMessageUseCase) {
        this.parser = parser;
        this.postMessageUseCase = postMessageUseCase;
        this.readMessageUseCase = readMessageUseCase;
    }

    public String accept(String string) {
        Command command = parser.parse(string);
        if (command.message() == null) {
            List<String> messages = readMessageUseCase.readMessagesOf(command.username());
            return join("\n", messages);
        } else {
            postMessageUseCase.postMessage(command.username(), command.message());
        }
        return "";
    }
}
