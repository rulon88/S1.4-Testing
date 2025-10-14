package level02.exercise07.assertions;

import java.util.Optional;

public class OptionalProvider {
    public Optional<String> getEmptyOptional() {
        return Optional.empty();
    }

    public Optional<String> getNonEmptyOptional() {
        return Optional.of("Emiliano");
    }
}
