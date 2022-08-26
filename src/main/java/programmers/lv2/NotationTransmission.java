package programmers.lv2;

public class NotationTransmission {
    public static void main(String[] args) {
        NotationTransmission p = new NotationTransmission();
        System.out.println(p.conversion(8,2));
    }

    public String conversion(int number,int notation){
        StringBuilder answer=new StringBuilder();
        while (number>0){
            if(number%notation<10){
                answer.append(number%notation);
            }else{
                answer.append((char)number%notation-10+'A');
            }
            number/=notation;
        }
        return answer.reverse().toString();
    }
}
