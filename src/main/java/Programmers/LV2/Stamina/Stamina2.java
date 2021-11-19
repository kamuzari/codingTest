package Programmers.LV2.Stamina;
// bitCount 방문 처리
public class Stamina2 {
    int v = 0;
    int answer = 0;

    public static void main(String[] args) {
        Stamina2 s = new Stamina2();
        System.out.println(s.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        dfs(0, k, dungeons);
        return answer;
    }

    public void dfs(int cnt, int curHP, int[][] dun) {
        for (int i = 0; i < dun.length; i++) {
            if ((v & (1 << i)) == 0) {
                int needHP = dun[i][0];
                if (curHP < needHP) continue;
                if (curHP - dun[i][1] < 0) continue;
                v |= (1 << i);
                int cur = curHP - dun[i][1];
                dfs(cnt + 1, cur, dun);
                v ^= (1 << i);
            }

        }
        answer = Math.max(answer, cnt);
    }
}
