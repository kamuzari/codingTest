package oneDay_twoSol.Greedy2.InBook.Deepening;

import java.util.Scanner;

public class reverseString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char ch[]=str.toCharArray();
        int criteria=0;
        //0을 만드는 경우의 수
        //1로 만드는 경우의 수
        int wantZeroCnt=0;

        int wantOneCnt=0;

        if(ch[0]=='1')
            wantZeroCnt++;
        else
            wantOneCnt++;
        for (int i = 0; i < str.length()-1; i++) {
            if(ch[i]!=ch[i+1])
            {
                if(ch[i+1]=='1')
                    wantZeroCnt++;
                else
                    wantOneCnt++;
            }
        }
        System.out.println(Math.min(wantZeroCnt,wantOneCnt));

    }
}
