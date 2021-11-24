package BaekJoon.SolvedAC4.Standard.TreeTravel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BOJ1991_TreeTravel {
    private static class Node {
        char key;
        Node left;
        Node right;

        public Node(char key) {
            this.key = key;
        }

        public void connectLeftNode(Node left){
            this.left=left;
        }
        public void connectRightNode(Node right){
            this.right=right;
        }
    }
    static Node root =null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            char root=st.nextToken().charAt(0);
            char left=st.nextToken().charAt(0);
            char right=st.nextToken().charAt(0);
            insert(root,left,right);
        }
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }
    public static void insert(char key,char left,char right){
        if(root ==null){
            root=new Node(key);
            if(left=='.') {
                return;
            }else{
                root.connectLeftNode(new Node(left));
            }
            if(right=='.'){
                return;
            }else{
                root.connectRightNode(new Node(right));
            }
        }else{
            searchAndInsert(root,key,left,right);
        }
    }
    public static void searchAndInsert(Node parent, char existKey, char left, char right){
        if(parent==null) {
            return;
        }else if(parent.key==existKey){
            if(left!='.'){
                parent.connectLeftNode(new Node(left));
            }
            if(right!='.'){
                parent.connectRightNode(new Node(right));
            }
        }else{
            searchAndInsert(parent.left,existKey,left,right);
            searchAndInsert(parent.right,existKey,left,right);
        }
    }
    public static void preOrder(Node parent){
        if(parent!=null) {
            System.out.print(parent.key);
            preOrder(parent.left);
            preOrder(parent.right);
        }
    }

    public static void inOrder(Node parent){
        if(parent!=null){
            inOrder(parent.left);
            System.out.print(parent.key);
            inOrder(parent.right);
        }
    }
    public static void postOrder(Node parent){
        if(parent!=null){
            postOrder(parent.left);
            postOrder(parent.right);
            System.out.print(parent.key);
        }
    }
}
