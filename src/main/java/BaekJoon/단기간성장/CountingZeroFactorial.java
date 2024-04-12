package BaekJoon.단기간성장;

import java.util.Scanner;

public class CountingZeroFactorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int answer = 0;
		while (n > 0) {
			answer += (n / 5);
			n /= 5;
		}
		
		System.out.println(answer);
	}
}
