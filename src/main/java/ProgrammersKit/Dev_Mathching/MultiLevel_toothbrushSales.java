package ProgrammersKit.Dev_Mathching;

import java.util.LinkedHashMap;
import java.util.Map;

public class MultiLevel_toothbrushSales {

    public static void main(String[] args) {
        String [] enroll={"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String [] referral={"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String [] seller={"young", "john", "tod", "emily", "mary"};
        int [] amount={12,4,2,5,10};
        System.out.println(solution(enroll,referral,seller,amount));
    }
    static class Node{
        private String parent;
        private Integer money;

        public Node() {
            parent="";
            this.money=0;
        }

        public Node(String parent, int money) {
            this.parent = parent;
            this.money = money;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "parent='" + parent + '\'' +
                    ", money=" + money +
                    '}';
        }
    }
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String,Node> map=new LinkedHashMap<>();
        map.put("-",new Node());
        for (int i = 0; i < enroll.length; i++) {
            String me = enroll[i];
            String ref=referral[i];
            Node newNode = new Node(ref, 0);
            map.put(me,newNode);
        }
        int  sellPrice = 100;
        for (int i = 0; i < seller.length; i++) {
            String sellPerson=seller[i];
            int number=amount[i];
            int totalSales=sellPrice*number;
            double fees=totalSales*0.1;
            Node cur = map.get(sellPerson);
            cur.money+= totalSales-(int)fees;
            if((int)fees!=0)
                recursion(cur.parent,map,(int)fees);
        }
//        System.out.println(map);
        int [] answer=new int[map.size()-1];
        int i=0;
        for (String s : map.keySet()) {
            if(!s.equals("-"))
                answer[i++]=map.get(s).money;
        }
        return answer;
    }

    private static void recursion(String parent,Map<String,Node> map,int fee) {
        if(map.get(parent).parent.equals("")) {
            return;
        }
        String Ancestor = map.get(parent).parent;
        double commission=fee*0.1;
        int addMoney=fee-(int)commission;
        map.get(parent).money+=addMoney;
        if((int)commission==0)
            return;
        recursion(Ancestor,map,(int)commission);
    }
}
