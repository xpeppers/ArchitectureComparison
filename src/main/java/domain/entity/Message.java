package domain.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Message {
    private final String message;

    public Message(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(message).toHashCode();
    }
}
