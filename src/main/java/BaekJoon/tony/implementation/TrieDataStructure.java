package BaekJoon.tony.implementation;

import java.util.HashMap;
import java.util.Map;

public class TrieDataStructure {
	static class Node {
		Map<Character, Node> childs = new HashMap<>();

		private boolean isLast;

		public Node() {
			this.isLast = false;
		}

		public Map<Character, Node> getChilds() {
			return childs;
		}

		public boolean getIsLast() {
			return isLast;
		}

		public void activeIsLast() {
			this.isLast = true;
		}

		public void deActiveIsLast() {
			this.isLast = false;
		}
	}

	static class Trie {
		private Node root;

		public Trie() {
			this.root = new Node();
		}

		public void add(String word) {
			Node current = this.root;

			for (char key : word.toCharArray()) {
				Map<Character, Node> childs = current.getChilds();
				current = childs.computeIfAbsent(key, (v) -> new Node());
			}

			current.activeIsLast();
		}

		public boolean contains(String word) {
			Node current = this.root;

			for (char key : word.toCharArray()) {
				if (!current.getChilds().containsKey(key)) {
					return false;
				}
				current = current.getChilds().get(key);
			}

			return current.getIsLast();
		}

		public void delete(String word) {
			if (!this.contains(word)) {
				return;
			}

			delete(root, word, 0);
		}

		private void delete(Node cur, String word, int idx) {
			char key = word.charAt(idx);

			if (!cur.getChilds().containsKey(key)) {
				throw new RuntimeException(String.format("no value  [ '%c' ]", key));
			}

			Node child = cur.getChilds().get(key);

			if (idx == word.length() - 1) {
				child.deActiveIsLast();

				if (child.getChilds().isEmpty()) {
					cur.getChilds().remove(key);
				}
			} else {
				delete(child, word, idx + 1);

				if (!child.isLast && child.getChilds().isEmpty()) {
					cur.getChilds().remove(key);
				}
			}
		}
	}

	public static void main(String[] args) {

		Trie trie = new Trie();
		trie.add("PI");
		trie.add("PIE");
		trie.add("POW");
		trie.add("POP");

		System.out.println(trie.contains("POW"));
		System.out.println(trie.contains("PIES"));

		trie.delete("POP");
		System.out.println(trie.contains("POP"));
		System.out.println(trie.contains("POW"));
	}
}
