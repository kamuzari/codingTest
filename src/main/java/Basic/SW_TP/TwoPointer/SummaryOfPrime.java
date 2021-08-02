package Basic.SW_TP.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryOfPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> primes = primeExtracted(n);
        System.out.println("primes = " + primes);
        System.out.println("primes.size() = " + primes.size());
        int targetValue=n;
        int s=0,e=0;
        int len=primes.size();
        int sum=0;
        int answer=0;
        while (true)
        {
            if(sum>=targetValue)
            {
                sum-=primes.get(s++);
            }
            else if(e>len-1)
            {
                break;
            }
            else if(sum<targetValue)
            {
                sum+=primes.get(e++);
            }

            if(sum==targetValue)
            {
                answer++;
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append(answer);
        System.out.println(sb.toString());


    }

    private static List<Integer> primeExtracted(int n) {
        List<Integer> primes=new ArrayList<>();
        boolean temp[]=new boolean[n+1];
        Arrays.fill(temp, true);
        temp[0]=false;
        temp[1]=false;
        for (int i = 2; i*i <= n; i++) {
            if(temp[i]) {
                for (int j = i * i; j <= n; j += i) {
                    temp[j] = false;
                }
            }
        }
        for (int i = 2; i < temp.length; i++) {
            if (temp[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
