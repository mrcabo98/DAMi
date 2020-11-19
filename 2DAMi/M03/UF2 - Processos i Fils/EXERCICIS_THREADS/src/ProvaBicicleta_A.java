import java.time.LocalTime;

public class ProvaBicicleta_A {

    public static void main(String[] args) {
        LocalTime inici = LocalTime.now();
        final int DISTANCIA = 1000;
        Bici_A b1 = new Bici_A("Montse", inici, DISTANCIA);
        Bici_A b2 = new Bici_A("Fran", inici, DISTANCIA);
        Bici_A b3 = new Bici_A("Clara", inici, DISTANCIA);

        b1.start();
        b2.start();
        b3.start();

        try {
            b1.join();
            b2.join();
            b3.join();
        } catch (InterruptedException e) {}

        System.out.println(b2);
        System.out.println(b1);
        System.out.println(b3);

        if (b1.getTemps() < b2.getTemps() && b1.getTemps() < b3.getTemps()) {
            System.out.println("La bici més ràpida es la de "+b1.getNom());
        } else if (b2.getTemps() < b1.getTemps() && b2.getTemps() < b3.getTemps()) {
            System.out.println("La bici més ràpida es la de "+b2.getNom());
        } else if (b3.getTemps() < b1.getTemps() && b3.getTemps() < b2.getTemps()) {
            System.out.println("La bici més ràpida es la de "+b3.getNom());
        }

    }
}
