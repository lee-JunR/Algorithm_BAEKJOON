import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//좌표 정렬하기 11650
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //input
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      arr[i][0] = Integer.parseInt(input[0]);
      arr[i][1] = Integer.parseInt(input[1]);
    }

    // 합병 정렬을 사용.
    mergeSort(arr, 0, n - 1);

    for (int i = 0; i < n; i++) {
      System.out.println(arr[i][0] + " " + arr[i][1]);
    }
    System.out.println();
  }

  public static void mergeSort(int[][] arr, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
  }

  public static void merge(int[][] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[][] leftArr = new int[n1][2];
    int[][] rightArr = new int[n2][2];

    for (int i = 0; i < n1; ++i) {
      leftArr[i][0] = arr[left + i][0];
      leftArr[i][1] = arr[left + i][1];
    }
    for (int j = 0; j < n2; ++j) {
      rightArr[j][0] = arr[mid + 1 + j][0];
      rightArr[j][1] = arr[mid + 1 + j][1];
    }

    int i = 0, j = 0;
    int k = left;
    while (i < n1 && j < n2) {
      if (leftArr[i][0] < rightArr[j][0] || (leftArr[i][0] == rightArr[j][0] && leftArr[i][1] <= rightArr[j][1])) {
        arr[k][0] = leftArr[i][0];
        arr[k][1] = leftArr[i][1];
        i++;
      } else {
        arr[k][0] = rightArr[j][0];
        arr[k][1] = rightArr[j][1];
        j++;
      }
      k++;
    }

    while (i < n1) {
      arr[k][0] = leftArr[i][0];
      arr[k][1] = leftArr[i][1];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k][0] = rightArr[j][0];
      arr[k][1] = rightArr[j][1];
      j++;
      k++;
    }
  }
}
