package programmers.mockquestions.bundle31;

public class DifferentBitsLessThan2 {
	public static void main(String[] args) {
		DifferentBitsLessThan2 p = new DifferentBitsLessThan2();
		p.solution(new long[] {7,11});
	}

	public long[] solution(long[] numbers) {
		long nums[] = numbers;
		long[] answer = new long[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				answer[i] = nums[i] + 1;
			} else {
				StringBuilder result = new StringBuilder();
				String binary = Long.toBinaryString(nums[i]);

				if (!binary.contains("0")) { // 전부 1일떄
					result.append("10");
					result.append(binary.substring(1));
				} else {
					int zero = binary.lastIndexOf("0");
					result.append(binary.substring(0, zero) + "1");
					int one = binary.indexOf("1", zero);
					result.append(0);
					result.append(binary.substring(one + 1));
				}
				answer[i] = Long.parseLong(result.toString(), 2);
			}
		}
		return answer;
	}
}
