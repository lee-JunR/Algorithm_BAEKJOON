// 애너그램_만들기_1919
// 두 단어가 주어지고 애너그램 관계를 만들려고 할 때 제거해야할 문자의 최소 개수를 구하는 문제


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] word1 = br.readLine().split(""); // 첫 번째 단어를 문자 단위로 분할하여 배열로 저장
    String[] word2 = br.readLine().split(""); // 두 번째 단어를 문자 단위로 분할하여 배열로 저장

    // 각 문자의 빈도수를 저장할 Map
    Map<String, Integer> counterMap = new HashMap<>();

    // 첫 번째 단어의 각 문자 빈도수를 계산하여 Map에 저장
    for (String letter : word1) {
      counterMap.put(letter, counterMap.getOrDefault(letter, 0) + 1);
    }

    // 두 번째 단어의 각 문자 빈도수를 계산하고, 첫 번째 단어와 비교하여 애너그램을 만들기 위해 제거해야 할 문자의 최소 개수 계산
    int cnt = 0;
    for (String letter : word2) {
      if (counterMap.containsKey(letter) && counterMap.get(letter) > 0) {
        counterMap.put(letter, counterMap.get(letter) - 1);
      } else {
        cnt++;
      }
    }

    for (int count : counterMap.values()) {
      cnt += count;
    }

    // Output
    System.out.println(cnt); // 제거해야 할 문자의 최소 개수 출력
  }
}
