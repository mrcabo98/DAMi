import java.time.LocalTime;

public class ProvaBicicleta_B {

    public static void main(String[] args) {
        LocalTime inici = LocalTime.now();
        final int DISTANCIA = 1000;
        Bici_B b1 = new Bici_B("Montse",inici,DISTANCIA);
        Bici_B b2 = new Bici_B("Fran",inici,DISTANCIA);
        Bici_B b3 = new Bici_B("Clara",inici,DISTANCIA);
        Thread s1 = new Thread(b1);
        Thread s2 = new Thread(b2);
        Thread s3 = new Thread(b3);

        s1.start();
        s2.start();
        s3.start();

        try {
            s1.join();
            s2.join();
            s3.join();
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
