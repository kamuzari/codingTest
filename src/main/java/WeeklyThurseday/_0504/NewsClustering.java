package WeeklyThurseday._0504;

import java.util.*;

public class NewsClustering {
    public static void main(String[] args) {
      String s= "FRANCE"	;String ss="french";
      String s1= "aa1+aa2"	;String ss2="AAAA12";
        System.out.println(solution(s1,ss2));
    }
    static ArrayList<String> s1;
    static ArrayList<String> s2;
    public static  int solution(String str1, String str2) {
         s1=new ArrayList<>();
        s2=new ArrayList<>();
        making(str1,str2);
        Collections.sort(s1);
        Collections.sort(s2);
        ArrayList<String> union=new ArrayList<>();
        ArrayList<String> inter=new ArrayList<>();

        for (String s : s1) {
            if(s2.remove(s))
            {
                inter.add(s);
            }
            union.add(s);
        }
        for (String s : s2) {
            union.add(s);
        }
        double val=0;
        if(union.size()==0)
        {
            val=1;
        }
        else
        {
            val=(double) inter.size()/(double) union.size();
        }
        return (int)(val*65536);

    }
    static void making(String str1,String str2)
    {
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        for(int i = 0 ; i < str1.length() - 1 ; ++i){
            char ch = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);

            if(Character.isAlphabetic(ch) && Character.isAlphabetic(ch2)){
                s1.add(ch + "" + ch2);
            }
        }

        for(int i = 0 ; i < str2.length() - 1 ; ++i){
            char ch = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);

            if(Character.isAlphabetic(ch) && Character.isAlphabetic(ch2)){
                s2.add(ch + "" + ch2);
            }
        }
    }
}
