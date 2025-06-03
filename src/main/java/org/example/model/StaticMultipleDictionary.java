package org.example.model;

public class StaticMultipleDictionary implements MultipleDictionary {

    private static final int MAX = 10000;

    /* [[1, 2, 2, 3, ...],
        [5, 1, 6, 0, ...],
        null,
        null,
        ...,
        null]

    count = 1;

    Agrego
    (1, 2),
    (1, 3),
    (5, 6)
     */
    private final int[][] matrix;
    private int count;

    public StaticMultipleDictionary() {
        matrix = new int[MAX][MAX];
        count = 0;
    }

    @Override
    public void add(int key, int value) {
        for (int i = 0; i < count; i++) {
            if (matrix[i][0] == key) {
                for (int j = 0; j < matrix[i][1]; j++) {
                    if (matrix[i][j + 2] == value) {
                        return;
                    }
                }
                if (matrix[i][1] == Integer.MAX_VALUE) {
                    throw new RuntimeException("The dictionary is full");
                }
                matrix[i][matrix[i][1] + 2] = value;
                matrix[i][1]++;
                return;
            }
        }
        if (count == Integer.MAX_VALUE) {
            throw new RuntimeException("The dictionary is full");
        }
        matrix[count] = new int[MAX];
        matrix[count][0] = key;
        matrix[count][1] = 1;
        matrix[count][2] = value;
        count++;
    }

    @Override
    public List get(int key) {
        List list = new DLinkedList();
        for (int i = 0; i < count; i++) {
            if (matrix[i][0] == key) {
                for (int j = 0; j < matrix[i][1]; j++) {
                    list.add(matrix[i][j + 2]);
                }
                return list;
            }
        }
        throw new RuntimeException("No such key");
    }

    @Override
    public void remove(int key, int value) {
        for (int i = 0; i < count; i++) {
            if (matrix[i][0] == key) {
                for (int j = 0; j < matrix[i][1]; j++) {
                    if (matrix[i][j + 2] == value) {
                        for (int k = j + 2; k < matrix[i][2]; k++) {
                            matrix[i][k] = matrix[i][k + 1];
                        }
                        matrix[i][1]--;
                        if (matrix[i][1] == 0) {
                            matrix[i] = matrix[count - 1];
                            count--;
                        }
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override
    public Set getKeys() {
        Set set = new StaticSet();

        for (int i = 0; i < count; i++) {
            set.add(matrix[i][0]);
        }

        return set;
    }
}
