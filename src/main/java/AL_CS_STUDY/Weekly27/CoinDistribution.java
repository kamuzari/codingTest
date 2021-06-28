package AL_CS_STUDY.Weekly27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinDistribution {
    static class Coin{
        private int value,number;

        public Coin(int value, int number) {
            this.value = value;
            this.number = number;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 3;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int sum=0;
            Coin coin[]=new Coin[n];
            boolean dp[]=new boolean[100_001];

            for (int i = 0; i < n; i++) {
                String str[] = br.readLine().split(" ");
                int coinValue = Integer.parseInt(str[0]);
                int quantity = Integer.parseInt(str[1]);

                coin[i]=new Coin(coinValue,quantity);
                sum+=(coinValue*quantity);
                for (int j = 1; j <= quantity; j++) {
                    dp[coinValue*j]=true;
                }
            }
            int half=sum/2;

            if(sum%2==1) { // 홀수
                System.out.println(0);
            }
            else if(dp[half])
            {
                // 이미 total금액의 절반을 만들 수 있으면 주면 끝.
                System.out.println(1);
            }

            else
            {
                // 다른 동전과 조합해서 half 금액을 만들어야 한다.
                dp[0]=true;

                for (int i = 0; i < n; i++) {
                    int value = coin[i].value;
                    int quantity = coin[i].number;

                    for (int j = half; j >=value; j--) {
                        if(dp[j-value])
                        {
                            for (int k = 1; k <=quantity; k++) {
                                if(j+value*k>half) break;
                                dp[j+value*k]=true;
                            }
                        }
                    }
                }
            System.out.println(dp[half]?1:0);
            }
        }
    }
}
