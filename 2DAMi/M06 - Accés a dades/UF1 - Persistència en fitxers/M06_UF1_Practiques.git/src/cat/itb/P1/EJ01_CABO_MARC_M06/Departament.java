package cat.itb.P1.EJ01_CABO_MARC_M06;

import java.io.Serializable;

public class Departament implements Serializable {
    private int id;
    private String nom, localitat;

    public Departament(int id, String nom, String localitat) {
        this.id = id;
        this.nom = nom;
        this.localitat = localitat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalitat() {
        return localitat;
    }

    public void setLocalitat(String localitat) {
        this.localitat = localitat;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", localitat='" + localitat + '\'' +
                '}';
    }
}
