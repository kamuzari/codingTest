package BaekJoon.tony.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchTree {
	static class Node {
		private int id;
		private Node left = null;
		private Node right = null;

		public Node(int id) {
			this.id = id;
		}

		public void addLeft(int id) {
			this.left = new Node(id);
		}

		public void addRight(int id) {
			this.right = new Node(id);
		}

	}

	private static Node root;

	/**
	 * 이진탐색트리의 전위 순회는 곧 데이터가 들어온 순서대로이다.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = reader.readLine();

			if (input==null || input.equals("")) {
				break;
			}

			int id = Integer.parseInt(input);
			if (root == null) {
				root = new Node(id);
			} else {
				searchAndInsert(root, id);
			}
		}

		postOrder(root);
	}

	private static void searchAndInsert(Node parent, int id) {
		if (parent.id < id) {
			if (parent.right == null) {
				parent.right = new Node(id);
			} else {
				searchAndInsert(parent.right, id);
			}
		} else {
			if (parent.left == null) {
				parent.left = new Node(id);
			} else {
				searchAndInsert(parent.left, id);
			}
		}
	}

	private static void postOrder(Node parent) {
		if (parent == null) {
			return;
		}

		postOrder(parent.left);
		postOrder(parent.right);
		System.out.println(parent.id);
	}
}
