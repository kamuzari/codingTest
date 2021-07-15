package AL_CS_STUDY.Weekly28;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class SharkElementarySchool {
    static int n;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static class Student {
        int y, x;
        List<Integer> likePeopleNumber;

        public Student(int y, int x) {
            this.y = y;
            this.x = x;
            this.likePeopleNumber = new ArrayList<>();
        }
    }

    static int classRoom[][], adjEmptySeat[][];
    static Map<Integer, Student> map = new LinkedHashMap<>(); // 할당 받은 아이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int nSquare = n * n;
        classRoom = new int[n][n];
        emptySeatCnt();
        for (int i = 0; i < nSquare; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int[] arr = {a, b, c, d};

            seated(number,new int[]{a,b,c,d});
        }
//        Arrays.stream(classRoom).forEach(val -> System.out.println(Arrays.toString(val)));
        int answer=0;
        for (Integer key : map.keySet()) {
            Student student = map.get(key);
            int satisfaction=0;
            for (Integer val : student.likePeopleNumber) {
                Student friend = map.get(val);
                if(Math.abs(student.y- friend.y)+Math.abs(student.x-friend.x)==1)
                {
                    satisfaction++;
                }
            }
            if(satisfaction==1) answer++;
            else if(satisfaction==2) answer+=10;
            else if(satisfaction==3) answer+=100;
            else if(satisfaction==4) answer+=1000;
        }

        System.out.println(answer);
    }

    static void seated(int number, int [] friends) {
        int[][] adjacentScore = new int[n][n];
        for (int friend : friends) {
            if (map.containsKey(friend)) {
                Student student = map.get(friend);
                int y = student.y;
                int x = student.x;

                for (int i = 0; i < 4; i++) {
                    int ny = dy[i] + y;
                    int nx = dx[i] + x;
                    if (ny >= 0 && ny < n && nx >= 0 && nx < n && classRoom[ny][nx] == 0)
                        adjacentScore[ny][nx]++;
                }
            }
        }
        int emptyCntMax = -1;
        int adjScoreMax = -1;
        int pickY = -1;
        int pickX = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(classRoom[i][j]!=0) continue;
                if(adjScoreMax<adjacentScore[i][j])
                {
                    pickY=i; pickX=j;
                    adjScoreMax=adjacentScore[i][j];
                    emptyCntMax= adjEmptySeat[i][j];
                }
                else if(adjScoreMax==adjacentScore[i][j] && emptyCntMax<adjEmptySeat[i][j])
                {
                    emptyCntMax=adjEmptySeat[i][j];
                    pickY=i; pickX=j;
                }
            }
        }

        classRoom[pickY][pickX]=number;
        map.put(number,new Student(pickY,pickX));
        map.get(number).likePeopleNumber.addAll(Arrays.stream(friends).boxed().collect(Collectors.toList()));

        for (int i = 0; i < 4; i++) {
            int ny=pickY+dy[i];
            int nx=pickX+dx[i];
            if(nx>=0 && nx <n && ny >=0 && ny < n && classRoom[ny][nx] == 0) {
                adjEmptySeat[ny][nx]--;
            }
        }
    }

    private static void emptySeatCnt() {
        adjEmptySeat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 4;
                if (i == 0 || i == n - 1)
                    cnt--;
                if( j == 0 || j == n - 1)
                    cnt--;
                adjEmptySeat[i][j] = cnt;
            }
        }

//        Arrays.stream(adjEmptySeat).forEach(ints -> System.out.println(Arrays.toString(ints)));
    }
}
