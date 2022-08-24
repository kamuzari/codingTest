package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class AFromB {

    /**
     * idea :
     *  1. dp (동전문제) 처럼
     *  2. 완전탐색 (수빈이 찾기?) BFS
     */
    private static final int FAIL = -1;
    private static int a;
    private static int b;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        /* NOTE : OOM 실패 로직.
        int[] dist = getAnswer_OOM();
        System.out.println(dist[a] == 0 ? -1 : dist[a]);
        */
        int answer = getAnswer();
        System.out.println(answer);
    }

    /**
     * NOTE : OOM 원인
     *      1. overflow 19억 * 10 190억으로 int 형 범위를 초과함을 인진하고 원인을 잡고 로직을 재설계
     *      logic : 도착 지점에서 출발 지점으로 가는 로직으로 바꾸었으나..
     * result : OOM 여전히 발생.
     *         => 현재 원인을 queue 사용 ? 또는 불필요한 로직이 중복 수행되는 부분으로 보고있음.
     *
     * what : 원인은 distance 배열로 인한 메모리 초과였음..
     * how : distance 1차원 배열을 사용하지 않고 10으로 나눌 때 나머지:1, 2로 나누었을 때 나머지 0을 분기처리함과 동시에 변수 +1을

     */

    private static int getAnswer() {
        int answer = 0;
        while (true) {
            if (a == b) {
                answer++;
                break;
            }

            if (b < a) {
                return -1;
            }

            if (b % 2 == 0) {
                b /= 2;
                answer++;
            } else if (b % 10 == 1) {
                answer++;
                b /= 10;
            } else {
                return -1;
            }
        }
        return answer;
    }

    private static int[] getAnswer_OOM() {
        int dist[] = new int[b + 1]; // hint : 이것 없이 해결하는 로직이 필요해 보임.
        LinkedList<Integer> q = new LinkedList<>();
        dist[b] = 1;
        q.offer(b);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == a) {
                break;
            }
            if (cur % 2 == 0) {
                int next = cur / 2;
                dist[next] = dist[cur] + 1;
                q.offer(next);
            } else if (cur % 10 == 1) {
                int next = cur / 10;
                dist[next] = dist[cur] + 1;
                q.offer(next);
            }

        }
        return dist;
    }

    public static boolean isIndexOutOfYn(int nx) {
        return nx < a || nx > b;
    }

}
