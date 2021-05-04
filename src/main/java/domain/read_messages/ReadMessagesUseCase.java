package domain.read_messages;

import domain.message.Messages;
import domain.message.User;

import java.util.List;

public class ReadMessagesUseCase {
    private final MessageRetriever messageRetriever;

    public ReadMessagesUseCase(MessageRetriever messageRetriever) {
        this.messageRetriever = messageRetriever;
    }

    public List<String> readMessagesOf(String username) {
        Messages messages = getMessagesOf(username);
        return messages.asString();
    }

    public Messages getMessagesOf(String username) {
        return messageRetriever.getMessagesBy(new User(username));
    }
}
