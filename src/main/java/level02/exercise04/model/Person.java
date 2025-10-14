package level02.exercise04.model;

public class Person {
    private final String name;
    public Person(String name) { this.name = name; }
    @Override
    public String toString() { return name; }
}
