package AL_CS_STUDY.Weekly_30to40.Weekly37;

import java.util.Arrays;

public class ExteriorWallInspection {
    public static void main(String[] args) {
        int w[] = {1, 3, 4, 9, 10};
        int dist[] = {3, 5, 7};
        ExteriorWallInspection main = new ExteriorWallInspection();
        System.out.println(main.solution(12, w, dist));

    }

    int FRIEND_NUMBER = 0;
    int d[], w[], N;
    int min = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        Arrays.sort(dist);
        FRIEND_NUMBER = dist.length;
        N = n;
        d = dist;
        w = weak;
        for (int i = 0; i < weak.length; i++) {
            perm(1, i, 0);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void perm(int usedFriends, int startPosition, int visited) {
        if (usedFriends > FRIEND_NUMBER || usedFriends >= min)
            return;
        for (int i = 0; i < w.length; i++) {
            int nextPostion = (startPosition + i) % w.length;
            int diff = w[nextPostion] - w[startPosition];
            // 다음 위지가 시작점 을 돌아온 상태라면
            if (nextPostion < startPosition) {
                diff += N;
            }
            // 친구가 가는 거리보다 두 취약점 사이의 거리가 더 크면
            if (diff > d[d.length - usedFriends])
                break;

            visited = visited | 1 << nextPostion;
        }
        if (visited == (1 << w.length) - 1) {
            min = Math.min(usedFriends, min);
            return;
        }

        for (int i = 0; i < w.length; i++) {
            if ((visited & (1 << i)) != 0)
                continue;
            perm(usedFriends + 1, i, visited);
        }
    }
}
