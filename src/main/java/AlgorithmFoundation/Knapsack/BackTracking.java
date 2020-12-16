package AlgorithmFoundation.Knapsack;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BackTracking {
    static int W,maxProfit,n,Profit;
    static int w[],p[];
    static Boolean bestset[],include[];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt(); //item 개수
        W=sc.nextInt(); //  가방의 제한적인 무게.
        Profit=0;
        w=new int[n+1]; // weight array
        p=new int[n+1]; //profit array
        include=new Boolean[n+1]; // item notation array
        bestset=new Boolean[n+1]; // Optimize item notation array
        for (int i = 1; i <=n ; i++) {
            w[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        int sumW=0;
        int sumP=0;
        Knapsack(0, Profit,0);
        for (int i = 1; i <=n ; i++) {
            if(bestset[i]==true) // 최적으로 선택된 아이템들 가져오기.
            {
                sumW+=w[i];
                sumP+=p[i];
                System.out.println(w[i]+" - "+p[i]);
            }
        }
        System.out.println("total"+" -> "+sumW+" - "+sumP);




    }
    static void Knapsack(int i,int profit,int weight)
    {

        if(weight<=W && profit >maxProfit)
        {
            maxProfit=profit;
            for (int j = 1; j <=n ; j++) {
                bestset[j]=include[j];
            }
        }

        if(Promising(i,weight))
        {
            include[i+1]=true;
            Profit=profit+p[i+1];
            Knapsack(i+1,profit+p[i+1],weight+w[i+1]);

            include[i+1]=false;
            Profit=profit;
            Knapsack(i+1,profit,weight);
        }
    }

    static boolean Promising(int i,int weight)
    {
        int j,k;
        int total_weight;
        double bound;
        int o=1;
        if(weight>=W)
            return false;
        else
        {
            j=i+1;
            bound=Profit;
            total_weight=weight;

            while (j<=n && total_weight+w[j]<=W)
            {
                total_weight=total_weight+w[j];
                bound=bound+p[j];
                j++;
            }
            k=j;
            if(k<=n)
                bound=bound+(W-total_weight)*p[k]/w[k];

            return bound>maxProfit;
        }
    }

}
