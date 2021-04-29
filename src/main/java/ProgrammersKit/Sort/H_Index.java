package ProgrammersKit.Sort;

import java.util.ArrayList;
import java.util.Comparator;

public class H_Index {
    public static void main(String[] args) {
        int arr[]={3,0,6,1,5};
        System.out.println(solution(arr));
    }
    public static  int solution(int[] citations) {
        int answer=0;
        ArrayList<Integer> list=new ArrayList<>();
        for (int val : citations) {
            list.add(val);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
//        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if(i>=list.get(i))
            {
                break;
            }
            else
                answer++;

        }
        return answer;
    }
}
