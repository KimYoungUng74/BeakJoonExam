package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12865번 - 평범한 배낭 (DP알고리즘)
public class Main {

    public static void main(String[] args) throws IOException {
        // 입력을 효율적으로 처리하기 위해 BufferedReader를 사용하여 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 물품의 개수와 최대 무게를 입력받음
        StringTokenizer str = new StringTokenizer(br.readLine());
        int quantity = Integer.parseInt(str.nextToken()); // 물품의 개수 N
        int maxWeight = Integer.parseInt(str.nextToken()); // 최대 무게 K
        
        // 최대 무게에 따라 각 무게에서 얻을 수 있는 최대 가치를 저장하기 위한 배열 초기화
        int[] back = new int[maxWeight + 1]; // 무게가 0부터 maxWeight까지의 배열을 생성
        
        // 물품의 개수만큼 반복하여 각 물품의 무게와 가치를 입력받고 처리
        for (int i = 0; i < quantity; i++) {
            str = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(str.nextToken()); // 현재 물품의 무게 W
            int value = Integer.parseInt(str.nextToken());  // 현재 물품의 가치 V

            // DP 알고리즘 적용
            // maxWeight부터 현재 물품의 무게까지 순회하면서 최대 가치를 업데이트
            for (int j = maxWeight; j >= weight; j--) {
                // 현재 무게 j에서 물품을 포함하는 경우와 포함하지 않는 경우 중 최대 가치를 선택하여 저장
                // back[j]는 현재까지 고려한 물품들로 얻을 수 있는 무게 j에서의 최대 가치
                // back[j - weight] + value는 현재 물품을 포함했을 때의 새로운 가치
                back[j] = Math.max(back[j], back[j - weight] + value);
            }
        }
        
        // 최대 무게에서 얻을 수 있는 최대 가치를 출력
        System.out.println(back[maxWeight]);
    }
}