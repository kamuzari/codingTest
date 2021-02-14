package Thur_Sunday_aWeek_Al.silver2;

import java.util.Scanner;

public class ballCollect {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char ch[]=new char[n];
        sc.nextLine();
        String str=sc.nextLine();
        ch=str.toCharArray();
        int rMove=0;int bMove=0;
        char last=ch[ch.length-1];
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]=='R')
                rMove++;
        }
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]=='B')
                bMove++;
        }
        int max=rMove > bMove ? bMove : rMove;
        System.out.println(max);


    }
}
