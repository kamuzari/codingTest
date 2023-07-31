package BaekJoon._자료구조구현.try2.tree;

public class BinarySearchTreeImplementation {
	static class BinarySearchTree {
		private Node root;

		public BinarySearchTree() {
			this.root = null;
		}

		public void add(int data) {
			if (root == null) {
				this.root = new Node(data);
				return;
			}

			Node node = search(data);
			node.link(data);
		}

		public void remove(int data) {
			Node deletingNode = findNode(data);
			remove(root, deletingNode.getData());
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
				if (current.isNotExistChild()) {
					return null;
				} else if (current.isExistBothChild()) {
					int minimumData = getMinimumNode(current.right);
					current.change(minimumData);
					current.right = remove(current.right, current.data);
				} else {
					if (current.isEmptyLeft()) {
						return current.right;
					} else if (current.isEmptyRight()) {
						return current.left;
					}
				}

			}

			return current;
		}

		private int getMinimumNode(Node node) {
			int minValue = node.data;
			while (node.left != null) {
				minValue = node.left.data;
				node = node.left;
			}

			return minValue;
		}

		private Node search(int data) {
			Node current = root;

			while (true) {
				if (current == null) {
					break;
				}

				if (current.isGraterThan(data)) {
					if (current.isEmptyLeft()) {
						break;
					}

					current = current.left;
				} else {
					if (current.isEmptyRight()) {
						break;
					}

					current = current.right;
				}
			}

			return current;
		}

		public void print() {
			if (root == null) {
				return;
			}

			preOrder(root);
		}

		private Node findNode(int data) {
			Node cur = root;

			while (true) {
				if (cur == null) {
					new RuntimeException("not found resources..");
				}

				if (cur.data == data) {
					break;
				}

				if (cur.isGraterThan(data)) {
					cur = cur.left;
				} else {
					cur = cur.right;
				}
			}

			return cur;
		}

		private void preOrder(Node parent) {
			if (parent == null) {
				return;
			}

			preOrder(parent.left);
			System.out.println(parent.data);
			preOrder(parent.right);
		}
	}

	static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		private void link(int data) {
			Node newNode = new Node(data);

			if (this.isGraterThan(data)) {
				this.left = newNode;
			} else if (this.isRatherThan(data)) {
				this.right = newNode;
			}else{
				throw new RuntimeException("don't duplicate data");
			}
		}

		public boolean isGraterThan(int data) {
			return this.data > data;
		}

		public boolean isRatherThan(int data) {
			return this.data < data;
		}

		public boolean isEmptyLeft() {
			return this.left == null;
		}

		public boolean isEmptyRight() {
			return this.right == null;
		}

		public boolean isNotExistChild() {
			return this.isEmptyLeft() && this.isEmptyRight();
		}

		public boolean isExistBothChild() {
			return !this.isEmptyLeft() && !this.isEmptyRight();
		}

		public int getData() {
			return data;
		}

		public void change(int data) {
			this.data = data;
		}
	}

	/**
 	 *       1-> remove
	 *           4
	 *         2
	 *           3
	 *      2
	 *          4
	 *        2
	 *          3
	 *
	 *
	 */
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(5);
		bst.add(3);
		bst.add(9);
		bst.add(2);
		bst.add(4);
		bst.add(7);
		bst.add(10);
		bst.add(8);
		bst.print();

		System.out.println("=========");
		bst.remove(5);
		bst.print();
	}

}

