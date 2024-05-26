// 요세푸스_문제 1158

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) throws IOException {
    //Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);

    StringBuilder sb = new StringBuilder();
    sb.append('<');

    // LinkedList와 ListIterator 사용.
    LinkedList<Integer> lnkList = new LinkedList<>();

    // LinkedList 초기화
    for (int i = 1; i <= n; i++) {
      lnkList.add(i);
    }

    int index = 0;
    while (lnkList.size() > 1) {
      index = (index + k - 1) % lnkList.size();
      sb.append(lnkList.remove(index)).append(", ");
    }
    sb.append(lnkList.remove()).append('>');

    System.out.println(sb.toString());
    br.close();
  }
}