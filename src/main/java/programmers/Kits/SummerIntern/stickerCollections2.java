package programmers.Kits.SummerIntern;

public class stickerCollections2 {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1,3,2,5,4}));
        System.out.println(solution(new int[]{1,2}));
    }
    public static int solution(int sticker[]) {
        int answer = 0;
        int len=sticker.length  ;
        if(sticker.length==1)
        {
            return sticker[0];
        }
        int dp[]=new int[len];
        int dp2[]=new int[len];

        dp[0]=dp[1]=sticker[0];
        for (int i = 2; i < len-1; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+sticker[i]);
        }
        dp2[1]=sticker[1];
        for (int i = 2; i < len; i++) {
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+sticker[i]);
        }
        answer=Math.max(dp[len-2],dp2[len-1]);
        return answer;
    }
}
