

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 입력받은 수와 그 빈도를 저장할 맵
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        // 입력받은 수와 그 첫 번째 등장 순서를 저장할 맵
        HashMap<Integer, Integer> firstAppearance = new HashMap<>();
        
        // 입력받은 순서대로 리스트에 추가
        List<Integer> numbers = new ArrayList<>();

        // 빈도 계산 및 첫 번째 등장 순서 기록
        int order = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            numbers.add(num);
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            if (!firstAppearance.containsKey(num)) {
                firstAppearance.put(num, order++);
            }
        }

        // 리스트 정렬
        numbers.sort((a, b) -> {
            int freqCompare = frequencyMap.get(b).compareTo(frequencyMap.get(a));
            if (freqCompare == 0) {
                return firstAppearance.get(a) - firstAppearance.get(b);
            }
            return freqCompare;
        });

        // 결과를 Set을 사용하여 중복 제거 후 출력
        StringBuilder sb = new StringBuilder();
        Set<Integer> seen = new HashSet<>();
        for (int num : numbers) {
            if (!seen.contains(num)) {
                seen.add(num);
                int freq = frequencyMap.get(num);
                for (int i = 0; i < freq; i++) {
                    sb.append(num).append(' ');
                }
            }
        }
        
        System.out.println(sb.toString().trim());
        br.close();
    }
}
