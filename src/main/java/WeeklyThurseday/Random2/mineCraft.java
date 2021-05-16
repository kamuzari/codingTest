package WeeklyThurseday.Random2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class mineCraft {
    static int n,m,inventory,land[][];
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
       n=sc.nextInt();
       m=sc.nextInt();
       inventory=sc.nextInt();
       land=new int[n][m];

       int ansT=(int) 1e9;
        int ansH=0;
        sc.nextLine();
       int max=-1,min=Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String str[]=sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                int a=Integer.parseInt(str[j]);
                land[i][j]=a;
                if(a>max)
                {
                    max=a;
                }
                else if(a<min)
                    min=a;
            }
        }
        for (int i = max; i >=min ; i--) {
            int target=i;
            int Temp_invent=inventory;
            int t=0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                   if(target!=land[j][k])
                    {
                        int gap=Math.abs(target-land[j][k]); // 음수가 나올수도 있음
                        if(target>land[j][k])
                        {
                            Temp_invent-=gap;
                            t+=gap; // 쌇는거 1초
                        }
                        else
                        {
                            Temp_invent+=gap;
                            t+=(2*gap); // 깍는거 2초
                        }
                    }
                }
            }
            if(Temp_invent<0)  // 보유하고 있는 invetory 보다 작으면 이루어질수 없는 경우 예외처리.
                continue;
            if(t<ansT)
            {
                ansT=t;
                ansH=target;
            }
        }
      bw.write(ansT+" "+ansH+"\n");bw.flush();bw.close();
    }
}
