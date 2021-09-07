package AL_CS_STUDY.Weekly_30to40.Weekly36;

import java.util.*;

public class CandidateKey {

    private int row;
    private int col;
    int target = 0;
    Set<Set<Integer>> candidates = new HashSet<>();
    String[][] ref;

    public static void main(String[] args) {
        String relations[][] = {
                {"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}
        };
        CandidateKey candidateKey = new CandidateKey();
        candidateKey.solution(relations);
    }

    public int solution(String[][] relation) {
        row = relation.length;
        col = relation[0].length;
        ref = relation;
        for (int i = 1; i <= col; i++) {
            target = i;
            comb(0, 0, new HashSet<>());
        }
        return candidates.size();
    }

    private void comb(int idx, int cnt, Set<Integer> pickColum) {
        if (cnt == target) {
            if (isUnique(pickColum)) {
                for (Set<Integer> candidate : candidates) {
                    if (pickColum.containsAll(candidate)) {
                        return;
                    }
                }
                candidates.add(pickColum);
            }

            return;
        }
        for (int i = idx; i < col; i++) {
            HashSet<Integer> parameter = new HashSet<>(pickColum);
            parameter.add(i);
            comb(idx + 1, cnt + 1, parameter);
        }
    }

    private boolean isUnique(Set<Integer> set) {
        HashSet<String> UniqueValueSet = new HashSet<>();
        for (int i = 0; i < row; i++) {
            StringBuffer sb = new StringBuffer();
            for (Integer colIdx : set) {
                sb.append(ref[i][colIdx]);
            }
            if (!UniqueValueSet.add(sb.toString())) {
                return false;
            }
        }
        return true;
    }
}
