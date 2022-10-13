package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoneBridge {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		int[] bridges = new int[n+2];

		bridges[1] = 1;
		bridges[2] = 2;

		for (int i = 3; i <= n+1; i++) {
			bridges[i] = bridges[i - 2] + bridges[i - 1];
		}

		System.out.println(bridges[n+1]);
	}
}
