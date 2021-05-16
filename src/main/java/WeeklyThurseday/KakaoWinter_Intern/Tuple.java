package WeeklyThurseday.KakaoWinter_Intern;

import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        String s="{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s1="{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s2="{{4,2,3},{3},{2,3,4,1},{2,3}}";
//        solution(s);
//        solution(s1);
//        solution(s2);
        opt_solution(s1);
        opt_solution(s2);
        opt_solution(s);
    }

    public static int[] solution(String s)
    {
        s = s.substring(2, s.length()-2).replace("},{", "-");
//        System.out.println(s);
        String [] arr = s.split("-");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        ArrayList<Integer> list = new ArrayList<>();
        for(String temp : arr) {
            String [] val = temp.split(",");

            for(int i=0 ; i<val.length ; i++) {
                int num = Integer.valueOf(val[i]);

                if(!list.contains(num)) {
                    list.add(num);
                }
            }
        }

        int [] answer = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static int[] opt_solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();}); // 길이가 작은 순서대로.
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2))
                    answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}
