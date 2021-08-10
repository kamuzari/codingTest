package AL_CS_STUDY.Weekly32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class ColorPaper_Greedy {

    static final int N = 10;
    static int[][] paper = new int[N][N];
    static int needPaperSize[] = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 1) {
                    needPaperSize[1]++;
                }
            }
        }

        for (int k = 5; k >= 2; k--) {

            for (int i = 0; i < N-k; i++) {
                for (int j = 0; j < N-k; j++) {
                    checkPaper(k, i, j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(paper[i]));
        }
        System.out.println(Arrays.toString(needPaperSize));
        for (int i = 1; i < 6; i++) {
            if(needPaperSize[i]>4)
            {
                System.out.println(-1);
                return;
            }
        }
        OptionalInt summary = Arrays.stream(needPaperSize).reduce(Integer::sum);
        System.out.println(summary.orElseThrow(() -> new RuntimeException("no element")));
    }

    private static void checkPaper(int paperSize, int y, int x) {
        for (int i = y; i < y + paperSize; i++) {
            for (int j = x; j < x + paperSize; j++) {
                if (paper[i][j] != 1) {
                    return;
                }
            }
        }

        overWriteArray(paperSize, y, x);

        int width = paperSize * paperSize;
        needPaperSize[1]-=width;
        needPaperSize[paperSize]++;
    }

    private static void overWriteArray(int paperSize, int y, int x) {
        for (int i = y; i < y + paperSize; i++) {
            for (int j = x; j < x + paperSize; j++) {
                paper[i][j]= paperSize;
            }
        }
    }
}
