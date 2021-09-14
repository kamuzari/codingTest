package MakeOut.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OperatorPut {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static final int OPERTATOR_NUMBER=4;
    private static int[] numbers;
    private static int[] operators;
    private static int totalOperatorCnt;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        operators = new int[OPERTATOR_NUMBER];
        st=new StringTokenizer(br.readLine());
        totalOperatorCnt = 0;
        for (int i = 0; i < OPERTATOR_NUMBER; i++) {
            operators[i]=Integer.parseInt(st.nextToken());
            totalOperatorCnt += operators[i];
        }

        pick(0,numbers[0]);
        System.out.println(max);
        System.out.println(min);


    }
    static void pick(int cnt ,int sum)
    {
        if(cnt== totalOperatorCnt)
        {
            max=Math.max(sum,max);
            min=Math.min(sum,min);
            return;
        }
        for (int i = 0; i < operators.length; i++) {
            if(operators[i]!=0)
            {
                operators[i]--;
                int midValue=0;
                switch (i)
                {
                    case 0:
                        midValue=sum+numbers[cnt+1];
                        break;
                    case 1:
                        midValue= sum-numbers[cnt+1];
                        break;
                    case 2:
                        midValue=sum*numbers[cnt+1];
                        break;
                    case 3:
                        midValue=sum/numbers[cnt+1];
                        break;
                    default:
                        break;
                }
                pick(cnt+1,midValue);
                operators[i]++;
            }
        }
    }
}
