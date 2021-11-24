package BaekJoon.SolvedAC3;
import java.io.*;

public class BOJ9461_PadovanSequenceNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answers=new StringBuilder();
        int testCase=Integer.parseInt(br.readLine());
        while (testCase-->0){
            long arr[]=new long[101];
            arr[1]=1;
            arr[2]=1;
            arr[3]=1;
            int n=Integer.parseInt(br.readLine());
            for (int i = 4; i <=n ; i++) {
                arr[i]=arr[i-2]+arr[i-3];
            }
            answers.append(arr[n]).append("\n");
        }
        System.out.println(answers);

    }
}
