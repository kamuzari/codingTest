package mon_wed_fri.RT20210329;

public class starSubSequence {
    public static void main(String[] args) {
        int a[]={0};
        int b[]={5,2,3,3,5,3};
        int c[]={0,3,3,0,7,2,0,2,2,0};
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));
    }
    public static int solution(int[] a) {
        int answer = 0;

        int cnt[]=new int[a.length+1];
        for (int i = 0; i < a.length; i++) {
            cnt[a[i]]++;
        }

        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i]*2<=answer)
                continue;
            int s=0;
            for (int j = 0; j < a.length-1; j++) {
                if((a[j]==i || a[j+1]==i )&&(a[j]!=a[j+1]))
                {
                    s+=2;
                    j++;
                }
            }
            answer=Math.max(answer,s);
        }
        return answer;
    }

    // a의 길이가 짝수인지 홀수인지.
    /*
    짝수이면, n-2 개 뽑고 완탐. max값이 안나오면 다시 n-2*2 ....
    홀수이면 n-1 개 뽑고 완탐..
    * */
}
