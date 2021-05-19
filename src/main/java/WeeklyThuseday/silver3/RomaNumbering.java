package WeeklyThuseday.silver3;

import java.util.Scanner;

public class RomaNumbering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str2 = sc.nextLine();
        int sum = parseNumber(str) + parseNumber(str2);
        System.out.println(sum);
        System.out.println(parseString("", sum));
    }

    private static String parseString(String ans, int number) {
        while (number >= 1000) {
            ans += "M";
            number -= 1000;
        }
        if (number >= 900) {
            ans += "CM";
            number -= 900;
        }
        if (number >= 500) {
            ans += "D";
            number -= 500;
        }
        if (number >= 400) {
            ans += "CD";
            number -= 400;
        }
        while (number >= 100) {
            ans += "C";
            number -= 100;
        }
        if (number >= 90) {
            ans += "XC";
            number -= 90;
        }
        if (number >= 50) {
            ans += "L";
            number -= 50;
        }
        if (number >= 40) {
            ans += "XL";
            number -= 40;
        }
        while (number >= 10) {
            ans += "X";
            number -= 10;
        }
        if (number >= 9) {
            ans += "IX";
            number -= 9;
        }
        if (number >= 5) {
            ans += "V";
            number -= 5;
        }
        if(number>=4) {
            ans += "IV";
            number-=4;
        }
        while (number >= 1) {
            ans += "I";
            number -= 1;
        }

        return ans;
    }

    private static int parseNumber(String str) {
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i + 1 < str.length()) {
                String substring = String.valueOf(ch) + String.valueOf(str.charAt(i + 1));
                switch (substring) {
                    case "CM":
                        ans += 900;
                        break;
                    case "CD":
                        ans += 400;
                        break;
                    case "XC":
                        ans += 90;
                        break;
                    case "XL":
                        ans += 40;
                        break;
                    case "IX":
                        ans += 9;
                        break;
                    case "IV":
                        ans += 4;
                        break;
                    default:
                        ans += toNumber(ch);
                        i--;
                        break;
                }
                i++;
            } else
                ans += toNumber(ch);
        }
        return ans;
    }

    private static int toNumber(char ch) {
        int ans = 0;
        switch (ch) {
            case 'M':
                ans = 1000;
                break;
            case 'D':
                ans = 500;
                break;
            case 'C':
                ans = 100;
                break;
            case 'L':
                ans = 50;
                break;
            case 'X':
                ans = 10;
                break;
            case 'V':
                ans = 5;
                break;
            case 'I':
                ans = 1;
                break;
            default:
                ans= 0;
                break;
        }
        return ans;
    }
}

