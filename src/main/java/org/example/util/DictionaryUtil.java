package org.example.util;

import org.example.model.Dictionary;
import org.example.model.Set;
import org.example.model.StaticDictionary;

public class DictionaryUtil {

    private DictionaryUtil() {

    }

    public static Dictionary copy(Dictionary dictionary) {
        Dictionary result = new StaticDictionary();
        Set keys = dictionary.getKeys();
        while(!keys.isEmpty()) {
            int chosen = keys.choose();
            result.add(chosen, dictionary.get(chosen));
            keys.remove(chosen);
        }
        return result;
    }

    // Intersección

}
