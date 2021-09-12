package Basic.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BinarySearchTree {
    static class Node {
        private int data;
        private Node left, right;

        public Node(int data) {
            this.data = data;
        }

        public void insert(int inputValue) {

            if (this.data < inputValue) {
                if (this.right == null) {
                    this.right = new Node(inputValue);
                } else if (this.right != null) {
                    this.right.insert(inputValue);
                }
            } else if (this.data > inputValue) {
                if (this.left == null) {
                    this.left = new Node(inputValue);
                } else if (this.left != null) {
                    this.left.insert(inputValue);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input=br.readLine();
            if(input==null||input.equals(""))
                break;
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);
    }

    public static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

}
