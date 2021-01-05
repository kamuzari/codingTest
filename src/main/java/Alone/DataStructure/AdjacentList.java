package Alone.DataStructure;

import java.util.ArrayList;

public class AdjacentList {
    public static void main(String[] args) {
        ArrayList <ArrayList<Integer>> arr=new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            arr.add(new ArrayList<Integer>());
        }
        int k=0;
        for (int i = 0; i <5; i++) {

            for (int j = 0; j<5; j++) {
                arr.get(i).add(k++);
            }
        }

        for (int i = 0; i <5 ; i++) {
            System.out.println(arr.get(i).toString());;
        }
    }
}
class ListGraph {
    private ArrayList<ArrayList<Integer>> arr;

    public ListGraph(int size) {
        this.arr = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < size; i++) {
            arr.add(new ArrayList<Integer>());
        }
    }


    // Undirected Graph
    public void put(int x, int y) {
        arr.get(x).add(y);
        arr.get(y).add(x);
    }

    public void print() {
        for (int i = 1; i < arr.size(); i++) {
            System.out.print(i + "의 그래프의 인접 리스트는 ");
            for (int j = 0; j < arr.get(i).size(); j++) {
                {
                    System.out.print(" " + arr.get(i).get(j));
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        int initSize=8;
        ListGraph lg=new ListGraph(initSize);

        lg.put(1,2);
        lg.put(1,3);
        lg.put(2,3);
        lg.put(2,4);
        lg.put(3,4);
        lg.put(3,5);
        lg.put(4,5);
        lg.put(4,6);
        lg.print();

    }


}
