package thisCodingTest.Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class sortingDefinition {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Random random = new Random();

        int arr[] = new int[10];
        for (int i = 0; i < 10; i++) {
            int rand = random.nextInt(10);
            while (true) {
                if (map.containsKey(rand)) {
                    rand = random.nextInt(10);
                } else {
                    map.put(rand, 1);
                    arr[i] = rand;
                    break;
                }
            }

        }
        System.out.println(Arrays.toString(arr));

        System.out.println("선택 정렬\n" + Arrays.toString(select(arr)));

        System.out.println("삽입 정렬\n" + Arrays.toString(insert(arr)));
        // quick sample data
        /*
        int cnt=10;
        for (int i = 0; i < 10; i++) {
            arr[i]=cnt--;
        }
        int arr2[]={8,0,2,3};
        quick(arr2,0,3);
*/
        int temp[]=arr.clone();
        quick(temp,0,arr.length-1);
        System.out.println("퀵 정렬\n"+Arrays.toString(temp));
        System.out.println("계수 정렬\n" + Arrays.toString(countSort(arr)));
    }
    // O(n^2)
    static int[] select(int arr[]) {
        int temp[] = arr.clone();
//        System.out.println("처리 과정");
        for (int i = 0; i < temp.length; i++) {
            int min_idx = i;
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[min_idx] > temp[j]) {
                    min_idx = j;
                }
            }
            int tmp = temp[i];
            temp[i] = temp[min_idx];
            temp[min_idx] = tmp;
//            System.out.println(Arrays.toString(temp));
        }
        return temp;
    }
    //  O(n^2) or O(n)
    static int[] insert(int arr[]) {
        int temp[] = arr.clone();
//        System.out.println("처리 과정");
        for (int i = 1; i < temp.length; i++) {
            for (int j = i; j > 0; j--) {
                if (temp[j] < temp[j - 1]) {
                    int tmp = temp[j];
                    temp[j] = temp[j - 1];
                    temp[j - 1] = tmp;
//                    System.out.println(Arrays.toString(temp));
                } else break;
            }
        }
        return temp;
    }
    // O(n log n) or O(n^2)<987654321>
    static void quick(int arr[], int start, int end) {
        if (start >= end)
            return;
        int pivot = start;
        int left = start + 1;
        int right = end;
        while (left <= right) {
            while (left <= end && arr[pivot] >= arr[left]) {
                left++; // 큰거 찾을 때 까지
            }
            while (right > start && arr[pivot] <= arr[right]) {
                right--; // 작은 거 찾을 떄까지
            }
            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        quick(arr, start, right);
        quick(arr, right + 1, end);

    }
    //O(n+k)
    public static int[] countSort(int arr[]) {
        int temp[]=arr.clone();
        int count[]=new int[temp.length];
        for (int i = 0; i < arr.length; i++) {
            count[temp[i]]++;
        }
        int j=0;
        for (int i = 0; i < count.length; i++) {

            while (count[i]!=0)
            {
                temp[j]=i;
                j++;
                count[i]--;
            }
        }

        return temp;
    }
}
/*


 */
