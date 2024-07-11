
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int lengthOfA = Integer.parseInt(input[0]);
        int lengthOfB = Integer.parseInt(input[1]);

        int[] arrayA = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] arrayB = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] result = mergeArrays(arrayA, arrayB);

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static int[] mergeArrays(int[] arrayA, int[] arrayB) {
        int lengthOfA = arrayA.length;
        int lengthOfB = arrayB.length;
        int[] result = new int[lengthOfA + lengthOfB];

        int i = 0, j = 0, k = 0;
        while (i < lengthOfA && j < lengthOfB) {
            if (arrayA[i] <= arrayB[j]) {
                result[k++] = arrayA[i++];
            } else {
                result[k++] = arrayB[j++];
            }
        }

        while (i < lengthOfA) {
            result[k++] = arrayA[i++];
        }

        while (j < lengthOfB) {
            result[k++] = arrayB[j++];
        }

        return result;
    }
}
