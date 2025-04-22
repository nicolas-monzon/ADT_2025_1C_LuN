package org.example.model;

public interface Stack<T> {

    /**
     * Precondición: La pila no este llena
     * Postcondición: El argumento queda en el tope
     * Estrategia: Tomo el valor, y en la estructura interna, que está indexada,
     * defino una posición destacada (que signifique nuestro tope) y coloque
     * el calor valor dado en el tope.
     * @param a es un valor a apilar
     */
    void add(T a);
    void remove();
    T getTop();
    boolean isEmpty();

}
