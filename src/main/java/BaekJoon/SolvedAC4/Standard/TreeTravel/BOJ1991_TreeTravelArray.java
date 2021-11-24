package BaekJoon.SolvedAC4.Standard.TreeTravel;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1991_TreeTravelArray {
    static final int A_ASCII_VALUE=65;
    static int [][] nodes;
    private static StringBuilder answers;
/*
    이진 트리는 자식이 최대 2개인 노드 배열 [][2]
    := 아스키 코드 값을 통한 연산

*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        nodes=new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int root=st.nextToken().charAt(0)-A_ASCII_VALUE;
            int left=st.nextToken().charAt(0)-A_ASCII_VALUE;
            int right=st.nextToken().charAt(0)-A_ASCII_VALUE;
            nodes[root][0]=left;
            nodes[root][1]=right;
        }
        answers = new StringBuilder();
        preOrder(0);
        answers.append("\n");
        inOrder(0);
        answers.append("\n");
        postOrder(0);
        System.out.println(answers);
    }
    public static void preOrder(int parent){
        if(parent<0) return;
        else{
            answers.append((char)(parent+65));
            preOrder(nodes[parent][0]);
            preOrder(nodes[parent][1]);
        }
    }

    public static void inOrder(int parent){
        if(parent<0) return;
        else{
            inOrder(nodes[parent][0]);
            answers.append((char)(parent+65));
            inOrder(nodes[parent][1]);
        }
    }
    public static void postOrder(int parent){
        if(parent<0) return;
        else{
            postOrder(nodes[parent][0]);
            postOrder(nodes[parent][1]);
            answers.append((char)(parent+65));
        }
    }
}
