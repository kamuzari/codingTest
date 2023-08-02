package BaekJoon._자료구조구현.try3.tree;

public class BinarySearchTree {

	Node root = null;

	public BinarySearchTree() {
	}

	public void add(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}

		Node currnet = root;

		while (true) {
			if (currnet.isGraterThan(data)) {
				if (currnet.isEmptyLeft()) {
					currnet.connectLeft(data);
					break;
				}

				currnet = currnet.left;
			} else {
				if (currnet.isEmptyRight()) {
					currnet.connectRight(data);
					break;
				}

				currnet = currnet.right;
			}
		}

	}

	private boolean isExist(int data) {
		Node current = root;

		while (current != null) {

			if (current.isGraterThan(data)) {
				current = current.left;
			} else if (current.isRatherThan(data)) {
				current = current.right;
			} else {
				return true;
			}
		}

		return false;
	}

	public void remove(int data) {
		boolean isExist = isExist(data);

		if (!isExist) {
			throw new RuntimeException("not found data..");
		}

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
			if (current.isBothChild()) {
				int minimumValue = getMinimumDataByRightSubTree(current.right);
				current.replace(minimumValue);
				current.right = remove(current.right, current.data);
			} else if (current.isOneChild()) {
				if (current.isEmptyLeft()) {
					return current.right;
				} else {
					return current.left;
				}
			} else {
				return null;
			}
		}

		return current;
	}

	private int getMinimumDataByRightSubTree(Node node) {
		int minimumValue = node.data;
		Node currnet = node;
		while (true) {
			if (currnet.isEmptyLeft()) {
				break;
			}
			currnet = currnet.left;
		}

		return minimumValue;
	}

	class Node {
		int data;
		Node left = null;
		Node right = null;

		public Node(int data) {
			this.data = data;
		}

		public boolean isGraterThan(int data) {
			return this.data > data;
		}

		public boolean isEmptyLeft() {
			return this.left == null;
		}

		public boolean isEmptyRight() {
			return this.right == null;
		}

		public void connectLeft(int data) {
			this.left = new Node(data);
		}

		public void connectRight(int data) {
			this.right = new Node(data);
		}

		public boolean isRatherThan(int data) {
			return this.data < data;
		}

		public boolean isBothChild() {
			return !isEmptyLeft() && !isEmptyRight();
		}

		public boolean isOneChild() {
			return (!isEmptyLeft() && isEmptyRight()) || (isEmptyLeft() && !isEmptyRight());
		}

		public boolean isNotChild() {
			return isEmptyLeft() && isEmptyRight();
		}

		public void replace(int data) {
			this.data = data;
		}
	}

}
