package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		// BufferedReader를 사용해 입력을 효율적으로 받기 위한 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;

		// 뱀의 이동 방향을 나타내는 배열 (상, 우, 하, 좌)
		int[] movingX = { 1, 0, -1, 0 }; // x축에 대한 방향 (우, 상, 좌, 하)
		int[] movingY = { 0, 1, 0, -1 }; // y축에 대한 방향 (우, 상, 좌, 하)

		// 맵의 크기 (N x N)
		int mapSize = Integer.parseInt(br.readLine());

		// 사과의 개수
		int apples = Integer.parseInt(br.readLine());

		// 맵 배열을 생성하고 0으로 초기화 (사과가 있는 위치는 1로 표시됨)
		int[][] map = new int[mapSize][mapSize];

		// 뱀의 이동 정보 (시간, 방향)를 저장하는 HashMap
		Map<Integer, String> moveInfoMap = new HashMap<>();

		int a = 0;
		int b = 0;

		// 입력된 사과의 위치를 맵에 설정
		for (int i = 0; i < apples; i++) {
			str = new StringTokenizer(br.readLine());
			a = Integer.parseInt(str.nextToken()) - 1; // 행 (0부터 시작하기 때문에 -1)
			b = Integer.parseInt(str.nextToken()) - 1; // 열 (0부터 시작하기 때문에 -1)
			map[a][b] = 1; // 사과가 있는 위치는 1로 표시
		}

		// 이동 정보 입력
		int movingInfo = Integer.parseInt(br.readLine());
		int movingTime = 0;

		// 이동 시간과 방향을 moveInfo 맵에 저장
		for (int i = 0; i < movingInfo; i++) {
			str = new StringTokenizer(br.readLine());
			movingTime = Integer.parseInt(str.nextToken()); // 방향 전환이 발생하는 시간
			String direction = str.nextToken(); // 방향 전환 ("L" 또는 "D")
			moveInfoMap.put(movingTime, direction); // 맵에 시간과 방향 저장
		}

		// 게임이 진행된 총 시간
		int limitTime = 0;

		// 현재 뱀의 머리 위치 (초기 위치는 (0,0))
		int headX = 0, headY = 0;

		// 다음으로 이동할 위치
		int nextX = 0, nextY = 0;

		// 뱀의 몸이 위치한 좌표를 큐에 저장 (초기에는 시작 위치만 포함)
		Queue<Integer> bodyQ = new LinkedList<>();
		bodyQ.add(0); // (0,0) 위치를 큐에 추가

		// 뱀의 현재 머리이동 방향 (0 = 우, 1 = 상, 2 = 좌, 3 = 하)
		int headPosition = 0;

		// 게임 진행 루프
		while (true) {
			// 다음 위치 계산
			nextX = headX + movingX[headPosition];
			nextY = headY + movingY[headPosition];
			limitTime++; // 시간 증가

			// 벽에 부딪힌 경우 게임 종료
			if (nextX < 0 || nextY < 0 || nextX >= mapSize || nextY >= mapSize) {
				break;
			}

			// 몸통에 부딪힌 경우 게임 종료
			// 큐에 현재 위치가 포함되어 있다면, 이는 뱀이 자신의 몸과 부딪혔다는 것을 의미
			if (bodyQ.contains(nextY * mapSize + nextX)) {
				break;
			}

			// 새로운 위치에 사과가 있는 경우
			if (map[nextY][nextX] == 1) {
				map[nextY][nextX] = 0; // 사과를 먹으면 사과 위치를 0으로 변경
				bodyQ.add(nextY * mapSize + nextX); // 뱀의 새로운 위치를 큐에 추가 (길이 증가)
			} else {
				// 새로운 위치에 사과가 없는 경우
				bodyQ.add(nextY * mapSize + nextX); // 뱀의 새로운 위치를 큐에 추가 (길이 증가)
				bodyQ.poll(); // 뱀의 꼬리를 한 칸 줄여서 길이 유지(길이 감소)
			}

			// 현재 시간이 방향 전환 시간과 일치하면 방향을 전환
			if (moveInfoMap.containsKey(limitTime)) {
				String data = moveInfoMap.get(limitTime);
				if (data.equals("D")) {
					// 오른쪽 회전 (시계 방향)
					headPosition += 1;
					if (headPosition == 4) headPosition = 0; // 방향 배열의 인덱스 초과 방지
				} else {
					// 왼쪽 회전 (반시계 방향)
					headPosition -= 1;
					if (headPosition == -1) headPosition = 3; // 방향 배열의 인덱스 음수 방지
				}
			}

			// 현재 머리 위치를 다음 위치로 업데이트
			headX = nextX;
			headY = nextY;
		}

		// 게임이 종료된 시점의 시간을 출력
		System.out.println(limitTime);
	}
}
