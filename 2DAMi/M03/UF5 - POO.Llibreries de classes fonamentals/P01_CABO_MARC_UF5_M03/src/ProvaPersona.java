import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProvaPersona {
    public static void main(String[] args) {
        ArrayList<Persona> llista = new ArrayList<Persona>();

        // REGISTRE 5 PERSONES
        llista.add(new Persona("Marc", 22));
        llista.add(new Persona("David", 19));
        llista.add(new Persona("Marta", 20));
        llista.add(new Persona("Dani", 24));
        llista.add(new Persona("Laura", 18));

        System.out.println("\nMOSTRAR 5 PERSONES");
        llista.forEach(System.out::println);

        System.out.println("\nORDENACIÓ PER NOM - CLASE ComparatorPerNom");
        llista.sort(new ComparatorPerNom());
        llista.forEach(System.out::println);

        System.out.println("\nORDENACIÓ PER EDAT - CLASE ComparatorPerEdat");
        llista.sort(new ComparatorPerEdat());
        llista.forEach(System.out::println);

        System.out.println("\nORDENACIÓ PER NOM - Clase Interna");
        Collections.sort(llista, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getNom().compareTo(p2.getNom());
            }
        });
        llista.forEach(System.out::println);

        System.out.println("\nORDENACIÓ PER EDAT - Clase Interna");
        Collections.sort(llista, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return p1.getEdat() - (p2.getEdat());
            }
        });
        llista.forEach(System.out::println);

        System.out.println("\nORDENACIÓ PER NOM - LAMBDA");
        llista.sort((p1,p2)->p1.getNom().compareTo(p2.getNom()));
        llista.forEach(System.out::println);

        System.out.println("\nORDENACIÓ PER EDAT - LAMBDA");
        llista.sort((p1,p2)->p1.getEdat()-(p2.getEdat()));
        llista.forEach(System.out::println);

        System.out.println("\nORDENACIÓ PER NOM - EJERCICI 2 REFERENCIA MÉTODE");
        llista.sort(Persona::comparaPerNom);
        llista.forEach(System.out::println);

    }
}
