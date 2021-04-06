package domain.read_messages;


import domain.entity.Messages;
import domain.entity.Username;

public class ReadMessagesUseCase {
    private MessageRetriever messageRetriever;

    public ReadMessagesUseCase(MessageRetriever messageRetriever) {
        this.messageRetriever = messageRetriever;
    }

    public Messages getMessagesBy(Username username) {
        return messageRetriever.getMessagesBy(username);
    }
}
