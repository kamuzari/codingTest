package BaekJoon.SolvedAC4.BOJ1043_Lie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1043_Lie {
    static int parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }
        int m = Integer.parseInt(st.nextToken());
//        boolean know[]=new boolean[n+1];
        Set<Integer> know = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int knowPerson = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowPerson; i++) {
            int person = Integer.parseInt(st.nextToken());
            know.add(person);
        }
        List<Integer> parties[] = new List[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            parties[i] = new ArrayList<>();
            int prev = 0, next = 0;
            if (people > 0) {
                int val = Integer.parseInt(st.nextToken());
                parties[i].add(val);
                prev = val;
            }
            while (st.hasMoreTokens()) {
                int val = Integer.parseInt(st.nextToken());
                next = val;
                union(prev, val);
                parties[i].add(val);
                prev = val;
            }
        }
        Set<Integer> truth = new HashSet<>();
        for (int i = 1; i < n + 1; i++) {
            find(i);
        } // 초기화

        for (Integer trutePerson : know) {
            truth.add(parents[trutePerson]); // 진실 전파자 숙주
        }
        int answer = 0;
        for (List<Integer> party : parties) {
            boolean flag=true;
            for (Integer val : party) {
                if(truth.contains(parents[val])){
                    flag=false;
                    break;
                }
            }
            if(flag) answer++;
        }
        System.out.println(answer);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}
