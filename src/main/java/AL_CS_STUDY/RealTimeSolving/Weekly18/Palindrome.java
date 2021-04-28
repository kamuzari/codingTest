package AL_CS_STUDY.RealTimeSolving.Weekly18;

import java.util.Scanner;

public class Palindrome {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
//        T=sc.nextInt();
		StringBuilder sb=new StringBuilder();
        char map[][];
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n=sc.nextInt();
            map=new char[8][8];
            for (int i = 0; i < 8; i++) {
                char ch[]=sc.next().toCharArray();
                map[i]=ch.clone();
//                System.out.println(Arrays.toString(map[i]));
            }
            int cnt=0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    boolean flag=true;
                    for (int k = 0; k < n/2; k++) {
                        if(j+k>=8 || j+n-k-1>=8)
                        {
                            // 범위 초과
                            flag=false;
                            break;
                        }
                        if(map[i][j+k]!=map[i][j+n-k-1])
                        {
                            flag=false;
                            break;
                        }
                    }
                    if(flag)
                    {
                        cnt++;
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    boolean flag=true;
                    for (int k = 0; k < n/2; k++) {
                        if(j+k>=8 || j+n-k-1>=8)
                        {
                            // 범위 초과
                            flag=false;
                            break;
                        }
                        if(map[j+k][i]!=map[j+n-k-1][i])
                        {
                            flag=false;
                            break;
                        }
                    }
                    if(flag)
                    {
                        cnt++;
                    }
                }
            }

            sb.append("#"+test_case).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
