package Al_Study.RealTimeSolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 아홉명의 난쟁이 들의 키 - (특정 두명의 키) = 100
 */
public class Seven_Dwarfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr.add(sc.nextInt());
            sum += arr.get(i);
        }
        Collections.sort(arr);
        Collections.reverse(arr);
        int first=0;
        int two=0;
        for (int i = 0; i < arr.size(); i++) {
            int temp=sum;
            if(two!=0)
                break;
            if (sum - arr.get(i) > 100 ) {
                temp-=arr.get(i);
                first=i;
                for (int j = i+1; j < arr.size(); j++) {
                    if (temp - arr.get(j)==100)
                    {
                        two=j;
                        break;
                    }
                }
            }
        }
        arr.remove(first);
        arr.remove(two-1);
        Collections.sort(arr);
        print(arr);
    }

    public static void print(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }


}
