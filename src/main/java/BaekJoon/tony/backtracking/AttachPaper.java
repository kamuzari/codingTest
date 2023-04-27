package BaekJoon.tony.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class AttachPaper {
	static int n = 10, answer = Integer.MAX_VALUE;
	static int paper[][] = new int[n][n];
	static List<Integer> candiates = List.of(1, 2, 3, 4, 5);
	static int[] usings = new int[6];


	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean isExit=true;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				if(paper[i][j]==1){
					isExit=false;
				}
			}
		}
		if(isExit){
			System.out.println(0);
		}else{
			write(0, 0);
			System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		}

	}

	static void write(int cnt, int using) {
		if (cnt == 100) {
			answer = Math.min(using, answer);
			return;
		}

		int r = cnt / n;
		int c = cnt % n;

		if (paper[r][c] == 0 || paper[r][c]==-1) {
			write(cnt + 1, using);
		}else if(paper[r][c]==1) {
			for (Integer paperSize : candiates) {
				if (usings[paperSize] < 5 && isCover(paperSize, r, c)) {
					usings[paperSize]++;
					cover(paperSize, r, c);
					write(cnt + 1, using + 1);
					recover(paperSize, r, c);
					usings[paperSize]--;
				}
			}
		}
	}

	private static void recover(int paperSize, int y, int x) {
		for (int i = y; i < y + paperSize; i++) {
			for (int j = x; j < x + paperSize; j++) {
				paper[i][j] = 1;
			}
		}
	}

	private static void cover(int paperSize, int y, int x) {
		for (int i = y; i < y + paperSize; i++) {
			for (int j = x; j < x + paperSize; j++) {
				paper[i][j] = -1;
			}
		}
	}

	static boolean isCover(int paperSize, int y, int x) {
		for (int i = y; i < y + paperSize; i++) {
			for (int j = x; j < x + paperSize; j++) {
				if (isOutOfRange(i, j)) {
					return false;
				}

				if (paper[i][j] != 1) {
					return false;
				}

			}
		}

		return true;
	}

	static boolean isOutOfRange(int ny, int nx) {
		return ny < 0 || nx < 0 || ny >= n || nx >= n;
	}

}
