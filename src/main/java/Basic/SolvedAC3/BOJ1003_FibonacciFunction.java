package Basic.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003_FibonacciFunction {
    static int arr[]=new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        while (testCase-->0){
            int n=Integer.parseInt(br.readLine());
            int one=fibo(n);
            int zero=fibo(n-1);
            sb.append(zero+" "+one+"\n");
        }
        System.out.println(sb);
    }
    public static int fibo(int n){
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else if(n<0){
            return 1;
        }else{
            if(arr[n]>0)
                return arr[n];
        }
        arr[n]=fibo(n-1)+fibo(n-2);
        return arr[n];
    }
}
