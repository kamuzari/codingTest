package Basic.DataStructure;
import java.io.*;
import java.util.*;
public class Top {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        int ans[]=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        Stack<Node> s=new Stack<>();

        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());

            while (!s.isEmpty())
            {
                if(s.peek().val>arr[i])
                {
                    ans[i]=s.peek().idx;
                    break;
                }
                s.pop();
            }
            if(s.isEmpty())
            {
                ans[i]=0;
            }
            s.push(new Node(i+1,arr[i]));
        }

        for (int val : ans) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);

    }
    static class Node{
        int idx,val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
