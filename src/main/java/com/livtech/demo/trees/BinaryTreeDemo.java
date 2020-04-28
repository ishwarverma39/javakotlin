package com.livtech.demo.trees;


import com.livtech.demo.nodes.BTNode;

public class BinaryTreeDemo {
    private static int count = 0;
    static boolean isIdenticalTree = false;
    private static int leafeNodes = 0;

    public static void main(String[] args) {
        BTNode root = new BTNode();
        root.setData(1);

        /*
         * BTree root2 = new BTree(); root2.setData(10);
         */

        insertNode(root);
        traversing(root);
        System.out.println("\nleafe Nodes " + leafeNodes);
        /*
         * insertNode2(root2); identicalTrees(root, root2); System.out.println(
         * " isIdentical tree " + isIdenticalTree);
         */

        traversing(root);
        countOfNodes(root);
        System.out.println("\n count of nodes in Tree " + count);

        // System.out.println(" maxdepth of the tree is " + maxDepth(root));
        /*
         * deleteTree(root); root = null; traversing(root);
         */

        /*
         * mirrorTree(root); System.out.println("====mirror tree");
         * traversing(root);
         */

        levelTraversing(root);

        // printAllPath(root);

        levelOrderTraversingSpiralForm(root);
    }

    static void printAllPath(BTNode root) {
        System.out.println("\n==========");
        System.out.print("Print all Path");
        BTNode[] path = new BTNode[10];
        printPath(root, path, 0);

    }

    /**
     * All paths from root node to each leaves node
     * @param node current node
     * @param path path till the current node
     * @param pathLen position to add the current node
     */
    static void printPath(BTNode node, BTNode[] path, int pathLen) {
        if (node == null)
            return;
        else {
            path[pathLen++] = node;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            System.out.print("\npath ");
            for (int i = 0; i < pathLen; i++)
                System.out.print(" " + path[i].getData());
        } else {
            printPath(node.getLeft(), path, pathLen);
            printPath(node.getRight(), path, pathLen);
        }
    }

    static void countOfNodes(BTNode node) {
        if (node == null)
            return;
        count++;
        countOfNodes(node.getLeft());
        countOfNodes(node.getRight());

    }

    static void insertNode(BTNode root) {
        BTNode node1 = new BTNode();
        node1.setData(2);

        BTNode node2 = new BTNode();
        node2.setData(3);

        root.setLeft(node1);
        root.setRight(node2);

        BTNode node11 = new BTNode();
        node11.setData(4);

        BTNode node12 = new BTNode();
        node12.setData(5);

        node1.setLeft(node11);
        node1.setRight(node12);

        BTNode node21 = new BTNode();
        node21.setData(6);

        BTNode node22 = new BTNode();
        node22.setData(7);

        node2.setLeft(node21);
        node2.setRight(node22);

        /*
         * BTree node211 = new BTree(); node211.setData(8);
         *
         * node21.setLeft(node211);
         *
         * BTree node2112 = new BTree(); node2112.setData(9);
         *
         * node211.setRight(node2112);
         */

    }

    static void insertNode2(BTNode root) {
        BTNode l1 = new BTNode();
        l1.setData(2);

        BTNode r1 = new BTNode();
        r1.setData(3);

        root.setLeft(l1);
        root.setRight(r1);

        BTNode l1left = new BTNode();
        l1left.setData(4);

        BTNode l1right = new BTNode();
        l1right.setData(5);

        l1.setLeft(l1left);
        l1.setRight(l1right);

        BTNode r1left = new BTNode();
        r1left.setData(6);

        BTNode r1right = new BTNode();
        r1right.setData(8);

        r1.setLeft(r1left);
        r1.setRight(r1right);

    }

    static void traversing(BTNode root) {
        System.out.println("===============");
        System.out.println("Preorder Traversing");
        preOrderTraverse(root);
        preOrderWithStack(root);
        inOrderWithStack(root);
        postOrderWithStack(root);

        /*
         * System.out.println("==============="); System.out.println(
         * "Inorder Traversing"); inOrderTraverse(root);
         *
         * System.out.println("==============="); System.out.println(
         * "Postorder Traversing"); postOrderTraverse(root);
         */

    }

    static void identicalTrees(BTNode node1, BTNode node2) {
        if (node1 == null && node2 == null) {
            isIdenticalTree = true;
        } else if (node1 != null && node2 != null) {
            if (node1.getData() == node2.getData()) {
                isIdenticalTree = true;
                identicalTrees(node1.getLeft(), node2.getLeft());
                identicalTrees(node1.getRight(), node2.getRight());
            } else {
                isIdenticalTree = false;
                return;
            }
        } else {
            isIdenticalTree = false;
            return;
        }
    }


    static void preOrderWithStack(BTNode root) {
        BTNode[] stack = new BTNode[10];
        int top = 0;
        stack[top] = root;
        System.out.println("\n\nPreorder with stack");
        while (top != -1) {
            BTNode node = stack[top];
            top--;
            System.out.print(node.getData() + " ");
            if (node.getRight() != null)
                stack[++top] = node.getRight();
            if (node.getLeft() != null)
                stack[++top] = node.getLeft();
        }
    }

    static void inOrderWithStack(BTNode root) {
        BTNode[] stack = new BTNode[10];
        int top = -1;
        BTNode node = root;
        System.out.println("\n\nInorder with stack");
        while (true) {
            while (node != null) {
                stack[++top] = node;
                node = node.getLeft();
            }
            if (top == -1) {
                break;
            }
            node = stack[top--];
            System.out.print(node.getData() + " ");
            node = node.getRight();
        }
    }

    static void postOrderWithStack(BTNode node) {
        BTNode[] stack = new BTNode[10];
        int top = -1;
        System.out.print("\nPost order with stack\n");

        while (true) {
            while (node != null) {
                if (node.getRight() != null)
                    stack[++top] = node.getRight();
                stack[++top] = node;
                node = node.getLeft();
            }
            node = stack[top--];
            if (top != -1 && node.getRight() != null && node.getRight() == stack[top]) {
                top--;
                stack[++top] = node;
                node = node.getRight();
            } else {
                System.out.print(node.getData() + " ");
                node = null;
            }
            if (top == -1)
                break;

        }

    }

    static void preOrderTraverse(BTNode node) {
        if (node == null)
            return;
        if (node.getLeft() == null && node.getRight() == null) {
            leafeNodes++;
        }
        System.out.print(node.getData() + " ");
        preOrderTraverse(node.getLeft());
        preOrderTraverse(node.getRight());
    }

    static void inOrderTraverse(BTNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.getLeft());
        System.out.println(node.getData());
        inOrderTraverse(node.getRight());
    }

    static void postOrderTraverse(BTNode node) {
        if (node == null)
            return;
        postOrderTraverse(node.getLeft());
        postOrderTraverse(node.getRight());
        System.out.println(node.getData());
    }

    static int maxDepth(BTNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = maxDepth(node.getLeft());
        int rightDepth = maxDepth(node.getRight());
        if (leftDepth > rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }

    }

    /*
     * to delete a binary tree post order traversing is used.
     */

    static void deleteTree(BTNode node) {
        if (node == null) {
            return;
        }
        deleteTree(node.getLeft());
        deleteTree(node.getRight());
        System.out.println(" deleting node " + node.getData());
        node = null;
    }

    static void mirrorTree(BTNode node) {
        if (node == null)
            return;
        mirrorTree(node.getLeft());
        mirrorTree(node.getRight());

        BTNode temp = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);

    }

    static void levelTraversing(BTNode node) {
        // ArrayList<BTree> queue = new ArrayList<BTree>();
        BTNode queue[] = new BTNode[10];
        queue[0] = node;
        System.out.println("================");
        System.out.println("levelOrder Traversing");
        int i = 0, j = 0;
        while (queue[j] != null) {
            BTNode bTree = queue[j];
            System.out.print(" " + bTree.getData());
            if (bTree.getLeft() != null)
                queue[++i] = bTree.getLeft();
            if (bTree.getRight() != null)
                queue[++i] = bTree.getRight();

            j++;
        }

    }

    static void levelOrderTraversingSpiralForm(BTNode root) {
        System.out.println("\nLeve order in spiral form");
        BTNode leftStack[] = new BTNode[10];
        BTNode rightStack[] = new BTNode[10];
        int leftTop = -1;
        int rightTop = -1;
        if (root == null) {
            return;
        }
        rightStack[++rightTop] = root;

        while (leftTop != -1 || rightTop != -1) {
            if (leftTop != -1) {
                System.out.print(" " + leftStack[leftTop].getData());
                if (leftStack[leftTop].getLeft() != null) {
                    rightStack[++rightTop] = leftStack[leftTop].getLeft();
                }
                if (leftStack[leftTop].getRight() != null) {
                    rightStack[++rightTop] = leftStack[leftTop].getRight();
                }
                leftTop--;
            } else if (rightTop != -1) {
                System.out.print(" " + rightStack[rightTop].getData());
                if (rightStack[rightTop].getRight() != null) {
                    leftStack[++leftTop] = rightStack[rightTop].getRight();
                }
                if (rightStack[rightTop].getLeft() != null) {
                    leftStack[++leftTop] = rightStack[rightTop].getLeft();
                }
                rightTop--;
            }
        }
    }

}
