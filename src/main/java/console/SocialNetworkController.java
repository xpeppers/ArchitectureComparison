package console;

import domain.post_message.PostMessageUseCase;
import domain.read_messages.ReadMessagesUseCase;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static java.lang.String.join;

public class SocialNetworkController {
    private Parser parser;
    private PostMessageUseCase postMessageUseCase;
    private ReadMessagesUseCase readMessageUseCase;

    public SocialNetworkController(Parser parser, PostMessageUseCase postMessageUseCase, ReadMessagesUseCase readMessageUseCase) {
        this.parser = parser;
        this.postMessageUseCase = postMessageUseCase;
        this.readMessageUseCase = readMessageUseCase;
    }

    public String accept(String string) {
        Command command = parser.parse(string);
        if (command.message() == null) {
            List<String> strings = readMessageUseCase.readMessagesOf(command.username());
            return join("\n", strings);
        } else {
            postMessageUseCase.postMessage(command.username(), command.message());
        }
        return "";
    }
}
