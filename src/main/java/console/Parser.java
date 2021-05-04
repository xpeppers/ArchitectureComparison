package console;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Parser {
    public Command parse(String string) {
        List<String> tokens = stream(string.split("->"))
                .filter(Objects::nonNull)
                .map(String::trim)
                .collect(toList());
        String username = tokens.get(0);
        String message = tokens.size() == 2 ? tokens.get(1) : null;
        return new Command(username, message);
    }
}
