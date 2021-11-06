package Programmers.LV2;

import java.util.*;

public class NewsClustering {
    // 집합이라고 해서 집함을 쓰면 안되는 문제 : 다중 집합에 중복된 수가 들어가 있으며 합집합도 똑같음.
    List<String> set1=new ArrayList<>();
    List<String> set2=new ArrayList<>();
    public int solution(String str1, String str2) {
        makingSet(str1,str2);
        List<String> inter=new ArrayList<>();
        List<String> union=new ArrayList<>();
        for(String s:set1){
            if(set2.remove(s)){
                // 교집합
                inter.add(s);
            }
            union.add(s);
        }
        for(String s: set2){
            union.add(s);
        }
        double similar=0;
        if(union.size()==0){
            similar=1;
        }else{
            similar=(double)inter.size()/(double)union.size();
        }
        return (int)(similar*65536);
    }
    public void makingSet(String s1,String s2){
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();
        for(int i=0; i<s1.length()-1; i++){
            char a=s1.charAt(i);
            char b=s1.charAt(i+1);
            if(isAlphabetic(a) && isAlphabetic(b)){
                set1.add(a+""+b);
            }
        }
        for(int i=0; i<s2.length()-1; i++){
            char a=s2.charAt(i);
            char b=s2.charAt(i+1);
            if(isAlphabetic(a) && isAlphabetic(b)){
                set2.add(a+""+b);
            }
        }
    }
    public boolean isAlphabetic(char a){
        return Character.isAlphabetic(a);
    }
}
