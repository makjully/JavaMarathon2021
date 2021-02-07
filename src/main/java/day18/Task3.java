package day18;

public class Task3 {
    public static void main(String[] args) {

        Node root = new Node(20);
        addBranch(14, root);
        addBranch(23, root);
        addBranch(11, root);
        addBranch(5, root);
        addBranch(8, root);
        addBranch(16, root);
        addBranch(18, root);
        addBranch(15, root);
        addBranch(22, root);
        addBranch(27, root);
        addBranch(24, root);
        addBranch(150, root);

        dfs(root); // 5 8 11 14 15 16 18 20 22 23 24 27 150

    }

    public static void dfs(Node node) {
        if (node.getLeft() != null) {
            if (node.getValue() > node.getLeft().getValue()) {
                dfs(node.getLeft());
            }
        }

        System.out.print(node + " ");

        if (node.getRight() != null) {
            if (node.getValue() < node.getRight().getValue()) {
                dfs(node.getRight());
            }
        }
    }

    public static void addBranch(int value, Node parent) {
        while (true) {
            if (value < parent.getValue()) {
                if (parent.getLeft() != null) {
                    parent = parent.getLeft();
                } else {
                    parent.setLeft(new Node(value));
                    break;
                }
            } else if (value > parent.getValue()) {
                if (parent.getRight() != null) {
                    parent = parent.getRight();
                } else {
                    parent.setRight(new Node(value));
                    break;
                }
            }
        }
    }
}