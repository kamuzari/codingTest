package tues_thurs_sat._20210811;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {
    static class Node{
        private int idx;
        private String genres;
        private int playCnt;

        public Node(int idx,String genres, int playCnt) {
            this.idx=idx;
            this.genres = genres;
            this.playCnt = playCnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "genres='" + genres + '\'' +
                    ", playCnt=" + playCnt +
                    ", genrePriority=" +
                    '}';
        }
    }
    static Map<String,Integer> map=new LinkedHashMap<>();
    public static void main(String[] args) {
        String s[]=new String[]{"classic", "pop", "classic", "classic", "pop"};
        int p[]=new int[]{500, 600, 150, 800, 2500};
        solution(s,p);

    }
    public static int[] solution(String[] genres, int[] plays) {
        int len=genres.length;
        int[] answer = new int[len];
        List<Node> list=new ArrayList<>();
        for(int i=0; i<len; i++)
        {
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
            list.add(new Node(i,genres[i],plays[i]));
        }
        List<String> genrePriority = map.keySet().stream().sorted((s1, s2) -> map.get(s2) - map.get(s1)).collect(Collectors.toList());

        Map<String, List<Node>> collect = list.stream().collect(Collectors.groupingBy(node -> node.genres));

        for (String s : collect.keySet()) {
            collect.get(s).sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if(o1.playCnt== o2.playCnt)
                        return o1.idx-o2.idx;
                    return o2.playCnt-o1.playCnt;
                }
            });
        }
        List<Integer> result=new ArrayList<>();
        for (String s : genrePriority) {
            int cnt=0;
            for (Node node : collect.get(s)) {
                result.add(node.idx);
                cnt++;
                if(cnt==2)
                    break;
            }
        }
        int idx=0;
        answer=new int[result.size()];
        for (Integer val : result) {
            answer[idx++]=val;
        }
        return answer;
    }
}
