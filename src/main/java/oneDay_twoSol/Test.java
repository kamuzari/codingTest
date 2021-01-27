package oneDay_twoSol;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int a[]=arr.clone();
        System.out.println(Arrays.toString(a));
        a[0]=100;
        System.out.println(arr);
        System.out.println(a);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(a));
        System.out.println(arr.equals(a));
        String str = "abcdefg";
        String s=str.substring(0,2);
        System.out.println(s);

    }
}
