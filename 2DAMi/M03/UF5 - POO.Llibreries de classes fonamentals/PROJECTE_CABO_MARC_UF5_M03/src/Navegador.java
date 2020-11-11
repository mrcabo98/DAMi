import java.util.*;

/** La clase <b>Navegador</b> permite trabajar con varios elementos, entre ellos los siguientes :
 * Un metodo que permite ir hacia una URL indicada con la utilizacion de un regex para poder comprobar
 * que el formato de la misma es valido.
 * Tambien disponemos de metodos que permiten ir hacía atras o hacia adelante dependiendo de la accion que
 * queramos realizar en ese momento.
 * Por ultimo contamos que dos metodos que nos permiten visualizar el historial de busqueda del usuario ademas
 * de poder ordenar el mismo por numero de visitas.
 * @author Marc Cabo Dieguez
 * @version 08/11/2020
 */

public class Navegador {
    final static String URL_REGEX = "(?i)(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?";

    private Pila<String> anarEnrere = new Pila<>();
    private Pila<String> anarEndavant = new Pila<>();
    private ArrayList<String> historial = new ArrayList<>();

    /** Metodo que devuelve la URL introducida.
     * @param url String
     */
    public Navegador(String url) {
        this.anarA(url);
    }

    /** Metodo que permite validar la URL introducida por el usuario, permite actualizar la pila
     * con la URL introducida por el usuario, y la misma se añade al historial de búsquedas.
     * @param novaURL String dedicado a la URL visitada
     * @return String
     */
    public String anarA(String novaURL) {
        String error = "La URL introducida no es válida";
        if (novaURL.matches(URL_REGEX)) {
            anarEnrere.push(novaURL);
            if (!historial.contains(novaURL)) {
                historial.add(novaURL);
            }
            anarEndavant.removeAllElements();
            System.out.println("Se esta visualizando esta página web : " + novaURL);
            return novaURL;
        } else {
            System.out.println(error);
            return error;
        }
    }

    /** Metodo que permite ir hacia URLs vistadas con anterioridad siempre y cuando la
     * pila tenga como minimo tenga 2 elementos. Las URLs visitadas tambien se añaden
     * al historial de busqueda.
     * @return String
     */
    public String enrere() {
        String currentURL;
        String error = "Debes visitar como mínimo 2 páginas web para poder realizar esta acción! ";
        if (anarEnrere.size() > 1) {
            try {
                anarEndavant.push(anarEnrere.pop());
                currentURL = anarEnrere.peek();
                historial.add(currentURL);
                System.out.println("Se esta visualizando esta página web : " + currentURL);
                return currentURL;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(error);
        }
        return null;
    }

    /** Metodo que permite ir hacia URLs visitadas posteriormente siempre y cuando se visiten
     * dos paginas o mas. Las URLs visitadas tambien se añaden al historial de busqueda.
     * @return String
     */
    public String endavant() {
        String error = "Debes visitar como mínimo 2 páginas web para poder realizar esta acción! ";
        if (anarEndavant.size() > 0) {
            try {
                String currentURL = anarEndavant.pop();
                historial.add(currentURL);
                anarEnrere.push(currentURL);
                System.out.println("Se esta visualizando esta página web : " + currentURL);
                return currentURL;
            } catch (PilaBuidaException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(error);
        }
        return null;
    }

    /**
     * Metodo que permite visualizar el historial de busqueda mediante un bucle ForEach
     */
    public void veureHistorial() {
        System.out.println("* * * * * * * * * *     HISTORIAL     * * * * * * * * * *");
        historial.forEach((paginasVisitadas -> System.out.println(paginasVisitadas)));
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }

}