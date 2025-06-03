package org.example;

import org.example.model.Set;
import org.example.model.StaticSet;
import org.example.util.SetUtil;

public class App {

    public static void main(String[] args) {
        Set set = new StaticSet();
        set.add(1);
        set.add(3);
        set.add(5);

        Set set2 = new StaticSet();
        set2.add(1);
        set2.add(3);
        set2.add(9);
        set2.add(27);

        Set intersection = SetUtil.intersection(set, set2);
        int size = SetUtil.size(intersection);

        for (int i = 0; i < size; i++) {
            int element = intersection.choose();
            System.out.println(element);
            intersection.remove(element);
        }

    }

}
