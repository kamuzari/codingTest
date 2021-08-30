package AL_CS_STUDY.Weekly_20to30.Weekly22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TwoDimensionalOperation {
    static class Node implements Comparable<Node> {
        int idx, val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if (o.val == val) {
                return idx - o.idx;
            }
            return val - o.val;
        }
    }

    static int arr[][];
    static ArrayList<Node> list;
    static Map<Integer,Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());
        arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int t = -1;
        while (true) {
            t++;
            if(t>100)
            {
                t=-1;
                break;
            }
            if (r < arr.length && c < arr[0].length) {
                if (arr[r][c] == k) {
                    break;
                }
            }

            int row = arr.length;
            int col = arr[0].length;

            int temp[][] = new int[101][101];

            if (row >= col) {
                int max = Integer.MIN_VALUE;

                for (int i = 0; i < row; i++) {
                    map=new HashMap<>();
                    for (int j = 0; j < col; j++) {
                        if (arr[i][j] == 0)
                            continue;
                        map.put(arr[i][j],map.getOrDefault(arr[i][j],0)+1);
                    }

                    list = new ArrayList<>();
                    for (Map.Entry<Integer, Integer> entries : map.entrySet()) {
                        Integer key = entries.getKey();
                        Integer value = entries.getValue();
                        list.add(new Node(key,value));
                    }

                    Collections.sort(list);

                    int idx = 0;
                    for (int j = 0; j < list.size(); j++) {
                        temp[i][idx] = list.get(j).idx;
                        temp[i][idx + 1] = list.get(j).val;
                        idx+=2;
                    }
                    max = Math.max(list.size()*2, max);
                }
                if(max>100)
                    max=100;
                arr = new int[row][max];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        arr[i][j] = temp[i][j];
                    }
                }
            }
            else {
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < col; i++) {
                    map=new HashMap<>();
                    for(int j = 0; j < row; j++) {
                        if (arr[j][i] == 0)
                            continue;
                        map.put(arr[j][i],map.getOrDefault(arr[j][i],0)+1);
                    }

                    list = new ArrayList<>();
                    for (Map.Entry<Integer, Integer> entries : map.entrySet()) {
                        Integer key = entries.getKey();
                        Integer value = entries.getValue();
                        list.add(new Node(key,value));
                    }

                    Collections.sort(list);

                    int idx = 0;
                    for (int j = 0; j < list.size(); j++) {
                        temp[idx][i] = list.get(j).idx;
                        temp[idx + 1][i] = list.get(j).val;
                        idx+=2;
                    }
                    max = Math.max(list.size()*2,max);
                }
                if(max>100)
                    max=100;
                arr = new int[max][col];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        arr[i][j] = temp[i][j];
                    }
                }
            }
           /* System.out.println(" "+t+" 번째");
            for (int i = 0; i < map.length; i++) {
                System.out.println(Arrays.toString(map[i]));
            }
            System.out.println();*/
        }
        System.out.println(t);
    }
}
