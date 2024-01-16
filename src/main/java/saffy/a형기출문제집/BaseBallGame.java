package saffy.a형기출문제집;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BaseBallGame {
	private static final int INNING_COUNT = 9;
	private static final int HITTER_COUNT = 9;
	private static int n;
	private static int answer = 0;
	private static List<List<Integer>> inningResults;

	private static LinkedHashSet<Integer> hitterOrders = new LinkedHashSet<>();

	public static void main(String[] args) {
		requestInput();
		// 타자의 순서에 의해 득점의 영향을 받는다.
		decideOrders(0);
		System.out.println(answer);
	}

	private static void decideOrders(int depth) {

		if (hitterOrders.size() == HITTER_COUNT) {
			// 게임 시작
			int totalScore = play();
			answer = Math.max(answer, totalScore);
			return;
		}

		if (depth == 3) {
			hitterOrders.add(0);
			decideOrders(depth + 1);
			hitterOrders.remove(0);
		} else {
			for (int hitterNumber = 0; hitterNumber < HITTER_COUNT; hitterNumber++) {
				if (hitterOrders.contains(hitterNumber) || hitterNumber == 0) {
					continue;
				}

				hitterOrders.add(hitterNumber);
				decideOrders(depth + 1);
				hitterOrders.remove(hitterNumber);
			}
		}

	}

	private static int play() {
		int totalScore = 0;
		int nextOrder = 0;
		List<Integer> decidedOrders = hitterOrders.stream().collect(Collectors.toList());

		for (int inning = 0; inning < n; inning++) {
			int outCount = 0;
			boolean[] roo = new boolean[3];
			while (outCount!=3){
				List<Integer> hitterScores = inningResults.get(inning);
				Integer hitterNumber = decidedOrders.get(nextOrder);
				Integer hitScore = hitterScores.get(hitterNumber);
				switch (hitScore) {
					case 0:
						outCount++;
						break;
					case 1:
						if (roo[2]) {
							totalScore++;
						}
						roo[2] = roo[1];
						roo[1] = roo[0];
						roo[0] = true;
						break;
					case 2:

						if (roo[2]) {
							totalScore++;
							roo[2] = false;
						}

						if (roo[1]) {
							totalScore++;
							roo[1] = false;
						}

						roo[2] = roo[0];
						roo[1] = true;
						roo[0] = false;
						break;
					case 3:
						if (roo[0]) {
							totalScore++;
							roo[0] = false;
						}

						if (roo[1]) {
							totalScore++;
							roo[1] = false;
						}

						if (roo[2]) {
							totalScore++;
							roo[2] = false;
						}

						roo[2] = true;
						break;
					case 4:

						if (roo[0]) {
							totalScore++;
							roo[0] = false;
						}

						if (roo[1]) {
							totalScore++;
							roo[1] = false;
						}

						if (roo[2]) {
							totalScore++;
							roo[2] = false;
						}

						totalScore++;
						break;
				}

				nextOrder = (nextOrder + 1) % HITTER_COUNT;
			}
		}
		return totalScore;
	}

	private static void requestInput() {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		inningResults = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			inningResults.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < INNING_COUNT; j++) {
				int score = Integer.parseInt(st.nextToken());
				inningResults.get(i).add(score);
			}
		}
	}
}
