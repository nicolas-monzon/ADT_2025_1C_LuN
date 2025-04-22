package org.example.model;

public interface VersionedStack {

    void add(int a);
    void remove();
    int getTop();
    boolean isEmpty();

    /**
     * Precondiciones: La versión tiene que existir
     * @param version
     */
    void createVersion(int version); // P(b)

    /**
     * Precondiciones: La versión tiene que existir, y no puede ser la última
     * @param version
     */
    void removeVersion(int version); // P(a)
    Stack<Integer> getVersion(int version);
    int getCurrentVersion();

}
