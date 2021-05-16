package WeeklyThurseday.Greedy;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr =new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            arr.add(i);
        }

        if(arr.contains(3))
        {
            System.out.println("find");
            int index=arr.indexOf(3);
            System.out.println(index); // expectValue==2
        }
    }
}

