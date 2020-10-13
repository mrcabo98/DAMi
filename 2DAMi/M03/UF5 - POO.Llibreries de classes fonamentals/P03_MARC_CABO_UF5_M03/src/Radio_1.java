import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Radio_1 implements Iterable<Emisora> {
    private List<Emisora> emisora1 = new ArrayList<Emisora>();

    public void afegirEmisora(Emisora e1) {
        emisora1.add(e1);
    }

    @Override
    public Iterator<Emisora> iterator() {
        return emisora1.iterator();
    }
}
