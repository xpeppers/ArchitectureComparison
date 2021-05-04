package console;

import domain.post_message.PostMessageUseCase;
import domain.read_messages.ReadMessagesUseCase;

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
            readMessageUseCase.getMessagesOf(command.username());
        } else {
            postMessageUseCase.postMessage(command.username(), command.message());
        }
        return "";
    }
}
