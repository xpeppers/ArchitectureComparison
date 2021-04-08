package domain.read_messages;


import domain.entity.Messages;
import domain.entity.User;

public class ReadMessagesUseCase {
    private final MessageRetriever messageRetriever;

    public ReadMessagesUseCase(MessageRetriever messageRetriever) {
        this.messageRetriever = messageRetriever;
    }

    public Messages getMessagesBy(User user) {
        return messageRetriever.getMessagesBy(user);
    }
}
