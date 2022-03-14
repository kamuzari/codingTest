package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1991_TreeTravel {


    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int ASCII_DEFALUT_VALUE = (int) 'A';
    private static int[][] treeNodes;

    /**
     * Note : 이진 트리 : 최대 자식 개수가 2개인 특성 이용한 인접 리스트 방식 또 다른 아이디어 : 기본 트리 자료구조 삽입 및 탐색 방식
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        treeNodes = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int root = line[0].charAt(0) - ASCII_DEFALUT_VALUE;
            int left = line[1].charAt(0) - ASCII_DEFALUT_VALUE;
            int right = line[2].charAt(0) - ASCII_DEFALUT_VALUE;
            treeNodes[root][LEFT] = left;
            treeNodes[root][RIGHT] = right;
        }
        String answer = solution(n, treeNodes);
        System.out.println(answer);
    }

    private static StringBuilder answers;

    private static String solution(int n, int[][] treeNodes) {
        answers = new StringBuilder();
        preOrder(0, treeNodes);
        answers.append("\n");
        inOrder(0, treeNodes);
        answers.append("\n");
        postOrder(0, treeNodes);
        return answers.toString();
    }

    private static void postOrder(int cur, int[][] treeNodes) {
        if (isEmptyNode(cur)) {
            return;
        }

        postOrder(treeNodes[cur][LEFT], treeNodes);
        postOrder(treeNodes[cur][RIGHT], treeNodes);
        answers.append((char) (cur + ASCII_DEFALUT_VALUE));
    }

    private static void inOrder(int cur, int[][] treeNodes) {
        if (isEmptyNode(cur)) {
            return;
        }

        inOrder(treeNodes[cur][LEFT], treeNodes);
        answers.append((char) (cur + ASCII_DEFALUT_VALUE));
        inOrder(treeNodes[cur][RIGHT], treeNodes);
    }

    private static void preOrder(int cur, int[][] treeNodes) {
        if (isEmptyNode(cur)) {
            return;
        }

        answers.append((char) (cur + ASCII_DEFALUT_VALUE));
        preOrder(treeNodes[cur][LEFT], treeNodes);
        preOrder(treeNodes[cur][RIGHT], treeNodes);
    }

    public static boolean isEmptyNode(int cur) {
        return cur < 0;
    }

    // NOTE : 기본 트리 자료구조 삽입 및 탐색 방식
    static Node root = null;

    static class Node {

        private char idx;
        private Node left = null;
        private Node right = null;

        public Node(char idx) {
            this.idx = idx;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    static final char NULL = '.';

    public static void insert(char idx, char left, char right) {
        if (root == null) {
            root = new Node(idx);
            if (left != NULL) {
                root.setLeft(new Node(left));
            }
            if (right != NULL) {
                root.setRight(new Node(right));
            }
        } else {
            searchNode(root, idx, left, right);
        }
    }

    private static void searchNode(Node parent, char idx, char left, char right) {
        if (parent == null) {
            return;
        } else if (parent.idx == idx) {
            if (left != NULL) {
                parent.setLeft(new Node(left));
            }

            if (right != NULL) {
                parent.setRight(new Node(right));
            }
        } else {
            searchNode(parent.left, idx, left, right);
            searchNode(parent.right, idx, left, right);
        }
    }

}
