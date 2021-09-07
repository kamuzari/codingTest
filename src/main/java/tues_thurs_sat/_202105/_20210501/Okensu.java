package tues_thurs_sat._202105._20210501;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Okensu {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans[]=new int[n];
        Stack<Integer> s=new Stack<>()  ;
        for (int i = n-1; i > -1; i--) {

            while (!s.isEmpty())
            {
                if(s.peek()> arr[i]) {
                    ans[i] = s.peek();
                    break;
                }

                s.pop();
            }
            if(s.isEmpty())
                ans[i]=-1;

            s.push(arr[i]);
        }
        for (int val : ans) {
         bw.write(val+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
