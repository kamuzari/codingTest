package AlgorithmFoundation.Backtracking;

public class N_Queen {
    class Queen {
        int x;
        int y;

        public Queen(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Queen{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

    }

    static int n;

    public static void main(String[] args) {
        n = 4;

        int arr[] = new int[n + 1]; // index-0 은 쓰지 않는다. index : 각 퀸의 행번호 , arr[index] :각 퀸들의 열번호(x축)

        for (int i = 1; i <= n; i++) {

            arr[1] = i;// 1번쨰 퀸의 x축을 기준으로 backtracking 을 한다.
            backtracking(arr, 1);
        }

    }
    // arr의 인덱스-값 : 퀸의 행(y축의 위치)-퀸의 열(x축 위치) 이자 퀸의 개수 그리하여 number가 4가 될 경우 해당 1,2,3,4 행의 퀸의 위치가 확정난 것임.
    public static void backtracking(int[] arr, int number) {
        if (n == number) {
            for (int i = 1; i <= n; i++) {
                System.out.println(i + "번쨰 queen 위치 " + i + " , " + arr[i]);
            }
            System.out.println();
        }
        else {
            for (int i = 1; i <= n; i++) {
                arr[number + 1] = i;
                if (promising(arr, number + 1)) {
                    // 해당 퀸의 위치가 공격범위에 들어가지 않는다면 이 부분을 통과함과 동시에 재귀 함수의 시작
                    backtracking(arr, number + 1);
                }

            }
        }
    }
    // 해당 퀸의 위치가 전체적으로 적절한지. 각 열에 위치한 퀸들의 위치가 적절한지.
    public static boolean promising(int[] arr, int x) {
        for (int i = 1; i < x; i++) {
            if (arr[x] == arr[i]) {
                //같은 x축 또는 열이 같은 값.. 공격당함.
                return false;
            }
            //대각선의 같은 축.
            if (Math.abs(x - i) == Math.abs(arr[i] - arr[x]))
                return false;
        }
        return true;
    }


}
