import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> jisu = new HashMap<>();
        Map<String, Integer> forecast = new HashMap<>();
        for(String friend : friends) {
            jisu.put(friend, 0);
            forecast.put(friend, 0);
        }
        
        // 선물 지수 구하기
        for(String gift : gifts) {
            String[] arr = gift.split(" ");
            jisu.put(arr[0], jisu.get(arr[0]) + 1);
            jisu.put(arr[1], jisu.get(arr[1]) - 1);
        }
        
        // 선물 이력 비교하기 // 서로 한 번씩만 비교
        for(int i = 0; i < friends.length - 1; i++) {
            for(int j = i + 1; j < friends.length; j++) {
                String a = friends[i];
                String b = friends[j];
                int aCnt = 0;
                int bCnt = 0;

                for(String gift : gifts) {
                    String[] arr = gift.split(" ");
                    if(Arrays.asList(arr).contains(a) && Arrays.asList(arr).contains(b)) {
                        if(arr[0].equals(a)) aCnt++;
                        if(arr[0].equals(b)) bCnt++;   
                    }
                }
                
                if(aCnt > bCnt) {
                    forecast.put(a, forecast.get(a) + 1);
                } else if(aCnt < bCnt) {
                    forecast.put(b, forecast.get(b) + 1);
                } else {
                    if(jisu.get(a) > jisu.get(b)) forecast.put(a, forecast.get(a) + 1);
                    else if(jisu.get(a) < jisu.get(b)) forecast.put(b, forecast.get(b) + 1);
                }
            }
        }
        
        return Collections.max(forecast.values());
    }
}