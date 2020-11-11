package cat.itb.P2.EJ01_CABO_MARC_M06;

import cat.itb.P1.EJ01_CABO_MARC_M06.Departament;

import java.util.ArrayList;

public class LlistaDepartaments {
    ArrayList<Departament> llista = new ArrayList<>();

    public LlistaDepartaments() {
    }

    public void add(Departament dep) {
        llista.add(dep);
    }

    public ArrayList<Departament> getLlista() {
        return llista;
    }
}
