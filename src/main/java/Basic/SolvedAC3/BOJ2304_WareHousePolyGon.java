package Basic.SolvedAC3;
/*
가장 작은 넓이를 갖게 만들려면 어떻게 할까?
-> 기둥을 가장
*/

import java.io.*;
import java.util.*;

public class BOJ2304_WareHousePolyGon {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node arr[] = new Node[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Node(x, y);
        }
        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x - o2.x;
            }
        });
        Node curTop = arr[0];
        int answer = 0;
        int maxX = 0;

        for (int i = 1; i < n; i++) {
            if (curTop.y <= arr[i].y) {
                answer += (arr[i].x - curTop.x) * curTop.y;
                curTop = arr[i];
                maxX = i;
            }
        }
        curTop = arr[n - 1];
        for (int i = n-2; i >= maxX; i--) {
            if (curTop.y <= arr[i].y) {
                answer += (curTop.x - arr[i].x) * curTop.y;
                curTop = arr[i];
            }
        }
        answer += curTop.y ;
        System.out.println(answer);
    }
}
/*
5
1 11
2 11
3 11
4 11
5 11
: 55
3
1 3
2 2
3 3

5
13 4
6 5
4 3
11 3
9 5

3
0 1
0 1
0 1
*/
