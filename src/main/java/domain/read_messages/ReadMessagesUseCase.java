package domain.read_messages;

import domain.entity.Messages;
import domain.entity.User;

public class ReadMessagesUseCase {
    private final MessageRetriever messageRetriever;

    public ReadMessagesUseCase(MessageRetriever messageRetriever) {
        this.messageRetriever = messageRetriever;
    }

    public Messages getMessagesOf(String username) {
        return messageRetriever.getMessagesBy(new User(username));
    }
}
