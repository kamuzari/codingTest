package Wed_aWeek_Study.Al_Study.BruteForce;

import java.util.*;

public class 마인크래프트 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");
        int n=transInt(str[0]); //세로
        int m=transInt(str[1]); // 가로
        int b=transInt(str[2]); // 내가 가지고 있는 블록의 수.
        int arr[][]=new int [n][m]; // 각 높이의 현황.
//        블록 제거 2초. 블록 놓기 1초.
        int ansTime=Integer.MAX_VALUE;
        int ansHeight=0;
        String s[]={};
        int max=-1;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <n ; i++) {
            s=sc.nextLine().split(" ");
            for (int j = 0; j <m ; j++) {
                arr[i][j]=transInt(s[j]);
                if(arr[i][j] >max)
                    max=arr[i][j];
                if(arr[i][j]<min)
                    min=arr[i][j];
            }
        }


        for (int i = max; i >=min ; i--) {
            // 모든 경우의 수를 다 해본다.
            int target=i; // 이 칸을 기준으로 쌓을 것인지 제거할 것인지 판단.
            int block=b;
            int time=0;

            for (int j = 0; j <n ; j++) {
                for (int k = 0; k < m; k++) {
                    if(arr[j][k]==target)
                        continue;
                    else
                    {
                        int gap=Math.abs(target-arr[j][k]);
                        if(target>arr[j][k])
                        {
                            // 쌓아올리는 것 1초이므로 목표 높이치와 현재 블록의 위치를 빼준 값.
                            block-=gap;
                            time+=gap;
                        }
                        else
                        {
                            // 제거는 2초가 걸리므로 해당 높이의 차이에서 2를 곱해준다.
                            block+=gap;
                            time+=(2*gap);
                        }
                    }
                }
            }
            // block 을 초과해서 사용하였으면 측정할 수 없는 것이다.
            if(block<0){
                continue;
            }
            if(time<ansTime)
            {
                ansTime=time;
                ansHeight=target;
            }
        }
        System.out.println(ansTime+" "+ansHeight);




    }

    static int transInt(String str)
    {
        return Integer.parseInt(str);
    }
}
