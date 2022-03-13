package Programmers.kakao2022;

public class ArrowMatch {

    /*
    모든 과녘 점수에 대하여 각 선수의 최종 점수를 계사한다.
    최종 점수가 높은 선수를 우승자로 결정(같은 경우 어피치 우승)

    ** 라이언이 어피치를
    가장 큰 점수차이로 이기기 위해 n발의 화살을 어떤 과녘에 점수에 맞혀야 하는지를 구하려한다.**

    - main logic
     * 어떻게 하면 어피치와 가장 큰 점수차가 나게 할 수 있을지(완전 탐색:=백트래킹)
     *


    단 가장 큰 점수 차이로 우승할 수 있는 방법이 여러가지일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를
    RETRUN 해야 한다.

    */
    static final int[] NO_ANSWER = {-1};
    static final int MATCH_MAX_SIZE = 11;
    static int N;
    static int lions[], apeach[];
    static int answer[];
    static int maxDiff = -1;

    public int[] solution(int n, int[] info) {
        lions = new int[MATCH_MAX_SIZE];
        apeach = info;
        N = n;
        dfs(0);
        return maxDiff == -1 ? NO_ANSWER : answer;
    }

    public void dfs(int depth) {
        if (depth == N) {
            int diff = calculateDiff();
            if (diff > 0) {
                if (diff >= maxDiff) {
                    answer = lions.clone();
                    maxDiff = diff;
                }
            }
            return;
        }
        for (int match = 0; match < MATCH_MAX_SIZE && lions[match] <= apeach[match]; match++) {
            lions[match]++;
            dfs(depth + 1);
            lions[match]--;
        }
    }

    public int calculateDiff() {
        int apeachScore = 0, lionScore = 0;
        for (int point = 0; point < MATCH_MAX_SIZE; point++) {
            if (apeach[point] == 0 && lions[point] == 0) {
                continue;
            } else {
                if (apeach[point] >= lions[point]) {
                    apeachScore += (10 - point);
                } else {
                    lionScore += (10 - point);
                }
            }
        }
        return lionScore - apeachScore;
    }

}
