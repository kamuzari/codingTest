package BaekJoon.SolvedAC3;
import java.io.*;
public class BOJ17103_GoldBachPredication {


    private static boolean[] primes;
    static{
        int n=1_000_000;
        primes = new boolean[n+1];
        primes[0]=true;
        primes[1]=true;
        for (int i = 2; i*i<=n; i++) {
            if(!primes[i]){
                for (int j = i*i; j <=n ; j+=i) {
                    primes[j]=true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        StringBuffer answers=new StringBuffer();
        for (int i = 0; i < testCase; i++) {
            int n=Integer.parseInt(br.readLine());
            int answer=0;
            for (int j = 2; j <=n/2; j++) {
                if(!primes[j] && !primes[n-j]){
                    answer++;
                }
            }
            answers.append(answer+"\n");
        }
        System.out.println(answers);
    }
}
