package org.example.util;

import org.example.model.*;

public class DictionaryUtil {

    private DictionaryUtil() {

    }

    public static Dictionary copy(Dictionary dictionary) {
        Dictionary result = new StaticDictionary();
        Set keys = dictionary.getKeys();
        while (!keys.isEmpty()) {
            int chosen = keys.choose();
            result.add(chosen, dictionary.get(chosen));
            keys.remove(chosen);
        }
        return result;
    }

    public static boolean existsInverse(Dictionary dictionary) {
        Set keys = dictionary.getKeys();
        Set values = new StaticSet();

        while (!keys.isEmpty()) {
            int chosen = keys.choose();
            values.add(dictionary.get(chosen));
            keys.remove(chosen);
        }
        return SetUtil.size(keys) == SetUtil.size(values);
    }

    public static Dictionary union(Dictionary dictionary1, Dictionary dictionary2) {
        Set keys = dictionary1.getKeys();
        Set keys2 = dictionary2.getKeys();
        Set intersectionKeys = SetUtil.intersection(keys2, keys);
        while (!intersectionKeys.isEmpty()) {
            int chosen = intersectionKeys.choose();
            if (dictionary1.get(chosen) != dictionary2.get(chosen)) {
                throw new RuntimeException("No se pueden unir los diccionarios");
            }
            intersectionKeys.remove(chosen);
        }
        Dictionary result = copy(dictionary1);
        while (!keys2.isEmpty()) {
            int chosen = keys2.choose();
            result.add(chosen, dictionary2.get(chosen));
            keys2.remove(chosen);
        }
        return result;
    }

    public static MultipleDictionary copy(MultipleDictionary dictionary) {
        Set keys = dictionary.getKeys();
        MultipleDictionary result = new DynamicMultipleDictionary();

        while (!keys.isEmpty()) {
            int chosen = keys.choose();
            List values = dictionary.get(chosen);
            int size = values.size();
            for (int i = 0; i < size; i++) {
                result.add(chosen, values.get(i));
            }
            keys.remove(chosen);
        }

        return result;
    }

    public static MultipleDictionary diff(MultipleDictionary dictionary1, MultipleDictionary dictionary2) {
        MultipleDictionary result = copy(dictionary1);

        Set keys2 = dictionary2.getKeys();
        while (!keys2.isEmpty()) {
            int chosen = keys2.choose();
            List values = dictionary2.get(chosen);
            int size = values.size();
            for (int i = 0; i < size; i++) {
                result.remove(chosen, values.get(i));
            }
            keys2.remove(chosen);
        }
        return result;
    }

}
