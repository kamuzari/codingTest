package Basic.Tree.SegmentTree;

import java.io.*;
import java.util.StringTokenizer;

public class CompleteBinaryTree {

    private static int k;
    private static StringBuffer[] answer;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        int number=(int)Math.pow(2, k)-1;
        arr = new int[number];
        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < number; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        answer = new StringBuffer[k];
        for (int i = 0; i < k; i++) {
            answer[i]=new StringBuffer();
        }

        dfs(0, number -1,0);
        for (int i = 0; i < k; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void dfs(int start,int end,int top){
        if(top==k){
            return;
        }
        int mid=(start+end)/2;
        answer[top].append(arr[mid]+" ");
        dfs(start,mid-1,top+1);
        dfs(mid+1,end,top+1);
    }
}
