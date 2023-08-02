package BaekJoon._자료구조구현.tree;

public class BinarySearchTree {
	public static void main(String[] args) {
		Bst binarySearchTree = new Bst();
		binarySearchTree.add(3);
		binarySearchTree.add(6);
		binarySearchTree.add(4);
		binarySearchTree.add(5);

		binarySearchTree.print();
		System.out.println();
		binarySearchTree.remove(3);
		System.out.println();
		binarySearchTree.print();

	}
	static class Bst {
		private Node root;

		public void add(int data) {
			if (root == null) {
				root = new Node(data);
				return;
			}

			Node current = getNode(data, root);
			current.link(data);
		}

		public void print() {
			if (root == null) {
				return;
			}

			inOrder(root);
		}

		public void remove(int data) {
			root = remove(root, data);
		}

		private Node remove(Node current, int data) {
			if (current == null) {
				return current;
			}

			if (current.isGraterThan(data)) {
				current.left = remove(current.left, data);
			} else if (current.isRatherThan(data)) {
				current.right = remove(current.right, data);
			} else {
				// 발견
				if (data != current.data) {
					throw new RuntimeException("not found resources");
				}

				if (current.isBothChild()) {
					int minimumValue = findMinimumValueByRightSubTree(current.right);
					current.replace(minimumValue);
					current.right = remove(current.right, current.data);
				} else if (current.isOneChild()) {
					if (current.isNotExistRight()) {
						return current.left;
					} else {
						return current.right;
					}
				} else if (current.isNotChild()) {
					return null;
				}
			}

			return current;
		}

		private int findMinimumValueByRightSubTree(Node right) {
			Node current = right;
			int minimumValue = right.data;
			while (current.isExistLeft()) {
				current = current.left;
				minimumValue = current.data;
			}

			return minimumValue;
		}

		private Node getNode(int data, Node current) {
			while (true) {
				if (current == null) {
					break;
				}

				if (current.isGraterThan(data)) {
					if (current.isNotExistLeft()) {
						break;
					}

					current = current.left;
				} else if (current.isRatherThan(data)) {
					if (current.isNotExistRight()) {
						break;
					}

					current = current.right;
				} else {
					throw new RuntimeException("not add duplication");
				}
			}
			return current;
		}

		private void inOrder(Node node) {
			if (node == null)
				return;

			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public boolean isGraterThan(int data) {
			return this.data > data;
		}

		public boolean isRatherThan(int data) {
			return this.data < data;
		}

		public boolean isNotExistLeft() {
			return this.left == null;
		}

		public boolean isNotExistRight() {
			return this.right == null;
		}

		public void link(int data) {
			Node newNode = new Node(data);

			if (this.isGraterThan(data)) {
				this.left = newNode;
			} else {
				this.right = newNode;
			}
		}

		public void replace(int data) {
			this.data = data;
		}

		public boolean isBothChild() {
			return this.left != null && this.right != null;
		}

		public boolean isOneChild() {
			return (this.left == null && this.right != null) || (this.left != null && this.right == null);
		}

		public boolean isNotChild() {
			return this.left == null && this.right == null;
		}

		public boolean isExistLeft() {
			return this.left != null;
		}
	}

}
