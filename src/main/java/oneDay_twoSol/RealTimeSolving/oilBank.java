package oneDay_twoSol.RealTimeSolving;

import java.util.Scanner;

//https://www.acmicpc.net/problem/13305
public class oilBank {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); // 도시의 개수
        long dist[]=new long[n];
        sc.nextLine();
        String str[]=sc.nextLine().split(" ");
        for (int i = 0; i <str.length; i++) {
            dist[i+1]=Long.parseLong(str[i]);
        }
//        System.out.println(Arrays.toString(dist));
        long cityOil_price[]=new long[n+1];
        String str2[]=sc.nextLine().split(" ");
        for (int i = 0; i <str2.length ; i++) {
            cityOil_price[i+1]=Long.parseLong(str2[i]);
        }
//        System.out.println(Arrays.toString(cityOil_price));

        //Logic
        long cost=0;

        long min_price=Long.MAX_VALUE;
        for (int i = 1; i <dist.length ; i++) {
            // 가다가 한번 건너뛰어서 보는데 여기가 기존 기름 가겨보다 싸면 여기에 기름 넣고 거리만큼 다음 장소로 ㄱㄱ.
            if(cityOil_price[i]>cityOil_price[i+1])
            {
                cost+=cityOil_price[i]*dist[i]; //10
                min_price=cityOil_price[i+1];
            }
            else
            {
                min_price=cityOil_price[i];
                long sum_dist=dist[i];
                for (int j = i+1; j <dist.length ; j++) {
                    if(min_price>cityOil_price[j])
                    {
                        cost+=min_price*sum_dist;
                        min_price=cityOil_price[j];
                        sum_dist=0;
                        break;
                    }
                    else
                    {
                        i++;
                        sum_dist+=dist[j];
                    }
                }
                cost+=sum_dist*min_price;
            }
        }
        System.out.println(cost);

    }
}
