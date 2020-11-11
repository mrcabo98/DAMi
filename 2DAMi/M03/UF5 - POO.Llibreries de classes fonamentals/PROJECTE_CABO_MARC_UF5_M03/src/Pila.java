import java.util.ArrayDeque;
import java.util.Iterator;

/** La clase <b>Pila</b> pretende simular el comportamiento de una estructura de
 * tipo LIFO, esta clase contiene todos los metodos para hacer todas las acciones
 * requeridas por el ejercicio.
 * @param <E>
 * @author Marc Cabo Dieguez
 * @version 08/11/2020
 */
public class Pila<E> implements Iterable<E> {
    private ArrayDeque<E> pila = new ArrayDeque<E>();

    @Override
    public Iterator<E> iterator() {
        return pila.iterator();
    }

    /** Metodo que devuelve un elemento booleano dependiendo de si la pila esta vacia o no.
     * @return Boolean
     */
    public boolean empty() {
        return pila.isEmpty();
    }

    /** Metodo que devuelve el ultimo elemento almacenado en la pila, de lo contrario salta la excepcion personalizada correspondiente.
     * @return String
     * @throws PilaBuidaException Excepcion personalizada en caso de que esta este vacía.
     */
    public E peek() throws PilaBuidaException {
        if (!pila.isEmpty()) {
            return pila.peekLast();
        }
        throw new PilaBuidaException("Error! Pila vacía");
    }

    /** Metodo que devuelve el ultimo elemento almacenado en la pila y lo elimina, si no hay elementos salta la excepcion personalizada correspondiente.
     * @return String
     * @throws PilaBuidaException Excepcion personalizada en caso de que esta este vacía.
     */
    public E pop() throws PilaBuidaException {
        if (!pila.isEmpty()) {
            return pila.removeLast();
        }
        throw new PilaBuidaException("Error! Pila vacía");
    }

    /** Metodo que permite agregar el elemento pasado por parametro a la cabeza de la pila.
     * @param e Elemento pasado como parametro que se quiere agregar a la pila.
     * @return void
     */
    public void push(E e) {
        pila.addLast(e);
    }

    /** Metodo que permite eliminar todos los elementos de la pila.
     * @return void
     */
    public void removeAllElements() {
        pila.clear();
    }

    /** Metodo que devuelve el tamano de los elementos de la pila.
     * @return int
     */
    public int size() {
        return pila.size();
    }

}
