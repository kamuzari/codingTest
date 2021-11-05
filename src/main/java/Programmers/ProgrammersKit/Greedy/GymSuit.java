package Programmers.ProgrammersKit.Greedy;

public class GymSuit {
    public static void main(String[] args) {
        int []lost={2,4};
        int []reserve={1,3,5};
        System.out.println(solution(5,lost,reserve));
        System.out.println((int)'A');
    }
    public static  int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int isSuit[]=new int[n+1];
        for (int i = 0; i < lost.length; i++) {
            isSuit[lost[i]]=2;
        }
        for (int i = 0; i < reserve.length; i++) {
            if(isSuit[reserve[i]]==2)
                isSuit[reserve[i]]=0;
            else if(isSuit[reserve[i]]==0)
                isSuit[reserve[i]]=1;
        }

        for (int i = 1; i < n+1; i++) {
            if(isSuit[i]==2)
            {
                if(i!=1 && isSuit[i-1]==1)
                {
                    isSuit[i-1]=0;
                    isSuit[i]=0;
                }
                else if(i!=n&&isSuit[i+1]==1)
                {
                    isSuit[i+1]=0;
                    isSuit[i]=0;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            if(isSuit[i]==0 || isSuit[i]==1)
                answer++;
        }

        return answer;
    }

}
