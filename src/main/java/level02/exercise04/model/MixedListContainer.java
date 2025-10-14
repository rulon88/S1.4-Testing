package level02.exercise04.model;

import java.util.ArrayList;
import java.util.List;

public class MixedListContainer {
    public List<Object> getMixedList() {
        List<Object> list = new ArrayList<>();
        list.add(new Book("Clean Code"));
        list.add(new Car("Tesla"));
        list.add(new Person("Emiliano"));
        return list;
    }
}
