package programmers.pccp;

public class CollapseBill {
	public int solution(int[] wallet, int[] bill) {
		int answer = 0;

		while (true) {
			if (isPut(wallet, bill)) {
				break;
			}

			int a = bill[0];
			int b = bill[1];
			int[] temp = bill.clone();
			if (a >= b) {
				a /= 2;
				temp[0] = b;
				temp[1] = a;
			} else if (a < b) {
				b /= 2;
				temp[0] = b;
				temp[1] = a;
			}
			answer++;

			if (isPut(wallet, temp)) {
				break;
			}

			bill[0] = a;
			bill[1] = b;
		}

		return answer;
	}

	boolean isPut(int[] wallet, int[] bill) {
		return wallet[0] >= bill[0] && wallet[1] >= bill[1];
	}
}
