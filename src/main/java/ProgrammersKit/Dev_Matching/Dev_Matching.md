## Dev Matching


목차

[1.로또의 최고 순위와 최저 순위](#1로또의-최고-순위와-최저-순위) <br>
[2.행렬 테두리 회전하기](#2행렬-테두리-회전하기) <br>
[3.다단계 칫솔 판매](#3다단계-칫솔-판매)


## 1.로또의 최고 순위와 최저 순위

---

- 총 6의 길이를 갖는 배열 lottos 값에 0이 들어가 있는 인덱스는 알아볼수 없음을 의미하는 표시이다.
- 최대로 맞은 로또번호 개수와 최저로 맞은 로또 번호 개수를 맞은 수를 등급으로 표시하는 문제이다.


```java
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashMap<Integer,Integer> map=new LinkedHashMap<>();
        for(int i=0; i<win_nums.length; i++)
        {
            int key=win_nums[i];
            map.put(key,map.getOrDefault(key,0)+1);
        }
        for(int i=0; i<lottos.length; i++)
        {
            int key=lottos[i];
            map.put(key,map.getOrDefault(key,0)-1);
        }
        int max=0;
        int min=0;
        int cnt=0;
        if(map.containsKey(0))
        {
            max=Math.abs(map.get(0));
        }
        for(Integer key : map.keySet())
        {
            if(map.get(key)==0)
            {
                cnt++;
            }
        }
        max+=cnt;
        min+=cnt;
        max=rank(max);
        min=rank(min);
        return new int[]{max,min};
    }
    static int rank(int a)
    {
        if(a==0)
        {
            return 6;
        }
        else
        {
            return 7-a;
        }
    }
}
```

해시자료구조로 데이터 접근을 O(1) 로 접근하였다. key,value 타입을 Integer로 했지만 value 타입을 boolean 타입으로 하면 메모리 측면에서 더 좋을 것 같다.

## 2.행렬 테두리 회전하기

---
- 주어진 queries 배열 한 행에는 왼쪽 상단의 x,y좌표 와 오른쪽 하단의 x,y좌표가 들어있다.
- 주어진 좌표를 가지고 시계 방향으로 회전하였을 때 가장 작은 값을 찾는 문제이다.
- 왼쪽 상단의 점을 변수에 저장하고 땅겨오는 식으로 배열의 위치를 변경.

```java
public class _BoarderRotate {
     int n,m;
    private  int[] minValues;
    private  int idx;

    public  int[] solution(int rows, int columns, int[][] queries) {
        int n=queries.length;
        int map[][]=new int[rows][columns];
        int val=1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j]=val++;
            }
        }
        minValues = new int[n];
        idx = 0;
        for (int i = 0; i <n ; i++) {
                int x1=queries[i][0];
                int y1=queries[i][1];
                int x2=queries[i][2];
                int y2=queries[i][3];
                map=rotate(map,x1-1,y1-1,x2-1,y2-1);
        }

        return minValues;
    }

    private  int[][] rotate(int[][] map, int y1, int x1, int y2, int x2) {
        int val=map[y1][x1];
        int minValue=val;

        for (int i = y1; i <y2; i++) {
            map[i][x1]=map[i+1][x1];
            minValue=Math.min(map[i][x1],minValue);
        }
        for (int i = x1; i <x2; i++) {
            map[y2][i]=map[y2][i+1];
            minValue=Math.min(map[y2][i],minValue);
        }
        for (int i = y2; i >y1 ; i--) {
            map[i][x2]=map[i-1][x2];
            minValue=Math.min(map[i][x2],minValue);
        }
        for (int i = x2; i >x1+1 ; i--) {
            map[y1][i]=map[y1][i-1];
            minValue=Math.min(map[y1][i],minValue);
        }
        map[y1][x1+1]=val;
        minValues[idx++]=minValue;
        return map;
    }
}

```

## 3.다단계 칫솔 판매

---
- 각 조직은 트리 형식의 계층 구조를 갖는다.
- 하지만 이진트리는 아니다.
    - 이진 트리 : 최대 자식 노드를 2개 갖는 트리.
- 주어진 가장 루트 노드에는 민호 ("-") 가 존재한다.
- 등록대상은 항상 부모노드를 갖는다.
- 이익이 나면 이익이 난 대상으로부터 부모노드에게 10%수익을 배분하는 구조이다.
    - 단 이익이 10% 가 0인 경우 그 부모노드는 수익을 받을 수 없다.
- 해시를 사용하였다.
  - <String,Object> ➡ <등록 대상 이름,부모노드>  
- 재귀방식으로 부모노드를 찾았다.

```java

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class _MultiLevel_toothbrushSales {

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
```    
