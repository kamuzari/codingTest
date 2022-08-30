package programmers.mockquestions.bundle23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MakingAllZero {
	/**
	 * note:
	 *  - 트리의 조건으로만 주어진다 (사이클이 없고 간선의 개수가 n-1개를 만족함)
	 *  - 말단 노드부터 시작하여 0을 만들 수 있는지 있으면 그에 대한 최소 이동 수를 반환하라
	 *    - 말단 노드를 구별하기 위해 진입 차수가 필요
	 *    - 말단 노드 부터 방문 처리
	 *    - 정점의 가중치가 곧 움직이는 횟수 (단위는 1)
	 * @param a : 가중치
	 * @param edges : 간선
	 * @return 0을 만들수 있는 최소거리
	 */

	List<Integer>[] adjacency;
	boolean v[];
	int degrees[];
	long weights[];

	public long solution(int[] a, int[][] edges) {
		int answer = -1;
		int n = a.length;
		int sum = 0;
		adjacency = new ArrayList[n];
		v = new boolean[n];
		weights = new long[n];
		degrees = new int[n];

		for (int i = 0; i < n; i++) {
			weights[i] = a[i];
			sum += a[i];
			adjacency[i] = new ArrayList<>();
		}

		if(sum!=0) return answer;

		answer=0;

		for (int[] edge : edges) {
			int v1 = edge[0];
			int v2 = edge[1];

			adjacency[v1].add(v2);
			adjacency[v2].add(v1);
			degrees[v1]++;
			degrees[v2]++;
		}

		return getMoveCnt();
	}

	/**
	 * note: 위상정렬 처럼 진입차수가 1인 것만 queue 에 삽입
	 * @return
	 */
	private long getMoveCnt() {

		long answer=0;
		LinkedList<Integer> q=new LinkedList<>();
		for (int vertax = 0; vertax < degrees.length; vertax++) {
			if(degrees[vertax]==1){
				q.offer(vertax);
			}
		}

		while (!q.isEmpty()){
			Integer cur = q.poll();
			v[cur]=true;

			for (Integer next : adjacency[cur]) {
				if(v[next]) continue;

				degrees[next]--;
				weights[next]+= weights[cur];
				answer+=Math.abs(weights[cur]);

				if(degrees[next]==1)
					q.offer(next);
			}
		}

		return answer;
	}
}
