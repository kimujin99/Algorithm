import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        // key : 배열 숫자, value : 카운트
        HashMap<Integer, Integer> countMap = new HashMap<>();
        Arrays.stream(array).forEach(num -> countMap.merge(num, 1, Integer::sum));

        // 최빈값 구하기
        int maxCount = 0;
        int answer = -1;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                answer = entry.getKey();
            } else if (entry.getValue() == maxCount) {
                answer = -1;
            }
        }

        return answer;
    }
}