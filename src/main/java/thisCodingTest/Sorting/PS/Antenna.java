package thisCodingTest.Sorting.PS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Antenna {
    //    https://www.acmicpc.net/problem/18310
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        if(n%2==0)
            System.out.println(arr.get(n/2-1));
        else
        {
            System.out.println(arr.get(n/2));
        }
    }
}
