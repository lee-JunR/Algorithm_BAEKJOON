// 두 수의 합 3273
// 시간 제한이 1초이고 배열의 개수가 1_000_000개 -> 시간복잡도가 O(NlogN) 보다 빨라야함.
// 이중 for문으로 모든 경우의 수를 따지면 O(N^2) 으로 통과 못함.
// -> HashSet 이용해서 자연수 x가 주어지면 a_i 를 빼서 a_j가 있는지 체크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] strArr = br.readLine().split(" ");
    int x = Integer.parseInt(br.readLine());
    br.close();

    Set<Integer> set = new HashSet<>();
    int count = 0;

    for (int index = 0; index < n; index++) {
      int i = Integer.parseInt(strArr[index]);
      int j = x - i;
      if (set.contains(j)) {
        count++;
      }
      set.add(i);
    }
    
    // Output
    System.out.println(count);
  }
}