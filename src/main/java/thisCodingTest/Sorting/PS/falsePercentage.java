package thisCodingTest.Sorting.PS;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/42889
public class falsePercentage {
    public static void main(String[] args) {
        int arr[]={2, 1, 2, 6, 2, 4, 3, 3}  ;
        System.out.println(Arrays.toString(solution(5,arr)));;
    }
    public static int[] solution(int N, int[] stages) {
        int[] answer ;
        int arr[]=new int[N+1];
        int cnt[]=new int[N+1];
        for (int i = 0; i < stages.length; i++) {
            int a=stages[i];
            if(a>N)
                a=N;
            else
                cnt[a]++;

            while (a>0) {
                arr[a]++;
                a--;
            }
        }
        LinkedList<Node> list=new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
                list.offer(new Node(i,(double) cnt[i]/arr[i]));
        }
        Collections.sort(list);
       answer=list.stream().mapToInt(value -> value.idx).toArray();
        return answer;
    }
    static class Node implements Comparable<Node>{
        int idx;
        double percentage;

        public Node(int idx, double percentage) {
            this.idx = idx;
            this.percentage = percentage;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", percentage=" + percentage +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            if(percentage==o.percentage)
                return idx-o.idx;
            else {
                if(percentage<o.percentage)
                    return 1;
                else
                    return -1;
            }
        }
    }


    public static int[] solution2(int N, int[] stages) {
        List<Node> list = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            int now = 0;
            int clear = 0;

            for (int stage : stages) {
                if (i <= stage) {
                    clear += 1;
                }
                if (i == stage) {
                    now += 1;
                }
            }

            if (clear == 0) {
                list.add(new Node(i, 0));
            } else {
                list.add(new Node(i, (double) now / clear));
            }
        }

        Collections.sort(list);
        return list.stream().mapToInt(value -> value.idx).toArray();
    }
}
