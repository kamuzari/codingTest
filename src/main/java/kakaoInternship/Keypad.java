package kakaoInternship;

import java.util.*;

public class Keypad {
    static class Node {
        private int y, x;
        char hand;

        public Node(int y, int x, char hand) {
            this.y = y;
            this.x = x;
            this.hand = hand;
        }

        public char getHand() {
            return hand;
        }
    }

    public static void main(String[] args) {
        int n[]={1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String h="right";
        System.out.println(solution(n,h));
    }
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        HashMap<Character, Node> map = new LinkedHashMap<>();
        map.put('1', new Node(0, 0, 'L'));
        map.put('2', new Node(0, 1, '?'));
        map.put('3', new Node(0, 2, 'R'));

        map.put('4', new Node(1, 0, 'L'));
        map.put('5', new Node(1, 1, '?'));
        map.put('6', new Node(1, 2, 'R'));

        map.put('7', new Node(2, 0, 'L'));
        map.put('8', new Node(2, 1, '?'));
        map.put('9', new Node(2, 2, 'R'));

        map.put('*', new Node(3, 0, 'L'));
        map.put('0', new Node(3, 1, '?'));
        map.put('#', new Node(3, 2, 'R'));
        char previousL = '*', previousR = '#';

        for (int i = 0; i < numbers.length; i++) {
            char number = String.valueOf(numbers[i]).charAt(0);

            if (number == '1' || number == '4' || number == '7') {
                answer += map.get(number).hand;
                previousL=number;
            } else if (number == '3' || number == '6' || number == '9') {
                answer += map.get(number).hand;
                previousR=number;
            } else {
                Node target=map.get(number);
                Node L = map.get(previousL);
                Node R = map.get(previousR);
                int distL=Math.abs(target.y-L.y)+Math.abs(target.x-L.x);
                int distR=Math.abs(target.y-R.y)+Math.abs(target.x-R.x);
                if(distL==distR)
                {
                    if(hand.equals("right"))
                    {
                        previousR=number;
                        answer+="R";
                    }
                    else
                    {
                        previousL=number;
                        answer+="L";
                    }
                }
                else if(distL>distR)
                {
                    previousR=number;
                    answer+="R";
                }
                else
                {
                    previousL=number;
                    answer+="L";
                }
            }
        }
        return answer;
    }
}
