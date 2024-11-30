import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int s = 0;
        int e = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (e < sequence.length) {
            sum += sequence[e];

            while (sum > k) {
                sum -= sequence[s];
                s++;
            }

            if (sum == k) {
                if (e - s + 1 < minLength) {
                    minLength = e - s + 1;
                    result[0] = s;
                    result[1] = e;
                }
            }

            e++;
        }

        return result;
    }
}