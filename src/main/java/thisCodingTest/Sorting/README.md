# in terms of Sort(Arrays.sort) in JAVA
-- --

## Primitive Type

#### Arrays.class 내부에 int 형 sort

```javascript
 public static void sort(int[] a) {
        DualPivotQuicksort.sort(a, 0, a.length - 1, null, 0, 0);
    }
```

#### :  (DualPivotQuicksort)퀵정렬(한개의 피벗이 아닌 두개의 피벗으로 매우 효율적이다.)을 부른다.

- DualPivotQuicksort의 sort함수를 호출한다.
 - QUICKSORT_THRESHOLD 범위 안에 있으면 또다른
- sort함수를 호출하고 INSERTION_SORT_THRESHOLD 안에 있으면 선택 정렬을 수행한다.
- int 형은 -2147483648부터 2147483647까지 나타날 수 있기 때문에, count sort로 커버가 되지 않는다. 커버가 되는 경우는 byte,char,shorg는 집합의 크기가 작다.


일정 크기이상인 경우에는 count sort를 수행한다 그렇지 않아면 두개의 피벗을 가지고 있는 quick sort를 수행한다.
계수 정렬은 65536개의 임시 배열을 생성하므로 short 배열을 정렬한다고 하면 나오는 갯수는 10개 정도 이다.
오히려 임시배열을 생성하는 것 보다 삽입 정렬이나 퀵정렬이 낫다. 최악의 경우에도 n^2이기 떄문이다.

**결국 countsort 아니면 dualPivotQuicksort를 진행하는 식이다. 무조건 quick을 사용하는 것이 아님.**

![img1 daumcdn](https://user-images.githubusercontent.com/67587446/112624564-1d5cc600-8e71-11eb-86c9-c0dd4e464c60.png)

<br>



## Object Type

```javascript
 public static void sort(Object[] a) {
        if (LegacyMergeSort.userRequested)
            legacyMergeSort(a);
        else
            ComparableTimSort.sort(a, 0, a.length, null, 0, 0);
    }
```
사용자 요청이 merge이면 mergeSort로 아니면, TimSort를 진행한다.<br>
<u>※  TimSort를: Insertion sort와 Merge sort를 결합하여 만든 정렬 </u><br>
**최선의 시간 복잡도는 O(n)O(n), 평균은 O(n\log{}n)O(nlogn), 최악의 경우 시간 복잡도는 O(n\log{}n)O(nlogn)이다.**
<br>
<br>
![img1 daumcdn](https://user-images.githubusercontent.com/67587446/112629689-f655c280-8e77-11eb-94db-8e83948dc754.png)



***

### ※ Arrays.sort, parallelSort 차이
    병렬 소팅은 스레드를 사용하여 대량의 데이터 처리 시 더욱 효과적.

![img1 daumcdn](https://user-images.githubusercontent.com/67587446/112612400-37db7300-8e62-11eb-97a3-8d16ca3a9de0.jpg)

***
### ※객체의 정렬 라이브러리 Comparable<T> 와 Comparator<T>

**- 매번 새로운 정렬 기준 Comparator<T> 사용(외부에서 조건을 결정 할 수 있는 익명 클래스)**

**- 정렬 기준이 명확하다면 객체에 Comparable<T> 상속받고 compareTo 정의**


