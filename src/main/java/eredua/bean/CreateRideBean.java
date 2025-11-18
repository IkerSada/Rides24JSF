package eredua.bean;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;


import java.io.Serializable;

@Named("createRideBean")
@ViewScoped
public class CreateRideBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BLFacade facadeBL = FacadeBean.getBusinessLogic();

    private String depart;
    private String destination;
    private String date;

    public String getDepart() { return depart; }
    public void setDepart(String depart) { this.depart = depart; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String create() {
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            // Llamada real: facadeBL.createRide(...)
            fc.addMessage(null, new FacesMessage("Viaje creado con éxito: " + depart + " -> " + destination));
            depart = destination = date = null;
            return "QueryRides.xhtml?faces-redirect=true";
        } catch (Exception e) {
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error creando viaje", e.getMessage()));
            return null;
        }
    }
}
