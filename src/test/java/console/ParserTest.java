package console;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {

    @Test
    void parse_a_post_message() {
        Command command = new Parser().parse("Alice -> Hi all!");

        assertThat(command.username()).isEqualTo("Alice");
        assertThat(command.message()).isEqualTo("Hi all!");
    }

    @Test
    void parse_a_read_message() {
        Command command = new Parser().parse("Bob");

        assertThat(command.username()).isEqualTo("Bob");
        assertThat(command.message()).isNull();
    }
}