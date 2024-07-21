import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j != 0 && j != i) {
                    tri[i][j] += Math.max(tri[i - 1][j], tri[i - 1][j - 1]);
                } else if (j == 0) {
                    tri[i][j] += tri[i - 1][j];
                } else if (j == i) {
                    tri[i][j] += tri[i - 1][j - 1];
                }
            }
        }

        int maxSum = 0;
        for (int j = 0; j < n; j++) {
            if (tri[n - 1][j] > maxSum) {
                maxSum = tri[n - 1][j];
            }
        }
        System.out.println(maxSum);
        br.close();
    }
}
