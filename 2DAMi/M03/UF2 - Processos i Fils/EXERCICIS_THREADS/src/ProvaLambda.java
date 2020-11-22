import java.time.Duration;
import java.time.LocalTime;

public class ProvaLambda {

    public static void main(String[] args) {

        Runnable runa = () -> {
            LocalTime inici = LocalTime.now();
            for (int i = 0; i < 1000; i++) {
                //System.out.println(i + " " + Thread.currentThread().getName());
            }
            LocalTime acabat = LocalTime.now();
            long total = Duration.between(inici, acabat).getNano();
            System.out.println(Thread.currentThread().getName() + " ha tardado : " + total);
        };
        Thread b1 = new Thread(runa);
        Thread b2 = new Thread(runa);

        Thread b3 = new Thread(() -> {
            LocalTime inici = LocalTime.now();
            for (int i = 0; i < 1000; i++) {
                //System.out.println(i + " " + Thread.currentThread().getName());
            }
            LocalTime acabat = LocalTime.now();
            long total = Duration.between(inici, acabat).getNano();
            System.out.println(Thread.currentThread().getName() + " ha tardado : " + total);
        });

        b1.start();
        b2.start();
        b3.start();

    }
}
