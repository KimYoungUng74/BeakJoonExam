package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용해 입력을 효율적으로 받기 위한 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = null;
        
        // 첫 줄에서 물품의 개수와 최대 무게를 입력받음
        str = new StringTokenizer(br.readLine());
        int quantity = Integer.parseInt(str.nextToken()); // 물품의 개수 n
        int maxWeight = Integer.parseInt(str.nextToken()); // 최대 무게 k
        
        // 입력받은 물품의 정보를 저장할 Item 배열 초기화
        Item[] items = new Item[quantity];
        int weight = 0;
        int value = 0;

        // 각 물품의 무게와 가치를 입력받아 items 배열에 저장
        for (int i = 0; i < quantity; i++) {
            str = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(str.nextToken());
            value = Integer.parseInt(str.nextToken());
            items[i] = new Item(weight, value);
        }
        
        // 결과 값을 저장할 Set 초기화 (중복 제거를 위해 Set 사용)
        Set<Integer> resultHashSet = new HashSet<>();
        
        // 모든 조합을 찾아서 최대 이익을 구함
        findMaxValue(items, maxWeight, 0, new ArrayList<>(), resultHashSet);

        // Set에서 가장 큰 값을 출력 (최대 이익)
        System.out.println(Collections.max(resultHashSet));
    }

    /**
     * 주어진 아이템 목록에서 가능한 모든 조합을 찾아서
     * 최대 무게 이하의 경우 해당 조합의 가치를 Set에 추가하는 함수
     * 
     * @param items          아이템 배열
     * @param maxWeight      최대 허용 무게
     * @param startIndex     현재 조합의 시작 인덱스
     * @param currentCombination 현재 조합된 아이템 리스트
     * @param resultHashSet  가능한 조합의 가치들을 저장할 Set
     */
    private static void findMaxValue(Item[] items, int maxWeight, int startIndex, 
                                         List<Item> currentCombination, 
                                         Set<Integer> resultHashSet) {
        int weightSum = 0;
        int valueSum = 0;
        
        // 현재 조합된 아이템들의 무게와 가치를 계산
        for (Item item : currentCombination) {
            weightSum += item.weight;
            valueSum += item.value;
        }
        
        // 현재 조합의 무게가 최대 무게 이하라면 그 가치를 Set에 추가
        if (weightSum <= maxWeight) {
            resultHashSet.add(valueSum);
        }
        
        // 현재 인덱스부터 아이템 배열의 끝까지 모든 조합을 시도
        for (int i = startIndex; i < items.length; i++) {
            // 아이템을 현재 조합에 추가
            currentCombination.add(items[i]);
            
            // 재귀 호출을 통해 다음 아이템을 조합에 추가
            findMaxValue(items, maxWeight, i + 1, currentCombination, resultHashSet);
            
            // 현재 조합에서 마지막 아이템을 제거하여 다음 조합을 시도
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}

// 아이템 클래스: 무게와 가치를 가지고 있는 객체를 정의
class Item {
    int weight; // 아이템의 무게
    int value;  // 아이템의 가치

    // 생성자를 통해 아이템의 무게와 가치를 설정
    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}