package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5073번 - 삼각형과 세 변
public class Main {
	public static void main(String[] args) throws IOException {
	   // 입력을 효율적으로 처리하기 위해 BufferedReader를 사용하여 입력을 받음
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	   StringTokenizer str = null;
	   
	   int side1 = 0;
	   int side2 = 0;
	   int side3 = 0;
	   int maxSide = 0;
	   String resultStr = "";
	    
		while(true) {
			str = new StringTokenizer(br.readLine());
			side1 = Integer.parseInt(str.nextToken());
			side2 = Integer.parseInt(str.nextToken());
			side3 = Integer.parseInt(str.nextToken());
		 
			if(side1 == 0 && side2 == 0 && side3 == 0) { // 마지막 줄 입력
				resultStr = resultStr.trim(); // 마지막 \n 제거 
				break;
			}
		 
			// 세 변중 가장 긴 변의 길이 구하기
			if (side1 >= side2 && side1 >= side3) {
				maxSide = side1;
			} else if (side2 >= side1 && side2 >= side3) {
				maxSide = side2;
			} else {
				maxSide = side3;
			}
		 
			if(side1+side2+side3-maxSide <= maxSide) { 	// 가장 긴 변의 길이가 다른 두변의 합보다 크거나 같을 때 
				resultStr += "Invalid\n";
			} else if(side1==side2 && side1==side3){	// 모든 변의 길이가 같을 때 
				resultStr += "Equilateral\n";
			} else if(side1==side2 || side1==side3 || side2==side3) {	// 두변의 길이가 같을 때
				resultStr += "Isosceles\n";
			} else {	// 모든 변의 길이가 다를 때
				resultStr += "Scalene\n";
			}
		}
		// 답 출력
		System.out.println(resultStr);
	}
}