package samsung;

import java.util.Scanner;

public class NewInsomniaTreatment {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeat = Integer.parseInt(sc.nextLine());
		StringBuilder answer = new StringBuilder();
		for (int testCase = 1; testCase <= repeat; testCase++) {
			long result = 0;
			int n = Integer.parseInt(sc.nextLine());
			int bitFlag = 0;
			long orignal = n;

			int k = 1;
			while (true) {
				long sheep = k++ * orignal;
				bitFlag = active(sheep, bitFlag);
				int allActivate = (1 << 10) - 1;
				boolean isAllActivated = allActivate == bitFlag;
				if (isAllActivated) {
					result = sheep;
					break;
				}
			}

			answer.append("#")
				.append(testCase)
				.append(" ")
				.append(result)
				.append(System.lineSeparator());
		}

		System.out.println(answer);
	}

	private static int active(long sheep, int bitFlag) {
		char[] digits = String.valueOf(sheep).toCharArray();
		for (char digit : digits) {
			int number = digit - '0';
			int digitBit = (1 << number);
			bitFlag |= digitBit;
		}

		return bitFlag;
	}
}
