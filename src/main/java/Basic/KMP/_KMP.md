# KMP Algorithm

---

- kmp 알고리즘이란?

```
불일치가 발생한 텍스트 문자열 앞부분에 어떤 문자가 나오는지 알고있기 때문에 불일치가
발생한 앞 부분에 대해서 다시 비교하지 않는 알고리즘
```
<br>

- **KMP의 동작원리**
    - 찾아야하는 문자열 P에 대해서 prefix와 sufix 같은 길이를 구하여 P[i]배열에 기록.
    - 문자열 P에 대한 P[] 정보를 가지고 문자열 길이를 매칭.


문자열 S가 주어질때, S보다 길이가 작은 P문자열

<br>

**일반적인 문자열 매칭 시간복잡도**

`문자열 S가 주어질때, S보다 길이가 작은 P문자열`
- S의 길이*P의 길이 
kmp 알고리즘 시간복잡도
- S의 길이 + P의 길이

<br>

### 문제 목차

[1.IOIOI](#1IOIOI) <br>
[2.Search](#2Search) <br>



전체 유형 
- 문자열 S에 포함되는 패턴 P가 몇개들어있는지 찾는 문제.

### 1.IOIOI

※ 주의사항
  반복적으로 StringBuilder를 선언하고 매 연산시 새로운 객체를 생성하여 append 해줌으로써 성능저하 발생.

결론
- String 연산은 +를 사용하여 한줄로 선언하는 경우에만 성능저하가 발생하지 않는다. 
- 여러줄에 걸쳐서 연산해야하는 경우는 명시적으로 StringBuilder를 사용해야 한다. .

```java
// 시간초과 코드 
        for (int i = 1; i <= n*2; i++) {
            if(i%2==1)
                P+="I";
            else
                P+="O";
        }
        P+="I";
```

예시 코드
```java
//컴파일 전 소스파일
String str = "";
    str += 0;
    str += 1;
    str += 2;
    
//컴파일 이 후, 디컴파일 한 소스파일
String str = "";
    str = (new StringBuilder()).append(s1).append("0").toString();
    str = (new StringBuilder()).append(s1).append("1").toString();
    str = (new StringBuilder()).append(s1).append("2").toString();

```
### 2.Search
- kmp 대표 문제.


<br>

ref
- https://devje8.tistory.com/24
- https://mygumi.tistory.com/61
- https://bowbowbow.tistory.com/6#comment5168448
