package org.example.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphUtil {

    private GraphUtil() {

    }

    public static int[] getK(boolean[][] adjacencyMatrix) {
        if (adjacencyMatrix == null) {
            throw new RuntimeException("Matriz nula");
        }
        if (adjacencyMatrix.length != adjacencyMatrix[0].length) {
            throw new RuntimeException("Matriz invalida");
        }
        int[] kInVector = new int[adjacencyMatrix.length];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j]) {
                    kInVector[i]++;
                    kInVector[j]++;
                }
            }
        }
        return kInVector;
    }

    public static int[] getKOut(boolean[][] adjacencyMatrix) {
        if (adjacencyMatrix == null) {
            throw new RuntimeException("Matriz nula");
        }
        if (adjacencyMatrix.length != adjacencyMatrix[0].length) {
            throw new RuntimeException("Matriz invalida");
        }
        int[] kInVector = new int[adjacencyMatrix.length];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j]) {
                    kInVector[i]++;
                }
            }
        }
        return kInVector;
    }

    public static int[] getKIn(boolean[][] adjacencyMatrix) {
        if (adjacencyMatrix == null) {
            throw new RuntimeException("Matriz nula");
        }
        if (adjacencyMatrix.length != adjacencyMatrix[0].length) {
            throw new RuntimeException("Matriz invalida");
        }
        int[] kInVector = new int[adjacencyMatrix.length];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (adjacencyMatrix[i][j]) {
                    kInVector[j]++;
                }
            }
        }
        return kInVector;
    }

    public static List<Integer> reflexiveIndexes(boolean[][] adjacencyMatrix) {
        if (adjacencyMatrix == null) {
            throw new RuntimeException("Matriz nula");
        }
        if (adjacencyMatrix.length != adjacencyMatrix[0].length) {
            throw new RuntimeException("Matriz invalida");
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[i][i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static boolean[][] subGraph(boolean[][] adjacencyMatrix) {
        if (adjacencyMatrix == null) {
            throw new RuntimeException("Matriz nula");
        }
        boolean[][] candidate = new boolean[adjacencyMatrix.length][];
        if (adjacencyMatrix.length == 0) {
            return candidate;
        }
        if (adjacencyMatrix.length != adjacencyMatrix[0].length) {
            throw new RuntimeException("Matriz invalida");
        }
        if (adjacencyMatrix.length == 1) {
            candidate[0][0] = adjacencyMatrix[0][0];
            return candidate;
        }
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            candidate[i] = new boolean[adjacencyMatrix[i].length];
            for (int j = 0; j < i; j++) {
                if (adjacencyMatrix[i][j] && adjacencyMatrix[i][j] == adjacencyMatrix[j][i]) {
                    candidate[i][j] = candidate[j][i] = true;
                }
            }
        }
        return candidate;
    }

    public static boolean transitive(boolean[][] adjacencyMatrix) {
        if (adjacencyMatrix == null) {
            throw new RuntimeException("Matriz nula");
        }
        if (adjacencyMatrix.length == 0) {
            return true;
        }
        if (adjacencyMatrix.length != adjacencyMatrix[0].length) {
            throw new RuntimeException("Matriz invalida");
        }
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                for (int k = 0; k < adjacencyMatrix.length; k++) {
                    if (adjacencyMatrix[i][j] && adjacencyMatrix[j][k] && !adjacencyMatrix[i][k]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static List<Integer> cycle(boolean[][] adjacencyMatrix, int init) {
        if (adjacencyMatrix == null) {
            throw new RuntimeException("Matriz nula");
        }
        if (adjacencyMatrix.length == 0) {
            return new ArrayList<>();
        }
        if (adjacencyMatrix.length != adjacencyMatrix[0].length) {
            throw new RuntimeException("Matriz invalida");
        }
        if (init >= adjacencyMatrix.length) {
            throw new RuntimeException("Indice fuera de rango");
        }

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[init][i]) {
                List<Integer> candidate = new ArrayList<>();
                candidate.add(init);
                cycle(adjacencyMatrix, i, init, candidate);
                if (candidate.size() != 1 && candidate.get(candidate.size() - 1) == init) {
                    return candidate;
                }
            }
        }
        return new ArrayList<>();
    }

    public static void cycle(boolean[][] adjacencyMatrix, int current, int init, List<Integer> candidate) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[current][i]) {
                candidate.add(i);
                if (i == init) {
                    return;
                }
                cycle(adjacencyMatrix, i, init, candidate);
                if (candidate.get(candidate.size() - 1) != init) {
                    candidate.remove(candidate.size() - 1);
                }
            }
        }
    }

    public static List<Integer> hamiltonianPath(boolean[][] adjacencyMatrix) {
        if (adjacencyMatrix == null) {
            throw new RuntimeException("Matriz nula");
        }
        if (adjacencyMatrix.length == 0) {
            return new ArrayList<>();
        }
        if (adjacencyMatrix.length != adjacencyMatrix[0].length) {
            throw new RuntimeException("Matriz invalida");
        }
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < i; j++) {
                List<Integer> candidate = hamiltonianPath(adjacencyMatrix, i, j);
                if (!candidate.isEmpty()) {
                    return candidate;
                }
            }
        }
        return new ArrayList<>();
    }

    private static List<Integer> hamiltonianPath(boolean[][] adjacencyMatrix, int init, int end) {
        if (init >= adjacencyMatrix.length) {
            throw new RuntimeException("Indice fuera de rango");
        }

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[init][i]) {
                List<Integer> candidate = new ArrayList<>();
                candidate.add(init);
                hamiltonianPath(adjacencyMatrix, i, end, candidate);
                if (candidate.size() != 1 && candidate.get(candidate.size() - 1) == end) {
                    return candidate;
                }
            }
        }
        return new ArrayList<>();
    }

    public static void hamiltonianPath(boolean[][] adjacencyMatrix, int current, int end, List<Integer> candidate) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[current][i]) {
                candidate.add(i);
                if (i == end) {
                    return;
                }
                hamiltonianPath(adjacencyMatrix, i, end, candidate);
                if (candidate.get(candidate.size() - 1) != end) {
                    candidate.remove(candidate.size() - 1);
                }
            }
        }
    }

    public static boolean isomorphism(boolean[][] matrix, boolean[][] matrix2) {
        if (matrix == null && matrix2 != null || matrix != null && matrix2 == null) {
            return false;
        }
        if (matrix == null || matrix.length == 0 && matrix2.length == 0) {
            return true;
        }
        if (matrix.length != matrix2.length) {
            return false;
        }
        List<List<Integer>> permutations = permutations(matrix.length - 1);
        for (List<Integer> permutation : permutations) {
            boolean[][] candidate = copyMatrix(matrix, permutation);
            if (equals(candidate, matrix2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean equals(boolean[][] matrix, boolean[][] matrix2) {
        if (matrix == null && matrix2 != null || matrix != null && matrix2 == null) {
            return false;
        }
        if (matrix == null || matrix.length == 0 && matrix2.length == 0) {
            return true;
        }
        if (matrix.length != matrix2.length) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean[][] copyMatrix(boolean[][] matrix, List<Integer> permutation) {
        if (permutation == null || permutation.size() == 0) {
            return new boolean[0][0];
        }
        boolean[][] result = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < permutation.size(); i++) {
            for (int j = 0; j < permutation.size(); j++) {
                result[i][j] = matrix[permutation.get(i)][j];
                result[j][i] = matrix[j][permutation.get(i)];
            }
        }
        return result;
    }

    private static List<List<Integer>> permutations(int n) { // Elementos en [0, n]
        if (n == 0) { // Greedy
            List<Integer> unique = new ArrayList<>();
            unique.add(0);
            List<List<Integer>> result = new ArrayList<>();
            result.add(unique);
            return result;
        }
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            values.add(i);
        }
        return permutations(values);
    }

    private static List<List<Integer>> permutations(List<Integer> values) {
        List<List<Integer>> result = new ArrayList<>();
        if (values.size() == 1) {
            result.add(values);
            return result;
        }
        for (int i = 0; i < values.size(); i++) {
            List<Integer> copy = new ArrayList<>(values);
            copy.remove(i);
            List<List<Integer>> partition = permutations(copy);
            for (int j = 0; j < partition.size(); j++) {
                partition.get(j).add(0, values.get(i));
            }
            result.addAll(partition);
        }

        return result;
    }

    public static boolean isTree(boolean[][] matrix) { // precondicion matriz cuadrada
        if (matrix == null || matrix.length == 0) {
            return true;
        }
        if (matrix.length != matrix[0].length) {
            throw new RuntimeException("Matriz invalida");
        }
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    total++;
                }
            }
        }

        int[][] map = mapBooleanMatrix(matrix);
        if (invalidDiagonal(map)) {
            return false;
        }
        for (int i = 2; i < total; i++) {
            int[][] aux = pow(map, i);
            if (invalidDiagonal(aux)) {
                return false;
            }
        }

        return !hamiltonianPath(matrix).isEmpty();
    }

    public static boolean invalidDiagonal(int[][] squareMatrix) {
        for (int i = 0; i < squareMatrix.length; i++) {
            if (squareMatrix[i][i] != 0) {
                return true;
            }
        }
        return false;
    }

    private static int[][] mapBooleanMatrix(boolean[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int[][] result = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            int[] current = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                current[j] = matrix[i][j] ? 1 : 0;
            }
            result[i] = current;
        }
        return result;
    }

    private static int[][] times(int[][] squareMatrix, int[][] squareMatrix2) {
        if (squareMatrix == null || squareMatrix2 == null || squareMatrix.length != squareMatrix2.length) {
            throw new RuntimeException("Multiplicacion invalida");
        }
        int[][] result = new int[squareMatrix.length][squareMatrix[0].length];
        for (int i = 0; i < squareMatrix.length; i++) {
            for (int j = 0; j < squareMatrix.length; j++) {
                for (int k = 0; k < squareMatrix.length; k++) {
                    result[i][j] += squareMatrix[i][k] * squareMatrix2[k][j];
                }
            }
        }
        return result;
    }

    private static int[][] pow(int[][] squareMatrix, int n) {
        if (n < 1) {
            throw new RuntimeException("n no es Natural");
        }
        int[][] candidate = deepCopy(squareMatrix);
        if (n == 1) {
            return candidate;
        }
        for (int i = 2; i <= n; i++) {
            candidate = times(candidate, squareMatrix);
        }
        return candidate;
    }

    private static int[][] deepCopy(int[][] original) {
        int[][] deepCopy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            deepCopy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return deepCopy;
    }

    public static boolean isList(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return true;
        }
        if (matrix.length != matrix[0].length) {
            throw new RuntimeException("Matriz invalida");
        }
        return !hamiltonianPath(matrix).isEmpty() && totalEdges(matrix) == matrix.length - 1;
    }

    private static int totalEdges(boolean[][] matrix) {
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    total++;
                }
            }
        }
        return total;
    }

    public static boolean cyclicQueue(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return true;
        }
        if (matrix.length != matrix[0].length) {
            throw new RuntimeException("Matriz invalida");
        }
        int totalEdges = totalEdges(matrix);
        return totalEdges == matrix.length && identity(pow(mapBooleanMatrix(matrix), totalEdges));
    }

    private static boolean identity(int[][] squareMatrix) {
        for (int i = 0; i < squareMatrix.length; i++) {
            for (int j = 0; j < squareMatrix[i].length; j++) {
                if (i == j && squareMatrix[i][j] != 1 || i != j && squareMatrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
