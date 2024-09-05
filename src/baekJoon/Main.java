package baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = null;

        int calCount = Integer.parseInt(br.readLine()); // 연산 횟수
        boolean[] checkArray = new boolean[21]; // 1부터 20까지 사용하므로 크기 21로 선언 (0은 사용 안 함)

        for (int i = 0; i < calCount; i++) {
            str = new StringTokenizer(br.readLine());
            String caseName = str.nextToken();

            switch (caseName) {
                case "all":
                    Arrays.fill(checkArray, true);  // 배열을 모두 true로 설정 (1~20까지 포함)
                    break;
                case "empty":
                    Arrays.fill(checkArray, false); // 배열을 모두 false로 설정 (모두 비우기)
                    break;
                default:
                    int paramInt = Integer.parseInt(str.nextToken());

                    switch (caseName) {
                        case "add":
                            checkArray[paramInt] = true;
                            break;
                        case "remove":
                            checkArray[paramInt] = false;
                            break;
                        case "check":
                            bw.write(checkArray[paramInt] ? "1\n" : "0\n");
                            break;
                        case "toggle":
                            checkArray[paramInt] = !checkArray[paramInt];
                            break;
                    }
                    break;
            }
        }

        // 모든 출력이 끝나면 일괄 출력
        bw.flush();
        bw.close();
    }
}
