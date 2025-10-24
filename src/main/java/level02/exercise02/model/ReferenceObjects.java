package level02.exercise02.model;

import java.util.Objects;

public class ReferenceObjects {

    private final String name;
    private final int age;

    public ReferenceObjects(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != ReferenceObjects.class) return false;
        ReferenceObjects that = (ReferenceObjects) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
