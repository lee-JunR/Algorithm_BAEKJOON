import java.util.*;

public class Solution {
    public int solution(String[][] relation) {
        int nRow = relation.length;
        int nCol = relation[0].length;
        
        List<Integer> candidateKeys = new ArrayList<>();
        
        // 모든 가능한 조합을 생성합니다.
        for (int i = 1; i < (1 << nCol); i++) {
            Set<String> set = new HashSet<>();
            
            // 각 조합에 대해 튜플을 생성합니다.
            for (int j = 0; j < nRow; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < nCol; k++) {
                    if ((i & (1 << k)) != 0) {
                        sb.append(relation[j][k]).append(" ");
                    }
                }
                set.add(sb.toString());
            }
            
            // 유일성을 만족하는지 확인합니다.
            if (set.size() == nRow) {
                boolean isMinimal = true;
                for (int key : candidateKeys) {
                    if ((key & i) == key) {
                        isMinimal = false;
                        break;
                    }
                }
                if (isMinimal) {
                    candidateKeys.add(i);
                }
            }
        }
        
        return candidateKeys.size();
    }
}
