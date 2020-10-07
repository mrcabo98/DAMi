import java.util.Comparator;

public class ComparatorPerNom implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getNom().compareTo(p2.getNom());
    }
}
