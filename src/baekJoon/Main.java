package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2292번 - 벌집
public class Main {
	public static void main(String[] args) throws IOException {
	   // 입력을 효율적으로 처리하기 위해 BufferedReader를 사용하여 입력을 받음
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	   // 목적지 방의 숫자 입력받음
	   StringTokenizer str = new StringTokenizer(br.readLine());
	   
	   // 육각형의 여러층 구조인 방들이 있다고 생각하고 층이 증가할때마다 기존 층 + 6개의 방이 존재한다.
	   // 예를 들어 1층 1번방 -> 2층 2~7번까지 6개의 방이 존재 3층 8~19번 12개의 방이 존재 
	   int honeycomb = Integer.parseInt(str.nextToken());	// 목적지 방의 숫자
	   int rage = 1;	// 지나온 층의 방 범위
	   int count = 1;	// 시작과 끝을 포함하여 지나가는 방의 개수
	   
	   if(honeycomb == 1) {
		   System.out.print(1);
	   } else {
		   while(honeycomb > rage) {
			   rage += count*6; // 층이 올라갈수록 기존 층 개수 + 6개 의 방이 신규로 존재
			   count++;
		   }
		   
		   // 답 출력
		   System.out.print(count);
	   }
	}
}