package kakaoInternship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Tuple {
    public static void main(String[] args) {
        String s="{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(solution(s));
    }
    public static int[] solution(String s)
    {
        int answer[];
        s=s.substring(2,s.length()-2).replace("},{","-");
        String arr[]=s.split("-");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length()-s2.length();
            }
        });
        ArrayList<String> list=new ArrayList<>();
        for (String s1 : arr) {
            String sub[]=s1.split(",");
            for (String s2 : sub) {
                if(!list.contains(s2))
                {
                    list.add(s2);
                }
            }
        }

        System.out.println(list);
        answer=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i]=Integer.parseInt(list.get(i));
        }
        return answer;
    }
}
