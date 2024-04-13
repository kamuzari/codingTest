package BaekJoon.단기간성장;

import java.util.Arrays;
import java.util.Scanner;

public class LostBracket {
	public static void main(String[] args) {
		String s = new Scanner(System.in).nextLine();
		String[] split = s.split("-");
		int answer = 0;
		for (int i = 0; i < split.length; i++) {
			int sum = Arrays.stream(split[i].split("\\+")).mapToInt(Integer::parseInt).sum();
			answer -= sum;
			if (i == 0) {
				answer *= -1;
			}
		}

		System.out.println(answer);
	}
}
