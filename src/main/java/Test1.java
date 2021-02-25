public class Test1 {
    public static void main(String[] args) {
        int k = 2;
        int off[][] = {{1, 0, 0, 0}, {0, 0, 0, 1}, {0, 0, 1, 0}, {0, 1, 1, 0}};
        System.out.println(solution(off,k));
    }

    public static int solution(int[][] office, int k) {
        int answer = 0;

        for (int i = 0; i < office.length - k+1; i++) {
            for (int j = 0; j < office.length-k+1; j++) {
                    int cnt = check(i, j, office, k);
                    answer = Math.max(answer, cnt);
            }
        }

        return answer;
    }

    static int check(int y, int x, int arr[][], int k) {
        int cnt = 0;
        for (int i = y; i < y + k; i++) {
            for (int j = x; j < x + k; j++) {
                if (arr[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }

}
