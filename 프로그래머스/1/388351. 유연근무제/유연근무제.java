class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < timelogs.length; i++) {
            int cnt = 0;
            
            for(int j = 0; j < 7; j++) {
                int today = (startday + j - 1) % 7 + 1;
                if(today != 6 && today != 7) { //주말제외
                    int checkMinutes = toMinutes(timelogs[i][j]);
                    int endMinutes = toMinutes(schedules[i]) + 10;
                    if(checkMinutes <= endMinutes) cnt++;
                }
            }
            if(cnt == 5) answer++;
        }
        
        return answer;
    }
    
    public int toMinutes(int time) {
        int hh = time / 100 * 60;
        int mm = time % 100;
        return hh + mm;
    }
}