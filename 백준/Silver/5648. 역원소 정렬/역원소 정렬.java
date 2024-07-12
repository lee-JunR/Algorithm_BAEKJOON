
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
 
// 역원소 정렬 5648
public class Main {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    List<Long> arr = new ArrayList<>();

    int n = Integer.parseInt(st.nextToken());

    // arr input
    while (arr.size() != n) {
      while (st.hasMoreTokens()) {
        String original = st.nextToken();
        String reversed = new StringBuilder(original).reverse().toString();
        arr.add(Long.parseLong(reversed));
      }
      if (arr.size() < n) {
        st = new StringTokenizer(br.readLine());
      }
    }

    arr.sort(Comparator.naturalOrder());

    for (Long num : arr) {
      sb.append(num).append("\n");
    }
    System.out.print(sb);

    br.close();
  }
}
