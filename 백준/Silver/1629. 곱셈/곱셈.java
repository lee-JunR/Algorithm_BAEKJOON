import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    System.out.println(powerMod(input[0], input[1], input[2]));
  }

  private static long powerMod(long a, long b, long m) {
    long result;
    if(b == 1){
      return a % m;
    }
    result = powerMod(a, b/2, m);
    result = result * result % m;
    if(b % 2 == 1){
      return result * a % m;
    }
    return result;
  }
}
