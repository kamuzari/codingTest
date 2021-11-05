package Programmers.ProgrammersKit.Hash;

import java.util.*;

public class BestAlbum {

    public static void main(String[] args) {

        String g[] = {"classic", "pop", "classic", "classic", "pop"};
        int p[] = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(g, p)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        HashMap<String,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }

        List<String> keyset=new ArrayList<>(map.keySet());
        keyset.sort((s, s2) -> map.get(s2)-map.get(s));

        for (String s : keyset) {
            HashMap<Integer,Integer> map2=new LinkedHashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if(s.equals(genres[i]))
                    map2.put(i,plays[i]);
            }
            List<Integer> list2=new ArrayList<>(map2.keySet());
           list2.sort(new Comparator<Integer>() {
               @Override
               public int compare(Integer a, Integer b) {
                   if(map2.get(b)-map2.get(a)==0)
                       return a-b;
                   return map2.get(b)-map2.get(a);
               }
           });
            int cnt=0;
            for (Integer val : list2) {
                if(cnt>1)
                {
                    break;
                }
                ans.add(val);
                cnt++;

            }

        }
        int answer[]=new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i]=ans.get(i);
        }
        return answer;
    }

}
