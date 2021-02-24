public class Test2 {
    public static void main(String[] args) {
        int n = 9;
//        System.out.println(solution(9));
//        System.out.println(solution(15));
        System.out.println(solution(41));
    }

    static int cnt = 0;
    static int min = Integer.MAX_VALUE;
    static int len=0;
    public static int solution2(int n) {
        int answer = 0;
        len=n;
        return min;
    }
    public static int solution(int n) {
        int answer = 0;
        len=n;
        check(n);
        return min;
    }

    public static void check(int n) {
        if (n == 0) {
            min = Math.min(min, cnt);
            cnt--;
            return;
        }
        for (int i = 1; i <=len; i++) {
            int pow = (int) Math.pow(i, 2);
            if (n - pow >= 0) {
                cnt++;
                check(n - pow);
            } else {
                cnt--;
               return;
            }
        }
    }
}
