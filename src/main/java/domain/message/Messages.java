package domain.message;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Messages {

    private final List<Message> messageList = new ArrayList<>();

    public void add(Message message) {
        messageList.add(message);
    }

    public Message get(int index) {
        return messageList.get(index);
    }

    public List<String> asString() {
        return messageList.stream().map(Message::asString).collect(Collectors.toList());
    }
}
