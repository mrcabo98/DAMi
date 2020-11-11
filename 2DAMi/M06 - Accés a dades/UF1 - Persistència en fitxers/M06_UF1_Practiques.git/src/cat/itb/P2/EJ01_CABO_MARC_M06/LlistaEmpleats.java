package cat.itb.P2.EJ01_CABO_MARC_M06;

import cat.itb.P1.EJ01_CABO_MARC_M06.Empleat;

import java.util.ArrayList;

public class LlistaEmpleats {
    ArrayList<Empleat> llista = new ArrayList<>();

    public LlistaEmpleats() {
    }

    public void add(Empleat emp) {
        llista.add(emp);
    }

    public ArrayList<Empleat> getLlista() {
        return llista;
    }
}
