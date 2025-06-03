package org.example.model;

import java.util.Arrays;

public class StaticVersionedStack implements VersionedStack {

    private static final int MAX_SIZE = 10000;

    private final Integer[][] biarray;
    private int[] counts;
    private int versionCount;

    public StaticVersionedStack() {
        biarray = new Integer[MAX_SIZE][];
        biarray[0] = new Integer[MAX_SIZE];
        counts = new int[MAX_SIZE];
        counts[0] = 0;
        versionCount = 1;
    }

    @Override
    public void add(int a) {
        if (versionCount == MAX_SIZE) {
            throw new RuntimeException("Stack is full");
        }
        biarray[versionCount] = Arrays.copyOf(biarray[versionCount - 1], biarray[versionCount - 1].length);
        counts[versionCount] = counts[versionCount - 1];

        biarray[versionCount][counts[versionCount]] = a;
        counts[versionCount]++;

        versionCount++;
    }

    @Override
    public void remove() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int getTop() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean isEmpty() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void createVersion(int version) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void removeVersion(int version) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Stack<Integer> getVersion(int version) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int getCurrentVersion() {
        throw new RuntimeException("Not implemented");
    }
}
