# BaekJoon

## List
[1.문제 추천 시스템](#문제-추천-시스템)</br>
[2.인싸 가위바위보](#인싸-가위바위보)</br>




## 1.문제 추천 시스템

자료구조 : Map, TreeMap, TreeSet

- Map<문제 번호 , 난이도>
- TreeMap<난이도,문제 번호 Set>  

**TreeSet은 first(),last() 라이브러리 활용 TreeMap firstKey(), LastKey() 지원**


## 2.인싸 가위바위보

자료구조 : 배열

- 시뮬레이션 동작 재귀 방식
- 문제 이해
    1. 지우가 낼 수 있는 손동작의 숫자 랜덤 뽑기(순열)
    2. 경기 시작
        - #### 주의점 : 각 사용자별 순서는 같은 순서가 아니다. 선택 되어질 때마다 순번이 올라간다 즉 계속 지면 순서가 올라가지 않음
    3. 지우가 아닌 다른 사람이 이긴 횟수가 k가 넘어가거나 혹은 지금 지우의 순번이 n번을 넘어갈 때 승리하지 못한 것이므로 실패이다.
    4. 혹은 지우가 이미 k번 이상 이겼을 경우는 이긴거므로 성공
    5. 상성의 경우 각 사용자별 뽑는 순서의 값에 따라 2,1,0 (이기고 비기고 진다)이 된다.
    6. 비긴 경우 사용자의 숫자가 가장 큰 것이 승리한 것으로 간주.