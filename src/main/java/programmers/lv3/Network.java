package programmers.lv3;

import java.util.*;

/**
 * 요구사항 : 네트워크 개수 리턴하기
 * 알고리즘 : union-find
 * why : 컴퓨터간 연결되있으면 같은 네트워크 영역으로 분리해야 하므로
 * how : 연결이 되었다면 작은 번호를 가진 컴퓨터가 네트워크 영역으로 취급되게 함.
 */
public class Network {
    static final int CONNECT = 1;
    int parents[];
    int parentsSize;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        parentsSize = n;
        init();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == CONNECT && !isEqualParentNode(i, j)) {
                    union(i + 1, j + 1);
                }
            }
        }
        /**
         * 부모노드 정리
         */
        for (int node = 1; node <= n; node++) {
            find(node);
        }
        Set<Integer> networks = new HashSet<>();
        for (int node = 1; node <= n; node++) {
            networks.add(parents[node]);
        }

        return networks.size();
    }

    private boolean isEqualParentNode(int i, int j) {
        return parents[i] == parents[j];
    }

    public void init() {
        parents = new int[parentsSize + 1];
        for (int i = 1; i <= parentsSize; i++) {
            parents[i] = i;
        }
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parents[b] = a;
        } else if (a > b) {
            parents[a] = b;
        }
    }

    public int find(int node) {
        if (parents[node] == node) {
            return node;
        }
        return parents[node] = find(parents[node]);
    }
}
