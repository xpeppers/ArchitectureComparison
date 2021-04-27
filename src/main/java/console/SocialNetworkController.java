package console;

import domain.post_message.PostMessageUseCase;

public class SocialNetworkController {
    private Parser parser;
    private PostMessageUseCase postMessageUseCase;

    public SocialNetworkController(Parser parser, PostMessageUseCase postMessageUseCase) {
        this.parser = parser;
        this.postMessageUseCase = postMessageUseCase;
    }

    public String accept(String string) {
        Command command = parser.parse(string);
        postMessageUseCase.postMessage(command.username(), command.message());
        return "";
    }
}
