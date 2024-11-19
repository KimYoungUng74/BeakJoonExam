package baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = null;

        StringBuilder result = new StringBuilder();
        
        int selectChannel = 0;
        int channelCount = Integer.parseInt(br.readLine()); // TV체널 갯수
        if((channelCount >= 2 && channelCount <= 100)) {
        	List<String> channelArray = new ArrayList<>(); // 2부터 100까지 사용하므로 크기

            for (int i = 0; i < channelCount; i++) {
                str = new StringTokenizer(br.readLine());
                String channelName = str.nextToken();
                channelArray.add(channelName);
            }
            
            // KBS1 찾기
            selectChannel = channelArray.indexOf("KBS1");
            
            // KBS1 선택
            for(int m=0; m<selectChannel; m++) {
            	result.append("1");
            }
            
            // KBS1 첫번째로 올리기
            for(int j=selectChannel; j>0; j--) {
            	Collections.swap(channelArray, j, j-1);
            	result.append("4");
            }
            
            // KBS2 찾기
            selectChannel = channelArray.indexOf("KBS2");
            
            // KBS2 선택
            for(int m=0; m<selectChannel; m++) {
            	result.append("1");
            }
            
            // KBS2 두번째로 올리기
            for(int j=selectChannel; j>1; j--) {
            	Collections.swap(channelArray, j, j-1);
            	result.append("4");
            }
            bw.write(result.toString());
            
        } else {
        	bw.write("Channel count is Out of range");
        }
        // 모든 출력이 끝나면 일괄 출력
        bw.flush();
        bw.close();
    }
}
