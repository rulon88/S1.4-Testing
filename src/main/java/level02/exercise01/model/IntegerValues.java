package level02.exercise01.model;

public class IntegerValues {
    public boolean areEqual(Integer a, Integer b) {
        if (a == null || b == null) return false;
        return a.equals(b);
    }
    public boolean areNotEqual(Integer a, Integer b) {
        if (a == null || b == null) return true;
        return !a.equals(b);
    }
}