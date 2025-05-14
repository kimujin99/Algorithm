class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] arr = my_string.toCharArray();
        
        for(int i = my_string.length(); i > 0; i--) {
            answer += arr[i - 1];
        }
        
        return answer;
    }
}