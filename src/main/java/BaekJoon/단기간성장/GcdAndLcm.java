package BaekJoon.단기간성장;

import java.util.Scanner;
import java.util.StringTokenizer;

public class GcdAndLcm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int gcdValue = getGCD(a, b);
		int lcmValue = getLcm(gcdValue, a, b);

		System.out.println(gcdValue);
		System.out.println(lcmValue);
	}

	static int getLcm(int gcd, int a, int b) {
		return a * b / gcd;
	}

	static int getGCD(int a, int b) {
		if (a < b) {
			int t = a;
			a = b;
			b = t;
		}

		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}

		return a;
	}
}
