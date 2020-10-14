import java.util.ArrayList;
import java.util.List;

public class ProvaCamisa {
    public static void main(String[] args) {
        ArrayList<Camisa> llista = new ArrayList<Camisa>();
        llista.add(new Camisa("BALR", "M", "Vermell"));
        llista.add(new Camisa("Lacoste", "XL", "BLanc"));
        llista.add(new Camisa("Armani Legacy", "S", "Blau"));
        llista.add(new Camisa("Gucci", "XL", "Negre"));
        llista.add(new Camisa("Ralph Lauren", "M", "Blau"));

        System.out.println();

        // EJERCICI A - CAMISES DE TALLA "XL"
        printCaracteristica(llista, e -> e.getTalla().equals("M"));

        System.out.println();

        // EJERCICI B - CAMISES DE COLOR "VERMELL"
        printCaracteristica(llista, (e -> e.getColor().equals("Vermell")));

        System.out.println();

        // EJERCICI C -CAMISES DE TALLA "M" I COLOR "BLAU"
        printCaracteristica(llista, e -> e.getTalla().equals("M") && e.getColor().equals("Blau"));


    }

    private static void printCaracteristica(List<Camisa> llista, CamisaSeleccionable c) {
        for (Camisa e : llista) {
            if (c.test(e)) {
                System.out.println(e);
            }
        }
    }
}

@FunctionalInterface
interface CamisaSeleccionable {
    boolean test(Camisa e);
}
