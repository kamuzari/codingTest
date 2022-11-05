package FAST_CAMPUS.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchTree {

	static Node root = null;

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		public void insert(Node node) {
			if (this.data > node.data) {
				if (this.left == null) {
					this.left = node;
				} else {
					this.left.insert(node);
				}
			} else if (this.data < node.data) {
				if (this.right == null) {
					this.right = node;
				} else {
					this.right.insert(node);
				}
			} else {
				throw new RuntimeException("BST =: 데이터의 중복을 허용하지 않습니다.");
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		root = new Node(Integer.parseInt(reader.readLine()));

		while (true) {
			String data = reader.readLine();

			if (data.equals("") || data == null) {
				break;
			}

			root.insert(new Node(
				Integer.parseInt(data)
			));
		}

		postOrder(root);
	}

	public static void postOrder(Node parent) {
		if (parent == null) {
			return;
		}

		postOrder(parent.left);
		postOrder(parent.right);

		System.out.println(parent.data);
	}

}
