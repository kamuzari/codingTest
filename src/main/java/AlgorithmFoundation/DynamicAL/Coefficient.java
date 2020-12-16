package AlgorithmFoundation.DynamicAL;

public class Coefficient {
    static int arr[][];

    public static void main(String[] args) {
        System.out.println(coefficient(4, 1));
        print();
    }

    static int coefficient(int n, int k) {
        arr = new int[n + 2][n + 2];

        for (int i = 1; i <= n+1; i++) {
            for (int j = 1; j <= k+1; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }
        return arr[n+1][k+1];
    }

    static void print()
    {
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}