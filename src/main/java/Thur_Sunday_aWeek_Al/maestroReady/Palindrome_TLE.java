package Thur_Sunday_aWeek_Al.maestroReady;

import java.util.ArrayList;
import java.util.Scanner;

public class Palindrome_TLE {
    static ArrayList<Character>arr=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        sc.nextLine();
        while (t-->0)
        {
            String str=sc.nextLine();
            char c[]=str.toCharArray();
            boolean flag=true;
            int len=c.length;
            for (int i = 0; i <len ; i++) {
                arr.add(c[i]);
                if(arr.get(i)!=c[len-1-i])
                {
                    flag=false;
                }
            }
            if(!flag)
            {
                // 유사회문인지 함수 호출.
                if(isSimilar())
                {
                    sb.append(1+"\n");
                }
                else
                {
                    sb.append(2+"\n");
                }
            }
            else
            {
                sb.append(0+"\n");
            }
            arr.clear();
        }
        System.out.println(sb);
    }
    static boolean isSimilar()
    {
        // o(n^2) 초과.
        for (int i = 0; i <arr.size() ; i++) {
            int idx=i;
            char val=arr.get(i);
           arr.remove(i);
           ArrayList<Character> temp=new ArrayList<>();
            for (int j = arr.size()-1; j >=0; j--) {
                temp.add(arr.get(j));
            }

            boolean flag=true;
            for (int j = 0; j < arr.size(); j++) {
                if(arr.get(j)!=temp.get(j))
                {
                  flag=false;
                  break;
                }
            }
            if(!flag)
            {
                arr.add(i,val);
            }
            else
                return true;
        }

        return false;
    }
}
/*
7
abba 0
summuus 1
xabba 1
xabbay 2
comcom 2
comwwmoc 0
comwwtmoc1
* */
//xabbay
//comcom