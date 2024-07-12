
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 단어 정렬 1181
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine();
    }

    Arrays.sort(arr, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
          return s1.length() - s2.length();
        } else {
          return s1.compareTo(s2);
        }
      }
    });

    
    StringBuilder sb = new StringBuilder();
    sb.append(arr[0]).append("\n");
    for (int i = 1; i < n; i++) {
      if (!arr[i].equals(arr[i - 1])) { // 중복된 단어 제거
        sb.append(arr[i]).append("\n");
      }
    }

    System.out.print(sb);
    br.close();
  }
}

