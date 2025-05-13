package org.example.model;

public interface Set {

    void add(int a);
    void remove(int a);

    /**
     * Precondición: No se puede elegir un elemento de un conjunto vacío
     * @return
     */
    int choose();
    boolean isEmpty();

}
