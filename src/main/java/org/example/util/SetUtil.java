package org.example.util;

import org.example.model.Set;
import org.example.model.StaticSet;

public class SetUtil {

    public static Set copy(Set set) { // O(C) + O(C) + O(n^2) + O(n^2) ~> O(n^2)
        Set aux = new StaticSet();
        Set result = new StaticSet();

        // Condicion + n*Cuerpo
        // O(C) + n*O(n) ~> O(n^2)
        while (!set.isEmpty()) {
            int chosen = set.choose(); // O(C)
            aux.add(chosen); // O(n)
            result.add(chosen); // O(n)
            set.remove(chosen); // O(n)
        }

        /*
        // O(C) + C*O(C) ~> O(C)
        int i = 0;
        while(i < 5) {
            System.out.println(i);
            i++;
        }
        */

        // O(n^2)
        while (!aux.isEmpty()) {
            int chosen = aux.choose();
            set.add(chosen);
            aux.remove(chosen);
        }

        return result;
    }

    public static boolean in(int a, Set set) {
        Set copy = copy(set);
        while (!copy.isEmpty()) {
            int chosen = copy.choose();
            if (chosen == a) {
                return true;
            }
            copy.remove(chosen);
        }
        return false;
    }

    public static boolean subseteq(Set set, Set set2) { // O(C) + O(C) + O(C)
        Set copy = copy(set);
        while (!copy.isEmpty()) {
            int chosen = copy.choose();
            if (!in(chosen, set2)) {
                return false;
            }
            copy.remove(chosen);
        }
        return true;
    }

    public static boolean subset(Set set, Set set2) {
        Set copy = copy(set);
        while (!copy.isEmpty()) {
            int chosen = copy.choose();
            if (!in(chosen, set2)) {
                return false;
            }
            copy.remove(chosen);
        }
        return !equals(set, set2);
    }

    public static boolean equals(Set set, Set set2) {
        return subseteq(set, set2) && subseteq(set2, set);
    }

    public static int size(Set set) {
        Set copy = copy(set);
        int total = 0;
        while (!copy.isEmpty()) {
            total++;
            copy.remove(copy.choose());
        }
        return total;
    }

    public static boolean equals2(Set set, Set set2) {
        return subseteq(set, set2) && size(set) == size(set2);
    }

    public static Set union(Set set1, Set set2) {
        Set copy = copy(set1);
        Set copy2 = copy(set2);

        while (!copy2.isEmpty()) {
            int chosen = copy2.choose();
            copy.add(chosen);
            copy2.remove(chosen);
        }

        return copy;
    }

    public static Set intersection(Set set1, Set set2) {
        Set result = new StaticSet();
        Set copy = copy(set1);

        while (!copy.isEmpty()) {
            int chosen = copy.choose();
            if(in(chosen, set2)) {
                result.add(chosen);
            }
            copy.remove(chosen);
        }

        return result;
    }

    public static boolean equals3(Set set, Set set2) {
        int size = size(intersection(set, set2));
        return size == size(set) && size == size(set2);
    }

    public static Set difference(Set set, Set set2) {
        Set result = new StaticSet();
        Set copy = copy(set);

        while (!copy.isEmpty()) {
            int chosen = copy.choose();
            if(!in(chosen, set2)) {
                result.add(chosen);
            }
            copy.remove(chosen);
        }

        return result;
    }

    // {1, 2, 3} - {1, 2, 3} = {}
    // {1, 2, 3} - {1, 2, 3} = {}
    public static boolean equals4(Set set, Set set2) {
        return difference(set, set2).equals(new StaticSet()) && difference(set2, set).equals(new StaticSet());
    }

    public static Set symmetricDifference(Set set, Set set2) {
        return union(difference(set, set2), difference(set2, set));
    }

    public static Set symmetricDifferenceV2(Set set, Set set2) {
        return difference(union(set, set2), intersection(set, set2));
    }

}
