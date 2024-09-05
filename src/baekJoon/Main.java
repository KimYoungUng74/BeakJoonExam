package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//23971번 - ZOAC 4
public class Main {

 public static void main(String[] args) throws IOException {
     // 입력을 효율적으로 처리하기 위해 BufferedReader를 사용하여 입력을 받음
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
     // [행, 열, 세로공백, 가로공백]을 한줄로 입력 받음
     StringTokenizer str = new StringTokenizer(br.readLine());
     int row = Integer.parseInt(str.nextToken()); 	// 테이블 행 H
     int column = Integer.parseInt(str.nextToken()); // 테이블 열 W
     int rowGap = Integer.parseInt(str.nextToken()); // 참가자 세로 공백 N
     int columnGap = Integer.parseInt(str.nextToken()); // 참가자 가로 공백 M
     
     // 최대 참가자 수 구하는 공식
     int result = ((row-1)/(rowGap+1)+1) * ((column-1)/(columnGap+1)+1);
     
     // 답 출력
     System.out.println(result);
 }
}