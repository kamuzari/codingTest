package Thur_Sunday_aWeek_Al.RT._0512;

import java.util.*;

public class RankingSearch {
    public static void main(String[] args) {

    }
    static Map<String, List<Integer>> map=new LinkedHashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (int i = 0; i < info.length; i++) {
            makingKey(info[i]);
        }

        for (String s : map.keySet()) {
            List<Integer> list = map.get(s);
            Collections.sort(list);
            map.put(s,list);
        }

        for (int i = 0; i < query.length; i++) {
            String sql[]=query[i].split(" ");
            String key=sql[0]+sql[2]+sql[4]+sql[6];
            if(!map.containsKey(key))
            {
                answer[i]=0;
            }
            else
            {
                if(sql[7].equals("-"))
                {
                    answer[i]=map.get(key).size();
                }
                else
                {
                    int score=Integer.parseInt(sql[7]);
                    answer[i]=binarySearch(score,map.get(key));
                }
            }

        }
        return answer;
    }
    // java backend junior pizza  {40 ,110}
    // java backend junior -    {40}
    // java backend  -   pizza
    // -     -       -      -    {40}
    //   -   -        junior pizza {40,
     static void makingKey(String s) {
        String str[]=s.split(" ");

        String language[]={"-",str[0]};
        String occupation[]={"-",str[1]};
        String career[]={"-",str[2]};
        String food[]={"-",str[3]};
        int score=Integer.parseInt(str[4]);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <2 ; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        String key=language[i]+occupation[j]+career[k]+food[l];
                        if(!map.containsKey(key))
                        {
                            List<Integer> list=new ArrayList<>();
                            list.add(score);
                            map.put(key,list);
                        }
                        else
                        {
                            List<Integer> list = map.get(key);
                            list.add(score);
                            map.put(key,list);
                        }
                    }
                }
            }

        }

    }
        static int binarySearch(int score,List<Integer> arr)
        {
            int l=0;
            int r=arr.size();
            int m=0;
            while (l<r)
            {
                m=(l+r)/2;
                if(arr.get(m)>=score)
                {
                    r=m;
                }
                else
                {
                    l=m+1;
                }
            }
            return arr.size()-l;
        }
}
