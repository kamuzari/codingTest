package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5639_BinarySearchTree {

    static Node root = null;

    static class Node {

        private int key;
        private Node left;
        private Node right;

        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }

        public void insert(Node newNode) {
            if (this.key > newNode.key) {
                if (this.left == null) {
                    this.left = newNode;
                } else if (this.left != null) {
                    this.left.insert(newNode);
                }
            } else if (this.key < newNode.key) {
                if (this.right == null) {
                    this.right = newNode;
                } else if (this.right != null) {
                    this.right.insert(newNode);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String input = br.readLine();
            if(input==null ||input.equals(""))
                break;
            int key = Integer.parseInt(input);
            root.insert(new Node(key));
        }
        preOrder(root);
    }

    private static void preOrder(Node node) { // PreOrder: = root -> left -> right
        if (node == null) {
            return;
        }

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.key);
    }
}
