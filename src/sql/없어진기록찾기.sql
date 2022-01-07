/**
  * @URL : https://programmers.co.kr/learn/courses/30/lessons/59042
  * @Resolve : 입양을 간 기록(OUTS)은 있는데, 보호소에 들어온 기록이 없는(INS) 동물의 ID와 이름을 ID 순으로 조회
 */
select ao.animal_id,ao.name from animal_outs ao left outer join animal_ins ai
on ao.animal_id = ai.animal_id where ai.datetime is null order by ao.animal_id,ao.name;