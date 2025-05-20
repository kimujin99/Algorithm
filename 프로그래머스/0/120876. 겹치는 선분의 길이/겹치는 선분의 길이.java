class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] points = new int[201]; // -100~100 을 0~200으로 치환
        
        for(int[] line : lines) {
            int start = line[0] + 100;
            int end = line[1] + 100;
            
            for(int i = start; i < end; i++) { // 선분 구간은 start 이상 end 미만으로 계산해야함
                points[i]++;
            }
        }
        
        for(int count : points) {
            if(count >= 2) {
                answer++;
            }
        }
        return answer;
    }
}