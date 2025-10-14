package level01.exercise01.model;


public class Validator {

    private Validator() { }

    public static void validateNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty())
            throw new IllegalArgumentException(fieldName + " cannot be empty");
    }

    public static void validateNotNull(Object obj, String fieldName) {
        if (obj == null)
            throw new IllegalArgumentException(fieldName + " cannot be null");
    }
}
