import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();
    int[] A = new int[n];

    for (int i = 0; i < n; i++) {
      A[i] = sc.nextInt();
    }
    sc.close();

//    확인
//    System.out.println(n);
//    System.out.println(x);
//    System.out.println(Arrays.toString(A));

    for (int i = 0; i < n; i++) {
      if (A[i] < x) {
        System.out.print(A[i] + " ");
      }
    }
  }

}
