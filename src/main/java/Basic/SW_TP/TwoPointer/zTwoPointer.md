## TwoPointer

##목차
[2003.수들의 합](#수들의-합)<br>
[1664.소수의 연속합](#소수의-연속합)<br>
[1806.부분합](#부분합)<br>
[3273.두 수의 합](#두-수의-합)<br>

**응용** <br>
[2230.수 고르기](#수-고르기)<br>
[1484.다이어트]<br>
[2531.회전초밥]<br>
[2096.내려가기]<br>
[2293.동전1]<br>


### 수들의 합

---
**핵심**
-   연속된 수들로 이루어진 수열에서 목표하는 값에 대해 Two Pointer 이용하기
<br>

### 소수의 연속합

---

**핵심**
- 소수 구하기(애래토스태네스의 체)  -> 연속된 수들로 이루어진 합 구하기(BackTracking | TwoPointer)
- twoPointer  더 효율적
- BackTracking 방식
    - 연속된 수들이라는 점에서 BackTracking 을 사용할 떄 바로 옆 index+1 옆을 이용한다.
    - 기저사례 조건은 인덱스 범위 즉 함수 호출의 깊이에 유의해야 한다.
    - code Level
    ```java
         public static void backtracking(int sum,int depth){
        if(sum>n)
            return;
        if(depth<arr.size()&&sum==n)
        {
            ++cnt;
        }
        if(depth!=arr.size()-1)
        {
                backtracking(sum+arr.get(depth+1),depth+1);
        }
    }
    ```
#### had the Problem
- 애라토스태네스의 체 범위
    n :  4_000_000 (사백만)
  ```java
          for (int i = 2; i<= n; i++) {
            if(temp[i]) {
                for (int j = i * i; j <= n; j += i) {
                    temp[j] = false;
                }
            }
        }
    ```
    4_000_000까지 바깥족 n번을 돈다 그리고 그 안에서 if문으로 배수들에서 false처리가 안됬다면 진행하기로 되어있는데
    3999971 이라는 i에서 if문을 통과후 for문의 초기값 설정에서 i * i가 실행한다. 그러면 int의 범위(21억)을 초과하여 RTE가 발생한다.
    그리하여 바깥 for문 조건을 i * i <= n 작은지 미리 i*i의 초과될 범위를 확인하므로써 입력범위의 최대 범위인4_000_000 RTE가 발생하지 않을 수 있었다.
  

   **for문 실행순서**

   1. 초기값 설정
   2. 초기값 범위 체크
   3. Body 실행   
   4. 초기값 ++|--

<br>

### 부분합

---
**핵심**
- 주어진 문제 조건 : 연속된 수들의 부부합 중에(TP조건)
- 해당 목표값이 아닌 해당 목표값 이상일 때의 길이 중 가장 짧은 것.

<br>

＃ 주의
- startPointer, endPointer 길이 구할 떄 이미 e는 해당 구간을 벗어난 상태이다.
- 그러므로 +1을 안해줘도 된다.


### 수 고르기

---
**핵심**
- 정렬
- 차이가 M 이상이면서 차이가 제일 작은 경우를 구하는 문제

**풀이 방법**
  1. TP( O(n) )
    - 두개의 포인터로 범위를 탐색하는 것이 아닌 포인터가 가르키는 값들에 대한 뺄샘만 생각하면된다.
    - 조건
      - arr[ptr2]-arr[ptr1]이 목표하는 값보다 작으면 ptr2++
      - arr[ptr2]-arr[ptr1]이 목표하는 값보다 크거나 같으면  ptr1++                  
      - 반복문 조건 ptr2의 outOfIdx 방지로 e-1보다 큰 인덱스 범위를 가르킬 떄 종료
  2. BS(O(n log n))
    - 정해진 한 점을 기준으로 절반씩 탐색한다
    - 이분 탐색으로 계속 나오는 arr[mid] 값을 이용한다
    - arr[mid]-arr[i]\(정해진 점) ==m 인지 아닌지 판단한다
    - arr[mid] - arr[i] 가 m보다 크면 기록해 놓는다.
    - 원하는 값 이상의 위치를 찾는 Lower Bound 를 이용한다.

<br>


### 두 수의 합

---

**핵심**
- 연속된 수들이라고 주어지진 않았지만, 두 수의 합이 K가되는 수를 찾는 것으로서 두가지의 풀이방식이 있다.

1. 투 포인터
    - 양 끝점을 기반으로 해당 묙표값 을 찾으면 answer ++;
    - 목표값을 찾음과 동시에 범위 조정이 필요
        - 목표 값보다 크거나 같을 때 이미 목표값일수도 아닐수도 있다는 관점에서 end의 범위를 줄여준다.
        - 목표값보다 작으면 큰 수가 필요한 것으로 start 포인터 쪽을 증가시킨다.
        
2. 이분 탐색
    - 한 점을 기준 삼아 목표값을 찾는다.
    - 기준을 잡고 난 후 그 이후의 범위에 대해서 이분 탐색한다.

#### reference

---
[투포인터_문제집](https://coder-in-war.tistory.com/entry/%EA%B0%9C%EB%85%90-36-Two-Pointer%ED%88%AC%ED%8F%AC%EC%9D%B8%ED%84%B0-Sliding-Window%EC%8A%AC%EB%9D%BC%EC%9D%B4%EB%94%A9-%EC%9C%88%EB%8F%84%EC%9A%B0) <br>
[투포인터_개념](https://code0xff.tistory.com/128?category=723754) <br>