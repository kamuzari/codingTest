package Alone.AlgorithmFoundation.Backtracking;

import java.util.Arrays;

public class sumSet {
    static int arr[];
    static int searchVal;
    static int[] space ;
    public static void main(String[] args) {
        searchVal = 13;
        /*
         * 1. sorting
         * 2. */
        arr = new int[]{
                4, 3, 6, 5
        };
        space=new int[arr.length];
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        sumset(-1,0,18);

    }

    static void sumset(int i, int weight, int total) {
        if (promising(i,weight,total)) {
            if (searchVal==weight) {
                System.out.println("Found");
                print();
            }
            else
            {
                space[i+1]=arr[i+1];
                sumset(i+1,weight+arr[i+1],total-arr[i+1]);
                space[i+1]=0;
                sumset(i+1,weight,total-arr[i+1]);

            }
        }
    }

    static boolean promising(int i,int weight,int total) {
        if(weight+total>=searchVal && (weight==searchVal || weight+arr[i+1]<=searchVal))
            return true;
        return false;
    }

    static void print() {
        for (int i = 0; i < space.length; i++) {
            if (space[i] != 0)
                System.out.print(space[i] + " ");
        }
        System.out.println();
        ;
    }

}
