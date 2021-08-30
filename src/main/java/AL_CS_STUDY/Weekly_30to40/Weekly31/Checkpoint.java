package AL_CS_STUDY.Weekly_30to40.Weekly31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Checkpoint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        int commonFactor=Math.abs(arr[0]-arr[1]);


        for (int i = 2; i <n ; i++) {
            commonFactor=GCD(commonFactor,Math.abs(arr[i-1]-arr[i]));
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 2; i <= commonFactor; i++) {
            if(commonFactor%i==0)
            {
               sb.append(i).append(" ");
            }
        }
        System.out.println(sb);

    }
    static int GCD(int a,int b)
    {
        while (b!=0)
        {
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}
