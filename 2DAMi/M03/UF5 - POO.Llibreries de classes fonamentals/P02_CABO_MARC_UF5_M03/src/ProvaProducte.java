import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProvaProducte {
    public static void main(String[] args) {
        ArrayList<Producte> llista = new ArrayList<Producte>();

        // CLASE AUXILIAR ASC ComparatorPerPreu
        class ComparatorPerPreuAsc implements Comparator<Producte> {
            @Override
            public int compare(Producte p1, Producte p2) {
                return (int) (p1.getPreu() - p2.getPreu());
            }
        }

        // CLASE AUXILIAR DESC ComparatorPerPreu
        class ComparatorPerPreuDesc implements Comparator<Producte> {
            @Override
            public int compare(Producte p1, Producte p2) {
                return (int) (p2.getPreu() - p1.getPreu());
            }
        }

        // CLASE AUXILIAR ASC ComparatorPerDisponbilitat
        class ComparatorPerDisponibilitatAsc implements Comparator<Producte> {
            @Override
            public int compare(Producte p1, Producte p2) {
                return Boolean.compare(p1.getDisponible(), p2.getDisponible());
            }
        }

        // CLASE AUXILIAR DESC ComparatorPerDisponbilitat
        class ComparatorPerDisponibilitatDesc implements Comparator<Producte> {
            @Override
            public int compare(Producte p1, Producte p2) {
                return Boolean.compare(p2.getDisponible(), p1.getDisponible());
            }
        }

        // CLASE AUXILIAR ASC ComparatorPerPreuDisponibilitat
        class ComparatorPerPreuDisponibilitatAsc implements Comparator<Producte> {
            @Override
            public int compare(Producte p1, Producte p2) {
                int aux;
                aux = Double.compare(p1.getPreu(), p2.getPreu());
                if (aux == 0) aux = Boolean.compare(p1.getDisponible(), p2.getDisponible());
                return aux;
            }
        }

        // CLASE AUXILIAR DESC ComparatorPerPreuDisponibilitat
        class ComparatorPerPreuDisponibilitatDesc implements Comparator<Producte> {
            @Override
            public int compare(Producte p1, Producte p2) {
                int aux;
                aux = Double.compare(p2.getPreu(), p1.getPreu());
                if (aux == 0) aux = Boolean.compare(p2.getDisponible(), p1.getDisponible());
                return aux;
            }
        }

        // APARTAT A - REGISTRE 5 PRODUCTES
        llista.add(new Producte("Ordinador", 500.0, 100, true));
        llista.add(new Producte("Ratolí", 20.0, 101, false));
        llista.add(new Producte("Cable USB", 20.0, 102, true));
        llista.add(new Producte("Monitor", 120.0, 103, true));
        llista.add(new Producte("Teclat", 25.0, 104, false));
        llista.add(new Producte("Auriculars", 20.0, 105, true));

        // APARTAT B - ASCENDENT ORDENAT PER PREU
        llista.sort(new ComparatorPerPreuAsc());
        System.out.println("\n** ORDENACIÓ PER PREU ASCENDENT **");
        llista.forEach(System.out::println);

        // APARTAT B - DESCENDENT ORDENAT PER PREU
        llista.sort(new ComparatorPerPreuDesc());
        System.out.println("\n** ORDENACIÓ PER PREU DESCENDENT **");
        llista.forEach(System.out::println);

        // APARTART C - ASCENDENT ORDENAT PER DISPONIBILIAT
        llista.sort(new ComparatorPerDisponibilitatAsc());
        System.out.println("\n** ORDENACIÓ PER DISPONIBILITAT ASCENDENT **");
        llista.forEach(System.out::println);

        // APARTAT C - DESCENDENT ORDENAR PER DISPONIBILITAT
        llista.sort(new ComparatorPerDisponibilitatDesc());
        System.out.println("\n** ORDENACIÓ PER DISPONIBILITAT DESCENDENT **");
        llista.forEach(System.out::println);

        // APARTAT D - ASCENDENT ORDENAR PER PREU/DISPONIBILITAT
        llista.sort(new ComparatorPerPreuDisponibilitatAsc());
        System.out.println("\n** ORDENACIÓ PER PREU/DISPONIBILITAT ASCENDENT **");
        llista.forEach(System.out::println);

        // APARTAT D - DESCENDENT ORDENAR PER PREU/DISPONIBILITAT
        llista.sort(new ComparatorPerPreuDisponibilitatDesc());
        System.out.println("\n** ORDENACIÓ PER PREU/DISPONIBILITAT DESCENDENT **");
        llista.forEach(System.out::println);

        // APARTAT E - ASCENDENT ORDENAR PER PREU (CLASSE INTERNA ANÓNIMA)
        System.out.println("\n** ORDENACIÓ PER PREU (CLASSE INTERNA ANÓNIMA) ASCENDENT **");
        Collections.sort(llista, new Comparator<Producte>() {
            @Override
            public int compare(Producte p1, Producte p2) {
                return (int) (p1.getPreu() - p2.getPreu());
            }
        });
        llista.forEach(System.out::println);

        // APARTAT E - DESCENDENT ORDENAR PER PREU (CLASSE INTERNA ANÓNIMA)
        System.out.println("\n** ORDENACIÓ PER PREU (CLASSE INTERNA ANÓNIMA) DESCENDENT **");
        Collections.sort(llista, new Comparator<Producte>() {
            @Override
            public int compare(Producte p1, Producte p2) {
                return (int) (p2.getPreu() - p1.getPreu());
            }
        });
        llista.forEach(System.out::println);

        // APARTAT F - ASCENDENT ORDENAR PER DISPONIBILITAT (CLASSE INTERNA ANÓNIMA)
        System.out.println("\n** ORDENACIÓ PER DISPONIBILITAT (CLASSE INTERNA ANÓNIMA) ASCENDENT **");
        Collections.sort(llista, new Comparator<Producte>() {
            @Override
            public int compare(Producte p1, Producte p2) {
                return Boolean.compare(p1.getDisponible(), p2.getDisponible());
            }
        });
        llista.forEach(System.out::println);

        // APARTAT F - DESCEDENT ORDENAR PER DISPONIBILITAT (CLASSE INTERNA ANÓNIMA)
        System.out.println("\n** ORDENACIÓ PER DISPONIBILITAT (CLASSE INTERNA ANÓNIMA) DESCENDENT **");
        Collections.sort(llista, new Comparator<Producte>() {
            @Override
            public int compare(Producte p1, Producte p2) {
                return Boolean.compare(p2.getDisponible(), p1.getDisponible());
            }
        });
        llista.forEach(System.out::println);

        // APARTAT G - ASCENDENT ORDENAR PER PREU/DISPONIBILITAT (CLASSE INTERNA ANÓNIMA)
        System.out.println("\n** ORDENACIÓ PER PREU/DISPONIBILITAT (CLASSE INTERNA ANÓNIMA) ASCENDENT");
        Collections.sort(llista, new Comparator<Producte>() {
            @Override
            public int compare(Producte p1, Producte p2) {
                int aux;
                aux = Double.compare(p1.getPreu(), p2.getPreu());
                if (aux == 0) aux = Boolean.compare(p1.getDisponible(), p2.getDisponible());
                return aux;
            }
        });
        llista.forEach(System.out::println);

        // APARTAT G -  DESCENDENT ORDENAR PER PREU/DISPONIBILITAT (CLASSE INTERNA ANÓNIMA)
        System.out.println("\n** ORDENACIÓ PER PREU/DISPONIBILITAT (CLASSE INTERNA ANÓNIMA) DESCENDENT");
        Collections.sort(llista, new Comparator<Producte>() {
            @Override
            public int compare(Producte p1, Producte p2) {
                int aux;
                aux = Double.compare(p2.getPreu(), p1.getPreu());
                if (aux == 0) aux = Boolean.compare(p2.getDisponible(), p1.getDisponible());
                return aux;
            }
        });
        llista.forEach(System.out::println);

        // APARTAT H - ASCENDENT ORDENAR PER PREU (LAMBDA)
        System.out.println("\n** ORDENACIÓ PER PREU (LAMBDA) ASCENDENT **");
        llista.sort((p1, p2) -> p1.getPreu().compareTo(p2.getPreu()));
        llista.forEach(System.out::println);

        // APARTAT H - DESCENDENT ORDENAR PER PREU (LAMBDA)
        System.out.println("\n** ORDENACIÓ PER PREU (LAMBDA) DESCENDENT **");
        llista.sort((p1, p2) -> p2.getPreu().compareTo(p1.getPreu()));
        llista.forEach(System.out::println);

        // APARTAT I - ASCENDENT ORDENAR PER DISPONIBILITAT (LAMBDA)
        System.out.println("\n** ORDENACIÓ PER DISPONIBILITAT (LAMBDA) ASCENDENT **");
        llista.sort((p1, p2) -> Boolean.compare(p1.getDisponible(), p2.getDisponible()));
        llista.forEach(System.out::println);

        // APARTAT I - DESCENDENT ORDENAR PER DISPONIBILITAT (LAMBDA)
        System.out.println("\n** ORDENACIÓ PER DISPONIBILITAT (LAMBDA) DESCENDENT **");
        llista.sort((p1, p2) -> Boolean.compare(p2.getDisponible(), p1.getDisponible()));
        llista.forEach(System.out::println);

        // APARTAT J - ASCENDENT ORDENAR PER PREU/DISPONIBILITAT (LAMBDA)
        System.out.println("\n** ORDENACIÓ PER PREU/DISPONIBILITAT (LAMBDA) ASCENDENT **");
        llista.sort((p1, p2) -> {
            int aux = Double.compare(p1.getPreu(), p2.getPreu());
            if (aux == 0) aux = Boolean.compare(p1.getDisponible(), p2.getDisponible());
            return aux;
        });
        llista.forEach(System.out::println);

        // APARTAT J - DESCENDENT ORDENAR PER PREU/DISPONIBILITAT (LAMBDA)
        System.out.println("\n** ORDENACIÓ PER PREU/DISPONIBILITAT (LAMBDA) ASCENDENT **");
        llista.sort((p1, p2) -> {
            int aux = Double.compare(p2.getPreu(), p1.getPreu());
            if (aux == 0) aux = Boolean.compare(p2.getDisponible(), p1.getDisponible());
            return aux;
        });
        llista.forEach(System.out::println);

        // APARTAT K - REFERENCIA METODE STATIC ORDENAR PER PREU/DISPONIBNILITAT CLASSE PRODUCTE ASCENDENT
        System.out.println("\n** ORDENACIÓ PER PREU/DISPONIBILITAT (REFERENCIA METODE STATIC CLASSE PRODUCTE) ASCENDENT **");
        llista.sort(Producte::ComparatorPerPreuDisponibilitatAsc);
        llista.forEach(System.out::println);

        // APARTAT K - REFERENCIA METODE STATIC ORDENAR PER PREU/DISPONIBNILITAT CLASSE PRODUCTE ASCENDENT
        System.out.println("\n** ORDENACIÓ PER PREU/DISPONIBILITAT (REFERENCIA METODE STATIC CLASSE PRODUCTE) DESCENDENT **");
        llista.sort(Producte::ComparatorPerPreuDisponibilitatDesc);
        llista.forEach(System.out::println);

    }
}
