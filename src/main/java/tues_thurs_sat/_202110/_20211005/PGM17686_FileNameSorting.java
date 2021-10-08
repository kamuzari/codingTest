package tues_thurs_sat._202110._20211005;
import java.util.*;

public class PGM17686_FileNameSorting {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                String[] one=divide(s1.toLowerCase());
                String[] two=divide(s2.toLowerCase());
                // System.out.println(Arrays.toString(one));
                // System.out.println(Arrays.toString(two));
                int headDiff=one[0].compareTo(two[0]);
                if(headDiff==0){
                    int intVal1=Integer.parseInt(one[1]);
                    int intVal2=Integer.parseInt(two[1]);
                    return intVal1-intVal2;
                }
                return headDiff;
            }

            public String[] divide(String str){
                String ret[]=new String[3];
                StringBuffer head=new StringBuffer();
                StringBuffer number=new StringBuffer();
                StringBuffer tail=new StringBuffer();
                int flag=1;
                for(int i=0; i<str.length(); i++){
                    char ch=str.charAt(i);
                    if(flag==1){
                        if(Character.isDigit(ch)){
                            i--;
                            flag=2;
                            continue;
                        }
                        head.append(ch);
                    }else if(flag==2){
                        if(!Character.isDigit(ch)){
                            i--;
                            flag=3;
                            continue;
                        }
                        number.append(ch);
                    }else if(flag==3){
                        tail.append(ch);
                    }
                }
                return new String[]{head.toString(),number.toString(),tail.toString()};
            }
        });
        return files;
    }
}
