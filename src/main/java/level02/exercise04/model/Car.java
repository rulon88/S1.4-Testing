package level02.exercise04.model;

public class Car {
    private final String model;
    public Car(String model) { this.model = model; }
    @Override
    public String toString() { return model; }
}
