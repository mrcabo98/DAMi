package cat.itb.P1.EJ01_CABO_MARC_M06;

import java.io.Serializable;

public class Empleat implements Serializable {
    private int id, departament;
    private String cognom;
    private Double salari;

    public Empleat(int id, int departament, String cognom, Double salari) {
        this.id = id;
        this.departament = departament;
        this.cognom = cognom;
        this.salari = salari;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartament() {
        return departament;
    }

    public void setDepartament(int departament) {
        this.departament = departament;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public Double getSalari() {
        return salari;
    }

    public void setSalari(Double salari) {
        this.salari = salari;
    }

    @Override
    public String toString() {
        return "Empleat{" +
                "id=" + id +
                ", departament=" + departament +
                ", cognom='" + cognom + '\'' +
                ", salari=" + salari +
                '}';
    }
}
