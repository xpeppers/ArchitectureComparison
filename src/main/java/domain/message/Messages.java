package domain.message;

import java.util.ArrayList;
import java.util.List;

public class Messages {

    private final List<Message> messageList = new ArrayList<>();

    public void add(Message message) {
        messageList.add(message);
    }

    public Message get(int index) {
        return messageList.get(index);
    }
}
