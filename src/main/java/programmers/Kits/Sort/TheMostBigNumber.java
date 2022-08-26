package programmers.Kits.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class TheMostBigNumber {
    public static void main(String[] args) {
        int num[]={6,10,2};
        System.out.println(solution(num));
        int num2[]={3,30,34,5,9};
        System.out.println(solution(num2));
    }
    public  String solution2(int[] numbers) {
        String answer = "";
        String str[]=new String[numbers.length];
        for (int i = 0; i < str.length; i++) {
            str[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>() {
            public int compare(String s1,String s2)
            {
                return (s2+s1).compareTo(s1+s2); // 내림차순으로 정렬 가장 큰수가 맨 앞에 있어야 하므로..
            }
        });
        if(str[0].startsWith("0"))
        {
            answer+="0";
        }
        else
        {
            for(String s:str)
            {
                answer+=s;
            }
        }
        return answer;
    }
    public static String solution(int[] numbers)
    {
        String answer="";
        String s[]=new String[numbers.length];
        for (int i = 0; i <numbers.length ; i++) {
            s[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        System.out.println(Arrays.toString(s));
        if(s[0].startsWith("0"))
        {
            answer+="0";
        }
        else
        {
            for (String val : s) {
                answer+=val;
            }
        }
        return answer;
    }


}
