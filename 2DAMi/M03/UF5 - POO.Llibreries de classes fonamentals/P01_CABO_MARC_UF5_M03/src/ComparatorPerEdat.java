import java.util.Comparator;

public class ComparatorPerEdat implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getEdat() - p2.getEdat();
    }
}
