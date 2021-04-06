package domain;

public class PostMessageUseCase {
    private MessageRepository messageRepository;

    public PostMessageUseCase(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void postMessage(Username username, Message message) {
        messageRepository.addMessageForUser(username, message);
    }
}
