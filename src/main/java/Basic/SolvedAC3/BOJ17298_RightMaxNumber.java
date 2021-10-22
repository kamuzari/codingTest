package Basic.SolvedAC3;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298_RightMaxNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        Stack<Integer> s = new Stack<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        s.push(0);
        int answer[] =new int[n];
        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()]<arr[i]){
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
