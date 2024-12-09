import java.util.Arrays;
import java.util.HashMap;

class Solution {

  public int solution(int[] nums) {
    // 123 234 124 134
    HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    for (int i = 0; i < 3001; i++) {
      map.put(i, true);
    }
    map.put(1, false);
    map.put(0, false);


    for (int i = 2; i * i <= 3001; i++) {
      if (map.get(i)) {
        for (int j = i * i; j <= 3001; j += i) {
          map.put(j, false);
        }
      }
    }

    int result = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
//          System.out.println(nums[i] + nums[j] + nums[k]);
//          System.out.println(map.get(nums[i] + nums[j] + nums[k]));
          if (map.get(nums[i] + nums[j] + nums[k])) {
            result++;
          }
        }
      }
    }

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    return result;

  }
}