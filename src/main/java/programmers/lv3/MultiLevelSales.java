package programmers.lv3;

import java.util.*;

public class MultiLevelSales {

    /**
     * - enroll : 직원들 이름 -
     *   referal : 해당 직원들 번호를 추천한 장본인
     *   - seller, amount : 판매자와 판매량 - logic 거꾸로 올라가기
     * ! 추천인
     */
    class Node {

        String referName;
        int profit;

        public Node(String referName, int profit) {
            this.referName = referName;
            this.profit = profit;
        }

        /**
         * 수익금의 10% 반환 로직 1원 이하면 0원
         */
        public int plusProfit(int money) {
            int commission = (int) (money * 0.1);
            if (commission == 0) {
                this.profit += money;
                return 0;
            }
            // this.profit+=(int)(money*0.9); 여기에서 짤려 드러간다..(소수점으로 되면 버림 처리되므로.. 정수로 뺴줘야함)
            this.profit += money - commission;
            return commission;
        }

        @Override
        public String toString() {
            return " profit : " + this.profit;
        }
    }

    static LinkedHashMap<String, Node> map;
    static final int FEE = 100;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        map = createMap(enroll, referral);
        for (int i = 0; i < seller.length; i++) {
            String empName = seller[i];
            int profit = FEE * amount[i];
            Node emp = map.get(empName);
            int commission = emp.plusProfit(profit);
            divideCommission(emp, commission);
        }
        int[] answer = new int[map.size()];
        int idx = 0;
        for (String empName : map.keySet()) {
            answer[idx++] = map.get(empName).profit;
        }
        return answer;
    }

    public void divideCommission(Node emp, int commission) {
        if (commission == 0 || emp.referName.equals("-")) {
            return;
        }
        Node refer = map.get(emp.referName);
        int reCommission = refer.plusProfit(commission);
        divideCommission(refer, reCommission);
    }

    LinkedHashMap<String, Node> createMap(String[] enroll, String[] referral) {
        LinkedHashMap<String, Node> map = new LinkedHashMap<>();
        int n = enroll.length;
        for (int i = 0; i < n; i++) {
            String empName = enroll[i];
            String referEmpName = referral[i];
            map.put(empName, new Node(referEmpName, 0));
        }
        return map;
    }
}
