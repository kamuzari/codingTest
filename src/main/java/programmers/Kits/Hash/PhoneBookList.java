package programmers.Kits.Hash;

import java.util.Arrays;

public class PhoneBookList {
    public static void main(String[] args) {
        String[] a={"119", "97674223", "1195524421"};
        String b[]={"123","456","789"};
        String c[]={"12","123","1235","567","88"};
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));
    }
    // 효율성 2개 false
    public static boolean Fasle_solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if(i==j)continue;

                if(phone_book[j].startsWith(phone_book[i]))
                {
                    return false;
                }
            }
        }
        return true;
    }
    // 효율성 2개 false
    public static boolean False_solution2(String[] phone_book)
    {
        for (int i = 0; i < phone_book.length-1; i++) {
            for (int j = i+1; j < phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j]))
                    return false;
                if(phone_book[j].startsWith(phone_book[i]))
                    return false;
            }
        }
        return true;
    }
    public static boolean solution(String[] phone_book)
    {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
                if(phone_book[i+1].startsWith(phone_book[i]))
                    return false;
        }
        return true;
    }
}
