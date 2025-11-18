package eredua.bean;

import java.io.Serializable;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("createRideBean")  // Cambiado a un nombre más apropiado
@SessionScoped
public class CreateRideBean implements Serializable {
    private String izena;
    private String pasahitza;
    
    public CreateRideBean() {
    }
    
    // Getters y Setters (mantener igual)
    public String getIzena() {
        return izena;
    }
    
    public void setIzena(String izena) {
        this.izena = izena;
    }
    
    public String getPasahitza() {
        return pasahitza;
    }
    
    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }
    
    public String egiaztatu() {
        if (izena.equals("pirata")) return "error";
        else return "ok";
    }
}