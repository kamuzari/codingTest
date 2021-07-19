package Basic.Sorting;

import java.io.*;
import java.util.Arrays;

public class Sorting {

    static int arr[];
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        arr=new int[n];
        len=n;
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
//        pickSorting();
//        selectionSorting();
        QuickSort(0,n-1);
        printArray();
    }

    private static void QuickSort(int s,int e) {
        if(s>=e) return;

        int pivot=s;
        int l=s+1;
        int r=e;
        while (l<=r)
        {
            while (l<=e && arr[l]<=arr[pivot])
                l++;
            while (r>s && arr[r]>=arr[pivot])
                r--;

            if(l>r)
            {
                // l이 outOfIdx 면 작은 값을 발견한 r의
                int temp=arr[pivot];
                arr[pivot]=arr[r];
                arr[r]=temp;
            }
            else
            {
                int temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
            }
        }
        QuickSort(s,r-1);
        QuickSort(r+1,e);

    }

    private static void selectionSorting() {
        for (int i = 1; i < len; i++) {
            for (int j = i; j >0 ; j--) {
                if(arr[j]<arr[j-1])
                {
                    int temp= arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                else break;
            }
        }
        printArray();
    }

    public static void pickSorting()
    {
        for (int i = 0; i <len; i++) {
            int minIdx=i;
            for (int j = i+1; j <len ; j++) {
                if(arr[minIdx]>arr[j])
                {
                    minIdx=j;
                }
            }
            int temp=arr[minIdx];
            arr[minIdx]=arr[i];
            arr[i]=temp;
        }
        printArray();
    }

    private static void printArray() {
        Arrays.stream(arr).forEach(System.out::println);
    }
}
