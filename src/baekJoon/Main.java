package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 1157번 - 단어공부
public class Main {
	public static void main(String[] args) throws IOException {
	   // 가장 높은 빈도를 가진 알파벳 찾기
       int maxFrequency = 0;
       char mostFrequentChar = ' ';
       Map<Character, Integer> charMap = new HashMap<>();
	       
	   // 입력을 효율적으로 처리하기 위해 BufferedReader를 사용하여 입력을 받음
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	   // 빈도수 분석할 문자열 입력받음
	   StringTokenizer str = new StringTokenizer(br.readLine());

	   // 대소문자 구분하지 않기 위해 모든 알파뱃 대문자로 치환
	   String word = str.nextToken().toUpperCase();
	   
	   // 문자열을 분해하여 빈도수 저장
	   for(char c : word.toCharArray()) {
		   charMap.put(c, charMap.getOrDefault(c, 0)+1);
	   }
	   
	   for(Map.Entry<Character, Integer> c : charMap.entrySet()) {
		   if(maxFrequency < c.getValue()) {
			   maxFrequency = c.getValue();
			   mostFrequentChar = c.getKey();
		   } else if(maxFrequency == c.getValue()) { // 최고빈도수가 중복된다면 '?' 출력
			   mostFrequentChar = '?';
		   }
	   }
	   
	   // 답 출력
	   System.out.println(mostFrequentChar);
	}
}