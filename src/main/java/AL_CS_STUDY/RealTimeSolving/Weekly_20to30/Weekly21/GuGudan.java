package AL_CS_STUDY.RealTimeSolving.Weekly_20to30.Weekly21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuGudan {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(br.readLine());
        for (int i = 1; i <=t ; i++) {
            int n=Integer.parseInt(br.readLine());
            if(cheeck(n))
            {
                sb.append("#").append(i+" YES").append("\n");
            }
            else
                sb.append("#").append(i+" NO").append("\n");
        }
        System.out.println(sb);
    }
    static boolean cheeck(int number)
    {
        boolean flag=false;
        for (int i = 1; i <=9 ; i++) {
            if(number%i==0)
            {
                int b=number/i;
                if(b<10) {
                    flag=true;
                }
            }
        }
        return flag;
    }
}
/*
4
10
11
50
81
*/