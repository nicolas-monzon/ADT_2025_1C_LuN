package org.example.model;

public interface Table {

    void add(String key, String value);
    String get(String key);
    void remove(String key);

}
