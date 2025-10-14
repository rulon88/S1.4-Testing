package level02.exercise05.model;

import java.util.HashMap;
import java.util.Map;

public class CountryMapContainer {
    public Map<String, String> getCountryMap() {
        Map<String, String> countries = new HashMap<>();
        countries.put("ES", "Spain");
        countries.put("FR", "France");
        countries.put("DE", "Germany");
        return countries;
    }
}
