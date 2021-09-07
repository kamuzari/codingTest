package tues_thurs_sat._202104._20210429;

import java.util.ArrayList;
import java.util.Collections;

public class MaxMin {
    public static void main(String[] args) {

    }
    public String solution(String s) {
        String answer = "";
        String str[]=s.split(" ");
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0; i<str.length; i++)
        {
            arr.add(Integer.parseInt(str[i]));
        }
        Collections.sort(arr);
        answer=String.valueOf(arr.get(0))+" "+String.valueOf(arr.get(1));

        return answer;
    }
}
