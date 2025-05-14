import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        // 옹알이
        String[] speakable = {"aya", "ye", "woo", "ma"};
        // 주어진 값
        List<String> OrgList = Arrays.asList(babbling);
        
        for(String org : OrgList) {
            String replaced = Arrays.stream(speakable)
                .reduce(org, (result, s) -> result.replace(s, "-"));
            
            replaced = replaced.replace("-", "");
            
            if(replaced.length() == 0) answer++;
        }

        return answer;
    }
}