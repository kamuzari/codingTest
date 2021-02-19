package oneDay_twoSol.Greedy2.InBook.Deepening;

import java.util.Arrays;
import java.util.Scanner;

public class cannotBeMadeMoney {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int coin[]=new int[n];
        
        for (int i = 0; i < n; i++) {
        coin[i]=sc.nextInt();    
        }
        Arrays.sort(coin);
        int target=1;
        for (int i = 0; i <n ; i++) {
            if(target<coin[i])
                break;
            target+=coin[i];
        }
        System.out.println(target);
    }
}
