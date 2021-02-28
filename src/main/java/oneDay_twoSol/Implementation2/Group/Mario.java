package oneDay_twoSol.Implementation2.Group;

import java.util.Scanner;

public class Mario {
    public static void main(String[] args) {
        int mush[]=new int[10];
        Scanner sc =new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
         mush[i]=sc.nextInt();
        }
        int sum=0;
        for (int i = 0; i < 10; i++) {
            if(Math.abs(sum+mush[i]-100) <=Math.abs(sum-100))
                sum+=mush[i];
            else
                break;
        }
        System.out.println(sum);

    }
}
