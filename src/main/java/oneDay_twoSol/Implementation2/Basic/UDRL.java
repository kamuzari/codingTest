package oneDay_twoSol.Implementation2.Basic;

import java.util.Scanner;

public class UDRL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char cmd[] = new char[n];
        for (int i = 0; i < n; i++) {
            cmd[i] = sc.next().charAt(0);
        }
        int travler[] = new int[2];
        int y=0, x=0;
       int a=travler[0] = 0;
       int b=travler[1] = 0;
        for (int i = 0; i < n; i++) {

            switch (cmd[i]) {
                case 'U':
                    y = -1;
                    x = 0;
                    break;
                case 'D':
                    y = 1;
                    x = 0;
                    break;
                case 'R':
                    y = 0;
                    x = 1;
                    break;
                case 'L':
                    y = 0;
                    x = -1;
                    break;
            }
            if (a+y>=0 && b+x>=0&&a+y<n&& b+x<n)
            {
                a+=y; b+=x;
            }
        }
        System.out.println("a = " + (a+1));;
        System.out.println("b = " + (b+1));
    }
}
