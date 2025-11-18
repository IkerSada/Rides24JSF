package eredua.bean;


import java.util.ArrayList;
import java.util.List;

public class MockBLFacade implements BLFacade {

    @Override
    public List<String> getDepartCities() {
        List<String> l = new ArrayList<>();
        l.add("Bilbao");
        l.add("Donostia");
        l.add("Gasteiz");
        l.add("Irun");
        return l;
    }

    // stubs para otros métodos...
}
