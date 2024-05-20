// 방_번호_1475
// 카운터 행렬로 필요한 자원을 만들고 셋트 개수 구하기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] n_arr = br.readLine().toCharArray();

    // HashMap 자료구조로 필요한 숫자 사전 생성
    Map<Character, Integer> n_dict = new HashMap<>();

    // 계수 행렬 생성
    for (char c : n_arr) {
      n_dict.put(c, n_dict.getOrDefault(c, 0) + 1);
    }

    // 6과 9의 합산 빈도 세팅
    int feqSixNine = (n_dict.getOrDefault('6', 0) + n_dict.getOrDefault('9',0) + 1) / 2;

    int max = feqSixNine;
    for (char key : n_dict.keySet()) {
      if(key != '6' && key != '9'){
        max = Math.max(max, n_dict.get(key));
      }
    }
    System.out.println(max);
    br.close();
  }
}