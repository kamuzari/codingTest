package Al_Study.기초수학3;

import java.util.Scanner;

public class 제곱ㄴㄴ수 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");
        long min=paser(str[0]);
        long max=paser(str[1]);
        long arr[]=new long[1000001];
        int cnt=0;
        for (long i = 2; i*i <=max ; i++) {
            long x=min/(i*i);
            if(min%(i*i)!=0)
            {
                x++;
            }
            while (x*(i*i) <= max){
                arr[(int) ((x*(i*i) - min))] = 1;
                x++;
            }
        }
        for (int i = 0; i <= max - min; i++) {
            if (arr[i] == 0)
                cnt++;
        }
                System.out.println(cnt);
    }

    public static Long paser(String str)
    {
        return Long.parseLong(str);
    }

}
