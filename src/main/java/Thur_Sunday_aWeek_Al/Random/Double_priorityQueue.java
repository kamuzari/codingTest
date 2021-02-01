package Thur_Sunday_aWeek_Al.Random;

import java.util.Scanner;
import java.util.TreeMap;

public class Double_priorityQueue {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while (T-->0)
        {
            //삽입 시 Natural Order에 따라 자동 정렬
            TreeMap<Integer,Integer> treeMap=new TreeMap<>();// get, put, remove에 대해 O(logN)의 속도를 보장

            int k=sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < k; i++) {
                String str[]=sc.nextLine().split(" ");
                String cmd=str[0];
                int val=Integer.parseInt(str[1]);
                if(cmd.equals("I"))
                {
                    //insert
                    if(!treeMap.containsKey(val))
                        treeMap.put(val,1);
                    else
                    {
                        treeMap.put(val, treeMap.getOrDefault(val,0)+1);
                    }
                }
                else
                { // delete
                    if(treeMap.isEmpty())
                        continue;
                    else
                    {
                        if(val==1)
                        {
                            int max=treeMap.lastKey();
                            if(treeMap.get(max)-1==0)
                                treeMap.remove(max);
                            else
                                treeMap.put(max,treeMap.get(max)-1);
                        }
                        else {
                            int min=treeMap.firstKey();
                            if(treeMap.get(min)-1==0)
                                treeMap.remove(min);
                            else
                                treeMap.put(min,treeMap.get(min)-1);
                        }
                    }
                }
            }
            if(!treeMap.isEmpty())
            {
                System.out.println(treeMap.lastKey()+" "+treeMap.firstKey());
            }
            else
            {
                System.out.println("EMPTY");
            }

        }

    }
}
