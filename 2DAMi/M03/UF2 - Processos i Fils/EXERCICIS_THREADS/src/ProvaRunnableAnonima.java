import java.time.Duration;
import java.time.LocalTime;

public class ProvaRunnableAnonima {

    public static void main(String[] args) {

        Thread b1 = new Thread(new Runnable() {
            @Override
            public void run() {
                LocalTime inici = LocalTime.now();
                for (int i = 0; i < 1000; i++) {
//                    System.out.println(i + " " + Thread.currentThread().getName());
                }
                LocalTime acabat = LocalTime.now();
                long total = Duration.between(inici, acabat).getNano();
                System.out.println(Thread.currentThread().getName() + " ha tardado : " + total);
            }
        });
        b1.start();

        Thread b2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LocalTime inici = LocalTime.now();
                for (int i = 0; i < 1000; i++) {
//                    System.out.println(i + " " + Thread.currentThread().getName());
                }
                LocalTime acabat = LocalTime.now();
                long total = Duration.between(inici, acabat).getNano();
                System.out.println(Thread.currentThread().getName() + " ha tardado : " + total);
            }
        });
        b2.start();

        Thread b3 = new Thread(new Runnable() {
            @Override
            public void run() {
                LocalTime inici = LocalTime.now();
                for (int i = 0; i < 1000; i++) {
//                    System.out.println(i + " " + Thread.currentThread().getName());
                }
                LocalTime acabat = LocalTime.now();
                long total = Duration.between(inici, acabat).getNano();
                System.out.println(Thread.currentThread().getName() + " ha tardado : " + total);
            }
        });
        b3.start();

    }

}
