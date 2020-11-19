import java.time.Duration;
import java.time.LocalTime;

public class Bici_A extends Thread {
    private String nom;
    private LocalTime inici;
    private int distancia;
    private long temps;

    public Bici_A(String nom, LocalTime inici, int distancia) {
        this.nom = nom;
        this.inici = inici;
        this.distancia = distancia;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalTime getInici() {
        return inici;
    }

    public void setInici(LocalTime inici) {
        this.inici = inici;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public long getTemps() {
        return temps;
    }

    public void setTemps(long temps) {
        this.temps = temps;
    }

    @Override
    public void run() {
        LocalTime acabat;
        for (int i = 0; i < distancia; i++) {

        }
        acabat = LocalTime.now();
        this.temps = Duration.between(inici, acabat).getNano();
    }

    @Override
    public String toString() {
        return "La bici de " + nom + " ha trigat " + temps + " en recorrer una distancia de " + distancia;
    }
}
