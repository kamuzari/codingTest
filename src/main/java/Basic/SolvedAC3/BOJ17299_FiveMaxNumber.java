package Basic.SolvedAC3;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17299_FiveMaxNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        int cnt[]=new int[1_000_001];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }
        int answer[]=new int[n];
        Stack<Integer> s=new Stack<>()  ;
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && cnt[arr[i]]>cnt[arr[s.peek()]]){
                answer[s.pop()]=arr[i];
            }
            s.push(i);
        }

        while (!s.isEmpty()){
            answer[s.pop()]=-1;
        }

        Arrays.stream(answer).forEach((val)-> {
            try {
                bw.write(val+" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.flush();
        bw.close();
    }
}
