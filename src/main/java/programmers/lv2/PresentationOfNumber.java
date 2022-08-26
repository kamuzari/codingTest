package programmers.lv2;

public class PresentationOfNumber {

    public int solution(int n) {
        int answer = 0;
        int start = 1, end = 1, sum = 0;
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        while (true) {
            if (sum == n) {
                answer++;
                System.out.println(arr[end - 1]);
                sum -= arr[start++];
            }

            if (end > n && sum < n) {
                break;
            }

            if (sum < n) {
                sum += arr[end++];
            } else if (sum > n) {
                sum -= arr[start++];
            }
        }
        return answer;
    }

}
