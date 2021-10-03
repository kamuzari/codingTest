package tues_thurs_sat._202110._20211002;

public class PGM12971_StickerCollection {
    public static void main(String[] args) {
        PGM12971_StickerCollection p = new PGM12971_StickerCollection();
        System.out.println(p.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
    }
    public int solution(int sticker[]) {
        int answer = 0;
        // dp [i] = ' i번 전까지의 스티커를 땐 총합
        int n=sticker.length;
        if(n==1)
            return sticker[0];
        int dp1[]=new int[n]; // 0번쨰를 강제로 떗을 경우. 1번쨰 스티커는 때지 못한다.
        dp1[0]=sticker[0];
        dp1[1]=sticker[0];
        for(int i=2; i<n-1; i++){
            dp1[i]=Math.max(dp1[i-1],dp1[i-2]+sticker[i]);
        }

        int dp2[]=new int[n]; // 0번째를 안떼고 1번은 필수로 뛸 수 있다.
        dp2[0]=0;
        dp2[1]=sticker[1];
        for(int i=2; i<n; i++){
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+sticker[i]);
        }
        return Math.max(dp1[n-2],dp2[n-1]);
    }
}
