package ru.koltunov.vitalii.hashtable;

import java.util.Scanner;

public class BST {

    private static final boolean debugMode = false;
    BSTNode root;

    public static void main(String[] args) {
//        simpleTest();
        scannerTest();
    }

    public static void simpleTest() {
        BST tree = new BST();
        tree.pop(3);
    }

    public static void scannerTest() {
        BST tree = new BST();
        Scanner scanner = new Scanner(System.in);
        int requests = scanner.nextInt();
        for (int i = 0; i <= requests; i++) {
            String cmd = scanner.nextLine();
            String[] s = cmd.split(" ");
            if (debugMode)
                System.out.println("   " + cmd);
            switch (s[0]) {
                case "push" -> tree.push(Integer.parseInt(s[1]));
                case "pop" -> tree.pop(Integer.parseInt(s[1]));
                case "find" -> {
                    if (tree.find(Integer.parseInt(s[1]))) {
                        debugPrintln("TRUE");
                    } else {
                        debugPrintln("FALSE");
                    }
                }
                case "get_min" -> debugPrintln(tree.getMin());
                case "get_max" -> debugPrintln(tree.getMax());
            }
        }
    }

    private static int outputLineNo = 0;
    private static void debugPrintln(String s) {
        outputLineNo++;
        if (debugMode) {
            System.out.print(outputLineNo + ": ");
        }
        System.out.println(s);
    }

    private static void debugPrintln(int i) {
        outputLineNo++;
        if (debugMode) {
            System.out.print(outputLineNo + ": ");
        }
        System.out.println(i);
    }

    public void push(int data) {
        BSTNode newElem = new BSTNode(data);
        if (root == null) {
            root = newElem;
            return;
        }
        push(root, newElem);
    }

    private void push(BSTNode rt, BSTNode newElem) {
        if (newElem.data <= rt.data) {
            if (rt.left == null) {
                rt.left = newElem;
            } else {
                push(rt.left, newElem);
            }
        } else {
            if (rt.right == null) {
                rt.right = newElem;
            } else {
                push(rt.right, newElem);
            }
        }
    }

    public void pop(int data) {
        if (root == null) {
            return;
        }
        if (data == root.data) {
            root = untie(root);
        } else {
            pop(root, data);
        }
    }

    private void pop(BSTNode parent, int data) {
        if (parent == null)
            return;
        if (parent.left != null && parent.left.data == data) {
            parent.left = untie(parent.left);
            return;
        }
        if (parent.right != null && parent.right.data == data) {
            parent.right = untie(parent.right);
            return;
        }

        if (data <= parent.data) {
            pop (parent.left, data);
        }
        else {
            pop (parent.right, data);
        }
    }

    /**
     * вывязывает узел <code>node</code>, и перевязывает его детей, чтобы сохранить BST
     *
     * @param node узел, который должен быть вывязан
     * @return узел, который будет вместо вывязанного
     */
    private BSTNode untie(BSTNode node) {
        if (node == null)
            return null;
        if (node.left != null && node.right != null) {
            BSTNode n = node.right;

            while (n.left != null) {
                n = n.left;
            }
            n.left = node.left;
            return node.right;
        } else if (node.left == null) {
            return node.right;
        } else {
            return node.left;
        }
    }

    public int getMin() {
        int result = 0;
        if (root == null) {
            return -1;
        }
        BSTNode n = root;
        if (n.left == null) {
            result = n.data;
        }
        while (n.left != null) {
            result = n.left.data;
            n = n.left;
        }
        return result;
    }

    public int getMax() {
        int result = 0;
        if (root == null) {
            return -1;
        }
        BSTNode n = root;
        if (n.right == null) {
            result = n.data;
        }
        while (n.right != null) {
            result = n.right.data;
            n = n.right;
        }
        return result;
    }

    public boolean find(int data) {
        return find(root, data);
    }

    private boolean find(BSTNode n, int data) {
        if (n == null) {
            return false;
        }
        if (n.data == data) {
            return true;
        }
        if (data <= n.data) {
            return find(n.left, data);
        }
        return find(n.right, data);
    }

    public void traverse() {
        System.out.print("tree = ");
        traverse(root);
        System.out.println();
    }

    private void traverse(BSTNode rt) {
        if (rt == null)
            return;
        traverse(rt.left);
        System.out.print(rt.data + " ");
        traverse(rt.right);
    }
}

class BSTNode {
    public int data;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
