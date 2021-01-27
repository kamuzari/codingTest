package oneDay_twoSol.Greedy;

import java.util.*;

//https://www.acmicpc.net/problem/12018
public class Yonsei_TOTO {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");
        int N=Integer.parseInt(str[0]); // 과목 수
        int M=Integer.parseInt(str[1]); // 보유 마일리지
        int[] Using_mileage =new int[N];

        for (int i = 0; i <N ; i++) {
            String str2[]=sc.nextLine().split(" ");
            int P=Integer.parseInt(str2[0]); // 신청한 사람 수
            int L=Integer.parseInt(str2[1]);
            String str3[]=sc.nextLine().split(" ");
            Integer temp[]=new Integer[P];
            for (int j = 0; j <P ; j++) {
                temp[j]=(Integer.parseInt(str3[j]));
            }

            if(P<L)
            {
                Using_mileage[i]=1;
                continue;
            }
            else {
                Arrays.sort(temp,Collections.reverseOrder());
                Using_mileage[i]=temp[(L-1)];
            }
        }
//        System.out.println(Arrays.toString(Using_mileage));
        // 수강과목을 많이 신청하고 싶다. 최대한 적은 마일리지로 수강가능한 것부터. 가자
        Arrays.sort(Using_mileage);
        int cnt=0;

        for (int i = 0; i <N ; i++) {
            if(M-Using_mileage[i]>=0)
            {
                M-=Using_mileage[i];
                cnt++;
            }
            else
            {
                break;
            }
        }
        System.out.println(cnt);
    }
}
