package WeeklyThuseday.KakaoWinter_Intern;


// 참조 https://bcp0109.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-2019-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B2%A8%EC%9A%B8%EC%9D%B8%ED%84%B4-%EC%A7%95%EA%B2%80%EB%8B%A4%EB%A6%AC-%EA%B1%B4%EB%84%88%EA%B8%B0-Java

public class Crossing_Stone {
    public static void main(String[] args) {
        int k=3;
        int s[]={2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
//        int x=solution(s,k);
//        int x=solution(s,k);
//        int x=solution2(s,k);
        int x=OPT_solution(s,k);
        System.out.println(x);
    }

    public static int solution(int[] stones, int k) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int s:stones)
        {
            max=Math.max(max,s);
            min=Math.min(min,s);
        }

        return binarySearch(stones,k,min,max);
    }

    private static int binarySearch(int[] stones, int k, int min, int max) {
        if(max==min)
            return min;
        while (min<max)
        {
            int mid=min+(max-min)/2;
            if(Can(stones,k,mid))
            {
                min=mid+1;
            }
            else
                max=mid;
        }
        return min-1;
    }

    private static boolean Can(int[] stones, int k, int mid) {
        int cnt=0;
        for (int s:stones) {
            if(s-mid<0)
                cnt++;
            else
                cnt=0;

            if(cnt==k)
                return false;
        }
        return true;
    }

    public static int solution2(int[] stones, int k)
    {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int s:stones)
        {
            max=Math.max(max,s);
            min=Math.min(min,s);
        }
        int l=min;
        int r=max;
        boolean check=false;
        int cnt=0;
        while (l<=r)
        {
            int mid=(l+r)/2;
            int temp[]=stones.clone();

            for (int i = 0; i < temp.length; i++) {
                temp[i]-=mid;
            }
            cnt=0;
            check=false;
            for (int i = 0; i < temp.length; i++) {
                if(temp[i]<=0)
                    cnt++;
                else
                    cnt=0;

                if(cnt>=k) {
                    check = true;
                    break;
                }
            }
            if(check)
                r=mid-1;
            else
                l=mid+1;
        }
        return l;

    }

    public static int OPT_solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;


        for(int i = 0; i<=stones.length-k; i++){
            int temp = i;
            int stone = stones[i];
            for(int j = i; j<i+k; j++){
                // 현재 다리에서 3칸 까지 갈수 있는지 체크 하면서 가장 큰 수 저장 하고 index 저장.
                if(stones[j] > stone){
                    stone = stones[j];
                    temp = j;
                }
            }
            if(answer > stone){
                answer = stone;
            }
            i = temp;

        }
        return answer;
    }


}
