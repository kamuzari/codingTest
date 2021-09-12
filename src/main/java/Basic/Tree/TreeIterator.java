package Basic.Tree;

import java.util.*;
import java.io.*;

public class TreeIterator {
    static class Node {
        private String name;
        Node left, right;

        public Node(String name) {
            this.name = name;
        }

        public void leftConnect(Node left) {
            this.left = left;
        }

        public void rightConnect(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static Node root = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String rootName = st.nextToken();
            String leftName = st.nextToken();
            String rightName = st.nextToken();
            insertNode(rootName,leftName,rightName);
        }
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);

    }

    public static void insertNode(String name, String leftData, String rightData) {
        if (root == null) {
            root = new Node(name);

            if (leftData.equals(".")) {
                return;
            } else {
                root.leftConnect(new Node(leftData));
            }
            if (rightData.equals(".")) {
                return;
            } else {
                root.rightConnect(new Node(rightData));
            }
        } else {
            searchNode(root, name, leftData, rightData);
        }
    }

    private static void searchNode(Node root, String name, String leftData, String rightData) {
        if (root == null) {
            return;
        } else if (root.name.equals(name)) {
            if(!leftData.equals(".")) {
                root.leftConnect(new Node(leftData));
            }
            if(!rightData.equals("."))
            {
                root.rightConnect(new Node(rightData));
            }

        } else {
            searchNode(root.left, name, leftData, rightData);
            searchNode(root.right, name, leftData, rightData);
        }
    }

    public static void preOrder(Node cur) {
        if (cur != null) {
            System.out.print(cur.name);
            preOrder(cur.left);
            preOrder(cur.right);
        }
    }

    public static void inOrder(Node cur) {
        if (cur != null) {
            inOrder(cur.left);
            System.out.print(cur.name);
            inOrder(cur.right);
        }
    }

    public static void postOrder(Node cur) {
        if (cur != null) {
            postOrder(cur.left);
            postOrder(cur.right);
            System.out.print(cur.name);
        }
    }


}
