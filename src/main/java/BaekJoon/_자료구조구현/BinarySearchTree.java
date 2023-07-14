package BaekJoon._자료구조구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchTree {
	public BSTNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void add(int key) {
		BSTNode newNode = BSTNode.create(key);

		if (root == null) {
			root = newNode;
		} else {
			BSTNode candidate = searchCandidate(newNode);
			candidate.linkNode(newNode);
		}
	}

	private BSTNode searchCandidate(BSTNode newNode) {
		BSTNode cur = root;

		while (true) {
			if (cur.isGraterThan(newNode)) {
				if (!cur.isExitLeft()) {
					break;
				}
				cur = cur.getLeft();
			} else {
				if (!cur.isExitRight()) {
					break;
				}
				cur = cur.getRight();
			}
		}

		return cur;
	}

	public void delete(int data) {
		BSTNode deletingNode = getNode(data);

		if (deletingNode.isAllLinkEmpty()) {
			if (deletingNode.getData() == root.getData()) {
				root = null;
			} else {
				BSTNode parentNode = getParent(data);

				if (parentNode.isGraterThan(data)) {
					parentNode.deleteLeftLink();
				} else {
					parentNode.deleteRightLink();
				}
			}
		} else if (deletingNode.isFullLink()) {
			BSTNode candidate = getCandidate(deletingNode.getRight());

			if (candidate.isAllLinkEmpty()) {
				candidate.linkNode(deletingNode.getLeft());
				candidate.linkNode(deletingNode.getRight());
				deletingNode.removeAllLink();
			} else if (candidate.isExitRight()) {
				BSTNode candidateRightLink = candidate.getRight();
				BSTNode candidateParent = getParent(candidate.getData());

				if (candidateParent.getData() == deletingNode.getData()) {
					deletingNode.swapData(candidate);
					deletingNode.linkNode(candidate.getRight());
					candidate.removeAllLink();
				} else {
					candidateParent.linkNode(candidateRightLink);
					candidate.linkNode(deletingNode.getLeft());
					candidate.linkNode(deletingNode.getRight());
					deletingNode.linkNode(candidate.getRight());
				}

			}
		} else {
			if (deletingNode.isExitRight()) {
				BSTNode parent = getParent(data);
				if (parent.getData() == root.getData()) {
					root = deletingNode.getRight();
				}else{
					parent.linkNode(deletingNode.getRight());
				}
			} else if (deletingNode.isExitLeft()) {
				BSTNode parent = getParent(data);

				if (parent.getData() == root.getData()) {
					root = deletingNode.getLeft();
				} else {
					parent.linkNode(deletingNode.getLeft());
				}
			}
		}
	}

	// 오른쪽 서브트리에서의 가장 왼쪽 노드 찾기
	private BSTNode getCandidate(BSTNode rightNode) {
		BSTNode cur = rightNode;

		while (true) {
			if (cur.isExitLeft()) {
				cur = cur.getLeft();
			} else {
				break;
			}
		}

		return cur;
	}

	// 데이터가 존재한다는 가정하에 호출해야함.
	private BSTNode getParent(int data) {
		BSTNode cur = root;
		if (cur.getData() == data) {
			return cur;
		}

		while (true) {
			if (cur == null) {
				new RuntimeException("존재하지 않는 데이터입니다.");
			}

			if (cur.isGraterThan(data)) {
				if (cur.getLeft().getData() == data) {
					return cur;
				} else {
					cur = cur.getLeft();
				}
			} else {
				if (cur.getRight().getData() == data) {
					return cur;
				} else {
					cur = cur.getRight();
				}
			}
		}

	}

	public BSTNode getNode(int data) {
		BSTNode cur = root;

		while (true) {
			if (cur == null) {
				throw new RuntimeException("존재하지 않는 데이터입니다.");
			}

			if (cur.getData() == data) {
				return cur;
			}

			if (cur.isGraterThan(data)) {
				cur = cur.getLeft();
			} else {
				cur = cur.getRight();
			}
		}
	}

	public void inOrder(BSTNode node) {
		if (node == null)
			return;

		inOrder(node.getLeft());
		System.out.println(node.getData());
		inOrder(node.getRight());
	}

	public void postOder(BSTNode node) {
		if (node == null) {
			return;
		}

		postOder(node.getLeft());
		postOder(node.getRight());
		System.out.println(node.getData());

	}

	public static void main(String[] args) throws IOException {
		BinarySearchTree bst = new BinarySearchTree();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String input = reader.readLine();
			if (input == null || input.equals("")) {
				break;
			}

			int key = Integer.parseInt(input);
			bst.add(key);
		}

		bst.inOrder(bst.root);
		bst.delete(3);
		System.out.println("==================");
		bst.inOrder(bst.root);
		System.out.println("==================");
		bst.delete(5);
		bst.inOrder(bst.root);
		System.out.println("==================");
		bst.delete(4);
		bst.inOrder(bst.root);
		System.out.println("==================");
		bst.delete(1);
		bst.inOrder(bst.root);
		System.out.println("==================");
		bst.delete(2);
		bst.inOrder(bst.root);

	}
}

class BSTNode {
	private int data;
	private BSTNode left, right;

	private BSTNode(int data, BSTNode left, BSTNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public static BSTNode create(int data) {
		return new BSTNode(data, null, null);
	}

	public void linkNode(BSTNode node) {
		if (this.isGraterThan(node)) {
			this.left = node;
		} else {
			this.right = node;
		}
	}

	public boolean isExitLeft() {
		return this.left != null;
	}

	public boolean isExitRight() {
		return this.right != null;
	}

	public boolean isGraterThan(BSTNode other) {
		return isGraterThan(other.getData());
	}

	public boolean isGraterThan(int data) {
		return this.data > data;
	}

	public int getData() {
		return data;
	}

	public BSTNode getLeft() {
		return left;
	}

	public BSTNode getRight() {
		return right;
	}

	public boolean isFullLink() {
		return this.left != null && this.right != null;
	}

	public boolean isAllLinkEmpty() {
		return this.left == null && this.right == null;
	}

	public void deleteLeftLink() {
		this.left = null;
	}

	public void deleteRightLink() {
		this.right = null;
	}

	public void removeAllLink() {
		this.deleteRightLink();
		this.deleteRightLink();
	}

	public void swapData(BSTNode candidate) {
		this.data = candidate.data;
	}
}