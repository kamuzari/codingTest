package saffy.ssafy.homework.daily06;

public class BinarySearchTree {
	static class BST {
		class Node {
			int key;
			Node left, right;

			public Node(int data) {
				key = data;
				left = right = null;
			}
		}

		Node root;

		public BST() {
			root = null;
		}

		void deleteKey(int key) {
			root = delete_Recursive(root, key);
		}

		Node delete_Recursive(Node root, int key) {
			if (root == null)
				return root;

			if (key < root.key)
				root.left = delete_Recursive(root.left, key);
			else if (key > root.key)
				root.right = delete_Recursive(root.right, key);
			else {
				if (root.left == null)
					return root.right;
				else if (root.right == null)
					return root.left;

				root.key = getMinimumNodeForRightSubTree(root.right);
				root.right = delete_Recursive(root.right, root.key);
			}

			return root;
		}

		int getMinimumNodeForRightSubTree(Node root) {
			int value = root.key;
			while (root.left != null) {
				value = root.left.key;
				root = root.left;
			}
			return value;
		}

		void add(int key) {
			root = add(root, key);
		}

		Node add(Node root, int key) {
			if (root == null) {
				root = new Node(key);
				return root;
			}
			//traverse the tree
			if (key < root.key)
				root.left = add(root.left, key);
			else if (key > root.key)
				root.right = add(root.right, key);

			return root;
		}

		void inorder() {
			inOrder(root);
		}

		// recursively traverse the BST
		void inOrder(Node root) {
			if (root != null) {
				inOrder(root.left);
				System.out.print(root.key + " ");
				inOrder(root.right);
			}
		}

		boolean isExist(int key) {
			root = search(root, key);
			if (root != null)
				return true;
			else
				return false;
		}

		//recursive insert function
		Node search(Node root, int key) {
			if (root == null || root.key == key)
				return root;
			if (root.key > key)
				return search(root.left, key);

			return search(root.right, key);
		}
	}

	public static void main(String[] args) {
		BST bst = new BST();
        /* BST tree example
              45
           /     \
          10      90
         /  \    /
        7   12  50   */

		bst.add(12);
		bst.add(5);
		bst.add(15);
		bst.add(3);
		bst.add(1);
		bst.add(13);
		bst.add(14);
		bst.add(17);
		bst.add(19);
		bst.add(18);
		System.out.println("show data(Left-root-right):");
		bst.inorder();
		System.out.println();
		bst.deleteKey(15);
		bst.inorder();
		bst.deleteKey(90);
		bst.inorder();
		bst.deleteKey(45);
		bst.inorder();
		System.out.println();
		System.out.println("Key 50 is Exist => :" + bst.isExist(50));
		System.out.println();
		System.out.println("Key 12 is Exist => :" + bst.isExist(12));
	}
}
