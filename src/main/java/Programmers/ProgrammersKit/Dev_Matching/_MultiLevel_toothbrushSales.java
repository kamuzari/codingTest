package Programmers.ProgrammersKit.Dev_Matching;

import java.util.LinkedHashMap;
import java.util.Map;

public class _MultiLevel_toothbrushSales {

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

        public void addMoney(int money){
            this.money+=money;
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
            int commissions=(int)(totalSales*0.1);
            Node cur = map.get(sellPerson);
            cur.money+= totalSales-commissions;
            if(commissions!=0)
                recursion(cur.parent,map,commissions);
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

    private static void recursion(String child,Map<String,Node> map,int profit) {
        if(map.get(child).parent.equals("") || profit==0) {
            return;
        }
        String parent = map.get(child).parent;
        int commissions=(int)(profit*0.1);
        int addMoney=profit-commissions;
        map.get(child).addMoney(addMoney);
        recursion(parent,map,commissions);
    }
}
