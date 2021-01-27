package Thur_Sunday_aWeek_Al.Greedy;

import java.util.ArrayList;
import java.util.Scanner;

// 가장 최근의 거를 사용하고 뒤늦은 순위를 뽑는다.
public class False_멀티탭_스케줄링 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");

        int n = parse(str[0]); //멀티탭 구멍의 개수
        int k = parse(str[1]); // 사용횟수.
        int K = k;
        String str2[] = sc.nextLine().split(" ");
//        int using[] = new int[k - n];
        ArrayList<Integer> using=new ArrayList<>();
        // 가장 최근에 사용하는 것은 뽑지 않고 더 나중에 사용되는 것을 뽑는다.
        ArrayList<Integer> arr = new ArrayList<>(); // 플러그 구멍의 배열

        // 3 8
        //1 1 1 2 3 4 5 6  반례 입력수.
        for (int i = 0; i < k; i++) {
            int x=Integer.parseInt(str2[i]);
            if(arr.size()<n){
                if(i==0)
                    arr.add(x);
                else {
                    if(arr.contains(x))
                    {
                        continue;
                    }
                    else
                    {
                        arr.add(x);
                    }
                }
            }
             else
                 using.add(x);
//                using[i - n] = Integer.parseInt(str2[i]);
        }
//        System.out.println(arr);
//        print(using);
        if(using.size()==0)
        {
            System.out.println(0);
        }
        else {
            int u_length = using.size();

            int cnt = 0;
            for (int i = 0; i < u_length; i++) {
                if (arr.contains(using.get(i))) {
                    // 플러그에 이미 꽃혀있다면 pass
                    continue;
                }
                System.out.println("콘센트에 꼽혀 있는 것들 :"+arr);
                System.out.println("꽂힐 것들:"+using);
                System.out.println("교체 대상 : " +using.get(i));
                // i번째는 이미 교체 대상이다.
                cnt++;
                int later = -1;
                boolean used[] = new boolean[n];
                // 안꽂혀 있다면 무엇을 뺄지 정해야함. 가장 나중에 사용하는 것을 뽑자. (뒤에 출연을 하지 않으면 에외처리 해줘야한다.)
                for (int p = 0; p < arr.size(); p++) {
                    for (int j = i+1; j < u_length; j++) {
                        if (arr.get(p) == using.get(j)) {
                            used[p] = true;
                            break;
                        }
                    }
                }
                boolean flag = false;
                for (int j = i+1; j < arr.size(); j++) {
                    if (!used[j]) {
                        arr.remove(j);
                        arr.add(j, using.get(i));
                        flag = true;
                        break;
                    }
                }
                /*
2 15
3 2 1 2 1 2 1 2 1 3 3 3 3 3 3  반례 : 이미 들어가 있는 것중에 같은 것이 계속 나온다는 조건을 안줌. 가장 최근에 발견 되었다고 하면 최근에 발견된 값을 그냥 넣어줘야함.
                */
                if (!flag) {
                    int find_cnt = 0;
                    for (int j = i+1; j < u_length; j++) {
                        if (find_cnt != n && arr.contains(using.get(j)) && later < j) {
                            later = j; // j번째에 인덱스에 있는것.   // 왜 제일 나중에 발견되어야 하지????
                            find_cnt++;
                        }
                    }
                    int delete = arr.indexOf(using.get(later));
                    arr.remove(delete);
                    arr.add(delete, using.get(i));
                }
            }
            System.out.println(cnt);
        }
    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int parse(String str) {
        return Integer.parseInt(str);
    }

}
