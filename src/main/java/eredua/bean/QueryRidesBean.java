package eredua.bean;



import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("queryRidesBean")
@ViewScoped
public class QueryRidesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BLFacade facadeBL = FacadeBean.getBusinessLogic();

    private List<String> departCities;
    private String selectedCity;
    private List<RideDTO> results = new ArrayList<>();

    public List<String> getDepartCities() {
        if (departCities == null) {
            departCities = facadeBL.getDepartCities();
        }
        return departCities;
    }

    public String getSelectedCity() { return selectedCity; }
    public void setSelectedCity(String selectedCity) { this.selectedCity = selectedCity; }

    public List<RideDTO> getResults() { return results; }

    public String search() {
        // Llamada real: facadeBL.queryRides(...)
        results.clear();
        if (selectedCity != null && !selectedCity.isEmpty()) {
            for (int i = 1; i <= 3; i++) {
                results.add(new RideDTO(i, selectedCity, "Destino " + i));
            }
        }
        return null;
    }

    public static class RideDTO {
        public int id;
        public String depart;
        public String destination;
        public RideDTO(int id, String depart, String destination) {
            this.id = id;
            this.depart = depart;
            this.destination = destination;
        }
        public int getId() { return id; }
        public String getDepart() { return depart; }
        public String getDestination() { return destination; }
    }
}
