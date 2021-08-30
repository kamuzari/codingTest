package AL_CS_STUDY.Weekly_20to30.Weekly26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KakaoMoney {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long a,b;
        long minB=Long.MAX_VALUE;
        long balance=0;

        boolean valid=true;
        long M=0; // 최소 출금 금액

        while (n-->0)
        {
            StringTokenizer st=new StringTokenizer(br.readLine()    );
            a=Long.parseLong(st.nextToken());
            b=Long.parseLong(st.nextToken());

            if(balance+a<0)
            {
                long temp=b-a-balance;
                if(b!=0 && b<minB)
                {
                    minB=b;
                }
                if(M==0)
                {
                    M=temp;
                }
                else
                {
                    M=GCD(M,temp);

                    if(M<=minB && minB!=Long.MAX_VALUE)
                    {
                        valid=false;
                        break;
                    }
                }
            }
            else
            {
                if(balance+a!=b)
                {
                    valid=false;
                    break;
                }
            }

            balance=b;
        }
        if(valid&&M!=0)
        {
            System.out.println(M);
        }
        else if(valid&& M==0)
        {
            System.out.println(1);
        }
        else
            System.out.println(-1);

    }
    public static long GCD(long a,long b)
    {
        while (b>0)
        {
            long temp=a;
            a=b;
            b=temp%b;
        }
        return a;
    }
}
