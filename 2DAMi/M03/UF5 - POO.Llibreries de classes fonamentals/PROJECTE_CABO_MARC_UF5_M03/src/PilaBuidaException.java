/** La clase <b>PilaBuidaException</b> permite lanzar una excepcion
 * personalizada en caso de que la pila este vacía.
 * @author Marc Cabo Dieguez
 * @version 08/11/2020
 */

public class PilaBuidaException extends Exception {
    private String message;

    /**
     * @param message Representa el mensaje lanzado por la excepcion.
     */
    public PilaBuidaException(String message) {
        super(message);
    }

    /** Metodo sobreescrito que permite devolver el mensaje de la Excepcion generada.
     * @return String
     */
    @Override
    public String getMessage() {
        return message;
    }
}
