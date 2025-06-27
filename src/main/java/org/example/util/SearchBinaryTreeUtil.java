package org.example.util;

import org.example.model.BinaryTree;

public class SearchBinaryTreeUtil {

    private SearchBinaryTreeUtil() {

    }

    public static boolean isSBT(BinaryTree binaryTree) {
        return isSBT(binaryTree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isSBT(BinaryTree binaryTree, int min, int max) {
        if(binaryTree == null) {
            return true;
        }
        if(binaryTree.getLeft() != null && inRange(binaryTree.getLeft().getRoot(), min, Math.min(max, binaryTree.getRoot()))) {
            return false;
        }
        if(binaryTree.getRight() != null && inRange(binaryTree.getRight().getRoot(), Math.max(min, binaryTree.getRoot()), max)) {
            return false;
        }
        return isSBT(binaryTree.getLeft(), min, Math.min(max, binaryTree.getRoot())) &&
                isSBT(binaryTree.getRight(), Math.max(min, binaryTree.getRoot()), max);
    }

    private static boolean inRange(int root, int min, int max) {
        return root > min && root < max;
    }

}
  