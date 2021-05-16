package WeeklyThurseday.silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// union find 도 가능하다. 해당 1 -> 3 이렇게 입력을 받으니 관계를 바로 맺어주면 됨. parent 에 (처음 초기화) parent[3]=1
public class permutationCycle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                arr.add(new ArrayList<>());
            }
            String str[] = sc.nextLine().split(" ");
            for (int i = 1; i < str.length + 1; i++) {
                arr.get(i).add(Integer.parseInt(str[i - 1]));
            }
            /*for (int i = 1; i < arr.size(); i++) {
                System.out.println(arr.get(i));
            }*/
            boolean visited[] = new boolean[n + 1];
            for (int i = 1; i < n+1; i++) {
                if(!visited[i])
                    Bfs(visited,i,arr);
            }
            System.out.println(cnt);
            cnt=0;
        }
    }
    static int cnt=0;
    static void Bfs(boolean visited[], int s, ArrayList<ArrayList<Integer>> arr) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int idx = q.poll();
            for (int i = 0; i < arr.get(idx).size(); i++) {
                if (!visited[arr.get(idx).get(i)]) {
                    q.offer(arr.get(idx).get(i));
                }
                visited[arr.get(idx).get(i)] = true;
            }

        }
        cnt++;
    }
/*
1
8
3 2 7 8 1 4 5 6
* */

}
