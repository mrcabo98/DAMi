import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Radio_2 implements Iterable<Emisora> {
    private List<Emisora> emisora2 = new ArrayList<Emisora>();

    public void afegirEmisora(Emisora e2) {
        emisora2.add(e2);
    }

    @Override
    public Iterator<Emisora> iterator() {
        return new IteradorClassica(emisora2);
    }

}

class IteradorClassica implements Iterator<Emisora> {
    private List<Emisora> emisora2;
    private int actual = 0;

    public IteradorClassica(List<Emisora> e) {
        emisora2 = e;
    }

    @Override
    public boolean hasNext() {
        boolean classica = false;
        int i = actual;
        while (i < emisora2.size() && !classica) {
            if (emisora2.get(i).getEspecialitat().equalsIgnoreCase("Clàssica")) {
                classica = true;
            } else {
                i++;
            }
        }
        return classica;
    }

    @Override
    public Emisora next() {
        Emisora e=emisora2.get(actual++);
        while (!e.getEspecialitat().equalsIgnoreCase("Clàssica")) {
            e=emisora2.get(actual++);
        }
        return e;
    }
}
