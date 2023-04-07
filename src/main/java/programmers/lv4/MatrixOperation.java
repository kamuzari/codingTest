package programmers.lv4;

import java.util.LinkedList;

public class MatrixOperation {
	/**
	 * 테스트 456 시간 초과
	 * 링크드리스트의 get(i)를 통한 접근은 최대 탐색까지 갈 수 있어
	 * 456이 시간초과가 난다. poll()을 이용해서 그때마다 데이터를 이동하고
	 * 지워주는 것이 좋다!
	 */
	public static void main(String[] args) {
		MatrixOperation matrixOperation = new MatrixOperation();
		matrixOperation.solution(new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}
		},new String[]{"Rotate","ShiftRow"});
	}

	public int[][] solution(int[][] rc, String[] operations) {

		int N = rc.length;
		int M = rc[0].length;

		LinkedList<Integer> l = new LinkedList<>();
		LinkedList<Integer> r = new LinkedList<>();
		LinkedList<LinkedList<Integer>> m = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			l.add(rc[i][0]);
			r.add(rc[i][M - 1]);
			m.add(new LinkedList<>());
			for (int j = 1; j < M - 1; j++) {
				m.get(i).add(rc[i][j]);
			}
		}

		for (String cmd : operations) {
			if (cmd.equals("Rotate")) {
				int val = l.pollFirst();
				m.peekFirst().offerFirst(val);

				val = m.peekFirst().pollLast();
				r.offerFirst(val);

				val = r.pollLast();
				m.peekLast().offerLast(val);

				val = m.peekLast().pollFirst();
				l.offerLast(val);
			} else {
				l.offerFirst(l.pollLast());
				r.offerFirst(r.pollLast());
				m.offerFirst(m.pollLast());
			}
		}

		int answer[][]=new int[N][M];

		/*
		아마 여기서 초과나지 않았나 싶음. n*m이라서 나는것도 있고 get을
		통해 접근해서 시간초과 남 4,5,6
		for(int i=0; i<N; i++){
			answer[i][0]=l.get(i);
			answer[i][M-1]=r.get(i);
			for(int j=1; j<M-1; j++){
				answer[i][j]=m.peekFirst().pollFirst();
			}
		}*/

		for(int i=0; i<N; i++){
			answer[i][0]=l.pollFirst();
			answer[i][M-1]=r.pollFirst();
			int j=1;
			for(int val: m.pollFirst()){
				answer[i][j++]=val;
			}
		}

		return answer;
	}
}
