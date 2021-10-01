package tues_thurs_sat._202109._20210930;

public class PGM17687_NotationOfN {
    public static void main(String[] args) {
        PGM17687_NotationOfN p = new PGM17687_NotationOfN();
        p.solution(2,4,2,1);
        p.solution(16,16,2,1);
    }

    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuffer total = new StringBuffer();
        total.append("0");
        int cnt = 1;
        while (total.length() < (t * m)+1) {
            StringBuffer sb = new StringBuffer();
            int num = cnt++;
            while (num != 0) {
                if (num % n >= 10) {
                    int val = num % n + 55;
                    String sub = Character.toString((char) val);
                    sb.append(sub);
                } else {
                    sb.append(num % n);
                }
                num /= n;
            }
            total.append(sb.reverse().toString());
        }
        StringBuffer answers=new StringBuffer();
        int count=1;
        p--;
        for (int i = 0; i < t; i++) {
          ;answers.append(total.charAt(p));
          p+=m;
        }
//        System.out.println("answers : "+answers);
        return answer;
    }
}
