import java.util.Iterator;

public class ProvaRadio {
    public static void main(String[] args) {
        Radio_1 radio1 = new Radio_1();
        radio1.afegirEmisora(new Emisora("Los 40 Principales","Electro",100.20));
        radio1.afegirEmisora(new Emisora("Europa FM","Pop",100.30));
        radio1.afegirEmisora(new Emisora("Classica FM","Clàssica",110.20));
        radio1.afegirEmisora(new Emisora("FlaixFM","Pop",120.20));
        radio1.afegirEmisora(new Emisora("Los 60/70/80","Clàssica",134.20));

        System.out.println("\n************************************************************************************");

        // EXERCICI 1 - AMB BUCLE FOR-EACH

        for (Emisora e:radio1) {
            System.out.println(e);
        }

        Radio_2 radio2 = new Radio_2();
        radio2.afegirEmisora(new Emisora("Los 40 Principales","Electro",100.20));
        radio2.afegirEmisora(new Emisora("Europa FM","Pop",100.30));
        radio2.afegirEmisora(new Emisora("Clàssica FM","Clàssica",110.20));
        radio2.afegirEmisora(new Emisora("FlaixFM","Pop",120.20));
        radio2.afegirEmisora(new Emisora("Los 60/70/80","Clàssica",134.20));

        System.out.println("************************************************************************************");

        // EXERCICI 2 - AMB BUCLE FOR-EACH

        for (Emisora e:radio2) {
            System.out.println(e);
        }

        System.out.println("************************************************************************************");

        // EXERCICI 2 - SENSE BUCLE FOR-EACH

        Iterator<Emisora> it=radio2.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("************************************************************************************");


    }
}
