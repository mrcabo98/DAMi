public class Persona {
    private String nom;
    private int Edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        Edat = edat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return Edat;
    }

    public void setEdat(int edat) {
        Edat = edat;
    }

    public static int comparaPerNom (Persona p1, Persona p2) {
        return p1.getNom().compareTo(p2.getNom());
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nom='" + nom + '\'' +
                ", Edat=" + Edat +
                '}';
    }
}
