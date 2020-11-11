import java.util.Scanner;

/** La clase <b>ProvaNavegador</b> la utilizamos en este caso para realizar pruebas de
 * funcionamiento en modo consola, y la misma nos permite ejecutar la aplicacion
 * final mostrando el navegador por pantalla.
 * @author Marc Cabo Dieguez
 * @version 08/11/2020
 */

public class ProvaNavegador {
    private static Navegador navegador;
    private static NavegadorGUI navegadorGUI;

    public static void main(String[] args) {
        navegadorGUI = new NavegadorGUI();
        navegadorGUI.setVisible(true);

//        Scanner sc = new Scanner(System.in);
//        int eleccion = 6;
//        navegador = new Navegador("http://google.es");
//
//        do {
//            System.out.println("\n********** MENÚ **********");
//            System.out.println("1.Anar A\n2.Enrere\n3.Endevant\n4.Veure Historial\n0.Sortir");
//            System.out.println("**************************");
//            eleccion = sc.nextInt();
//            switch (eleccion) {
//                case 0:
//                    System.out.println("Saliendo . . . . . . . .");
//                    break;
//                case 1:
//                    String inputURL;
//                    System.out.println("Introduce la URL : ");
//                    inputURL = sc.next();
//                    navegador.anarA(inputURL);
//                    break;
//                case 2:
//                    navegador.enrere();
//                    break;
//                case 3:
//                    navegador.endavant();
//                    break;
//                case 4:
//                    navegador.veureHistorial();
//                    break;
//            }
//        } while (eleccion != 0 | eleccion > 5);
    }
}
