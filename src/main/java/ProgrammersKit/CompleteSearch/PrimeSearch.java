package ProgrammersKit.CompleteSearch;

public class PrimeSearch {
    public static void main(String[] args) {
//        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    static boolean[] prime;
    static int depth = 0;
    static char[] ch;
    static char temp[];
    static boolean visited[];
    static int primeCnt = 0;

    public static int solution(String numbers) {
        int answer = 0;
        ch = numbers.toCharArray();
        prime = eratostenes();
        for (int i = 1; i <= numbers.length(); i++) {
            depth = i;
            temp = new char[i];
            visited = new boolean[ch.length];
            pick(0);
        }
        return primeCnt;
    }

    static void pick(int cnt) {
        if (cnt == depth) {
            String ans = "";
            for (int i = 0; i < temp.length; i++) {
                ans += temp[i];
            }
            int res = Integer.parseInt(ans);
            if (!prime[res]) {
                prime[res]=true;
                primeCnt++;
            }
            return;
        }
        for (int i = 0; i < ch.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[cnt] = ch[i];
                pick(cnt + 1);
                visited[i] = false;
            }
        }
    }

    static int n = 9999999;

    static boolean[] eratostenes() {
        boolean[] arr = new boolean[n + 1];
        arr[0] = arr[1] = true;
        for (int i = 2; i * i < n + 1; i++) {
            for (int j = i * i; j < n + 1; j += i) {
                arr[j] = true;
            }
        }
        return arr;
    }


}
