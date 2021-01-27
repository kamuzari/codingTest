package oneDay_twoSol.Greedy;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2891
public class Kayak_hugeWind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");
        int n=Integer.parseInt(str[0]); // 팀의 수
        int s =Integer.parseInt(str[1]); // 손상 카약의 수
        int r=Integer.parseInt(str[2]); // 카약을 더 가져온 팀의 수
        int team[]=new int[n+1]; // -1 손상 0 보통 1여분 있음.
        String str2[]=sc.nextLine().split(" ");
        for (int i = 0; i < s; i++) {
            team[Integer.parseInt(str2[i])-1]=-1;
        }
        // 손상된 배를 가지는 팀의 앞이나 뒤에 오게 하면 될것 같다.
        String str3[]=sc.nextLine().split(" ");
        for (int i = 0; i <r ; i++) {
            int index=Integer.parseInt(str3[i])-1;

            if(team[index]==-1) // 손상된 팀인데 여분을 가지는 팀이라면 그자리에서 씀.
            {
                team[index]=0; // 자기가 부서지면 자기거 쓰기 바로.
            }
            else
            {
                team[index]=1;
            }
        }
        // 위치 변경 x.
//        System.out.println(Arrays.toString(team));
        for (int i = 0; i <n ; i++) {
            if(i==0)
            {
                if(team[i]==-1)
                {
                    if(team[i+1]==1)
                    {
                        team[i]=0;
                        team[i+1]=0;
                    }
                    else
                        continue;
                }
            }
            else if(i==n-1)
            {
                if(team[i]==-1)
                {
                    if(team[i-1]==1)
                    {
                        team[i]=0;
                        team[i-1]=0;
                    }
                }
            }
            else
            {
                if(team[i]==-1)
                {
                    if(team[i-1]==1)
                    {
                        team[i-1]=0;
                        team[i]=0;
                    }
                    else if(team[i+1]==1)
                    {
                        team[i+1]=0;
                        team[i]=0;
                    }
                }
            }
        }
        int cnt=0;
        for (int i = 0; i <n ; i++) {
            if(team[i]==-1)
                cnt++;
        }
        System.out.println(cnt);

    }
}
