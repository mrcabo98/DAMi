public class Producte {
    private String descripcio;
    private Double preu;
    private int codi;
    private boolean disponible;

    public Producte(String descripcio, Double preu, int codi, boolean disponible) {
        this.descripcio = descripcio;
        this.preu = preu;
        this.codi = codi;
        this.disponible = disponible;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Double getPreu() {
        return preu;
    }

    public void setPreu(Double preu) {
        this.preu = preu;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public static int ComparatorPerPreuDisponibilitatAsc (Producte p1, Producte p2) {
        int aux;
        aux = Double.compare(p1.getPreu(), p2.getPreu());
        if (aux == 0) aux = Boolean.compare(p1.getDisponible(), p2.getDisponible());
        return aux;
    }

    public static int ComparatorPerPreuDisponibilitatDesc (Producte p1, Producte p2) {
        int aux;
        aux = Double.compare(p2.getPreu(), p1.getPreu());
        if (aux == 0) aux = Boolean.compare(p2.getDisponible(), p1.getDisponible());
        return aux;
    }

    @Override
    public String toString() {
        String aux;
        if (getDisponible()) {
            aux = "Està disponible";
        } else {
            aux = "No está disponible";
        }
        return "Producte{" +
                "descripcio='" + descripcio + '\'' +
                ", preu=" + preu +
                ", codi=" + codi +
                ", disponible=" + aux +
                '}';
    }
}
