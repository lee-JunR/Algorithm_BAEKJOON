// 방 배정_13300
// 같은 학년끼리, 같은 성별끼리 반이 되어야 하고 반마다 배정되는 인원의 수 k 가 주어졌을 때 필요한 방의 최소 개수를 구하는 문제.
// -> input 받는게 딱 2차원 배열인데? 문자열 입력 받아서 2차원 배열에 초기화하고(O(n)) 속성값 접근해서 k로 나눠주면 되겠다.
// -> 그런데 이러면 배열값이 0일때 너무 아깝다. hashMap 사용하는건 어떨까?


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    StringTokenizer st = new StringTokenizer(input, " ");
    int n = Integer.parseInt(st.nextToken()); //학생 수
    int k = Integer.parseInt(st.nextToken()); //최대 방 수
    int result = 0;

    // 학년별 남학생 및 여학생 수 배열 생성
    int[][] arr = new int[2][6];

    for (int i = 0; i < n; i++) {
      input = br.readLine();
      st = new StringTokenizer(input, " ");
      int s = Integer.parseInt(st.nextToken()); // 성별
      int h = Integer.parseInt(st.nextToken()) - 1; // 학년
      arr[s][h] += 1; // arr[성별][학년] += 1
    }
    br.close();

    // 방의 개수 계산
    for (int gender = 0; gender < 2; gender++) {
      for (int grade = 0; grade < 6; grade++) {
        if (arr[gender][grade] > 0) {
          result += (arr[gender][grade] + k - 1) / k; // 학생 수를 최대 방 수로 나누고 올림
        }
      }
    }

    //Output
    System.out.println(result);
  }
}