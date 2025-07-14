import java.time.*;
import java.time.format.*;
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termsMap = new HashMap<>();
        for(String term : terms) {
            String[] arr = term.split(" ");
            termsMap.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        List<Integer> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate nowDate = LocalDate.parse(today, formatter);
        
        for(int i = 1; i <= privacies.length; i++) {
            String[] arr = privacies[i-1].split(" ");
            String dateStr = arr[0];
            String plan = arr[1];

            LocalDate date = LocalDate.parse(dateStr, formatter);
            LocalDate expDate = date.plusMonths(termsMap.get(plan));
            if(nowDate.isAfter(expDate) || nowDate.isEqual(expDate)) result.add(i);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}