package AL_CS_STUDY.Weekly13;

import java.util.Scanner;

public class CommonFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long gcd = sc.nextInt();
        long lcm = sc.nextInt();
        long xy = gcd * lcm;
        long a = gcd;
        long b = lcm;
        for (long i = 2 * gcd; i * i <= xy; i += gcd) {
            if (xy % i == 0) {
                long temp = xy / i;
                if (gcd(i, temp) == gcd) {
                    if (a + b > i + temp) {
                        a = i;
                        b = temp;
                    }
                }
            }
        }
        System.out.println(a + " " + b);

    }

    static long gcd(long a, long b) {
        while (b > 0) {
            long temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
