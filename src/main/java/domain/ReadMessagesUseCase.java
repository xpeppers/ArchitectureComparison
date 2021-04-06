package domain;


public class ReadMessagesUseCase {
    private MessageRetriever messageRetriever;

    public ReadMessagesUseCase(MessageRetriever messageRetriever) {
        this.messageRetriever = messageRetriever;
    }

    public Messages getMessagesBy(Username username) {
        return messageRetriever.getMessagesBy(username);
    }
}
