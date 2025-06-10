package org.example.util;

import org.example.model.BinaryTree;
import org.example.model.BinaryTreeQueue;
import org.example.model.DynamicBinaryTreeQueue;

public class BinaryTreeUtil {

    private BinaryTreeUtil() {

    }

    public static int totalNodes(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return 0;
        }
        int i = totalNodes(binaryTree.getLeft());
        int r = 1;
        int d = totalNodes(binaryTree.getRight());

        return i + r + d;
    }

    public static int totalLeaves(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return 0;
        }
        int i = totalNodes(binaryTree.getLeft());
        int r = binaryTree.getLeft() == null && binaryTree.getRight() == null ? 1 : 0;
        int d = totalNodes(binaryTree.getRight());

        return i + r + d;
    }

    public static int totalIntern(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return 0;
        }

        return totalInternAux(binaryTree, false);
    }

    private static int totalInternAux(BinaryTree binaryTree, boolean res) {
        if(binaryTree == null) {
            return 0;
        }
        int i = totalNodes(binaryTree.getLeft());
        int r = !(binaryTree.getLeft() == null && binaryTree.getRight() == null) ? 1 : 0;
        int d = totalNodes(binaryTree.getRight());

        return i + r + d;
    }

    public static int height(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return 0;
        }
        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    public static boolean isComplete(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return true;
        }
        if(binaryTree.getLeft() == null && binaryTree.getRight() != null) {
            return false;
        }
        if(binaryTree.getLeft() != null && binaryTree.getRight() == null) {
            return false;
        }
        return isComplete(binaryTree.getLeft()) && isComplete(binaryTree.getRight());
    }

    public static boolean isFull(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return true;
        }
        if(binaryTree.getLeft() == null && binaryTree.getRight() != null) {
            return false;
        }
        if(binaryTree.getLeft() != null && binaryTree.getRight() == null) {
            return false;
        }
        return isFull(binaryTree.getLeft()) &&
                isFull(binaryTree.getRight()) &&
                height(binaryTree.getLeft()) == height(binaryTree.getRight());
    }

    public static boolean isFull2(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return true;
        }
        int totalNodes = totalNodes(binaryTree.getLeft());
        int aux = totalNodes + 1;
        int exp = (int) (Math.log(aux) / Math.log(2));
        if(Math.pow(2, exp) - 1 == totalNodes) {
            return true;
        }
        return false;
    }

    public static void printPreOrder(BinaryTree binaryTree) {
        if(binaryTree == null) {
            System.out.println("null");
            return;
        }
        System.out.println(binaryTree.getRoot());
        printPreOrder(binaryTree.getLeft());
        printPreOrder(binaryTree.getRight());
    }

    public static void printInOrder(BinaryTree binaryTree) {
        if(binaryTree == null) {
            System.out.println("null");
            return;
        }
        printInOrder(binaryTree.getLeft());
        System.out.println(binaryTree.getRoot());
        printInOrder(binaryTree.getRight());
    }

    public static void postOrder(BinaryTree binaryTree) {
        if(binaryTree == null) {
            System.out.println("null");
            return;
        }
        postOrder(binaryTree.getLeft());
        postOrder(binaryTree.getRight());
        System.out.println(binaryTree.getRoot());
    }

    public static void printByLevel(BinaryTree binaryTree) {
        if(binaryTree == null) {
            System.out.println("null");
            return;
        }
        BinaryTreeQueue binaryTreeQueue = new DynamicBinaryTreeQueue();
        binaryTreeQueue.add(binaryTree);

        while(!binaryTreeQueue.isEmpty()) {
            binaryTreeQueue.add(binaryTreeQueue.getFirst().getLeft());
            binaryTreeQueue.add(binaryTreeQueue.getFirst().getRight());

            System.out.println(binaryTreeQueue.getFirst().getRoot());

            binaryTreeQueue.remove();
        }
    }

}
