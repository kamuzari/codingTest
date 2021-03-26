package AL_CS_STUDY.RealTimeSolving.weekly13;

import java.util.Scanner;

public class Max_PrizeMoney {
    static int exchangeCnt;
    static int number[];
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int t=sc.nextInt();
        sc.nextLine();

        int cnt=1;
        while (t-->0)
        {
            String str[]=sc.nextLine().split(" ");
            len=str[0].length();
            visited=new boolean[len];
            number=new int[len];
            for (int i = 0; i < len; i++) {
                number[i]=str[0].charAt(i)-'0';
            }

            exchangeCnt=Integer.parseInt(str[1]);
            max_arr=new int[len];
            max=-1;
            exchangeDFS(0,0);
            sb.append("#"+cnt+++" ");
            for (int i = 0; i < len; i++) {
                sb.append(max_arr[i]);
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
    static int len;
    static int[] max_arr;
    static int max;
    public static void exchangeDFS(int cnt,int idx)
    {
        if(cnt==exchangeCnt)
        {
            int sum=0;
            int k=1;
            for (int i = len-1; i >=0; i--) {
                sum+=(k*number[i]);
                k*=10;
            }
            if(max<sum)
            {
                max=sum;
                max_arr=number.clone();
            }
            return;
        }
        for (int i = idx; i <len ; i++) {
            for (int j = i+1; j < len; j++) {
                if(number[i]<=number[j]) {
                    swap(i, j);
                    exchangeDFS(cnt + 1, i);
                    swap(j,i);
                }

            }
        }
    }
    static void swap(int a,int b)
    {
        int temp= number[a];
        number[a]=number[b];
        number[b]=temp;
    }
}
