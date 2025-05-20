class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int n = (total - ((num-1)*num/2))/num; // 등차수열의 합공식
        
        for(int i = 0; i < num; i++) {
            answer[i] = n + i;
        }
        
        return answer;
    }
}