class Solution {
    public int solution(int n, int w, int num) {
        // num의 좌표값 계산
        int y = (num - 1) / w;
        int x = 0;
        if (y % 2 == 0) { // 짝수층 (왼쪽→오른쪽)
            x = (num - 1) % w;
        } else { // 홀수층 (오른쪽→왼쪽)
            x = w - 1 - ((num - 1) % w);
        }
        
        // 개수 세기
        int h = (n + w - 1) / w; // 전체 층 수
        int answer = 0;
        for(int i = h - 1; i >= y; i--) {
            int boxnum = 0;
            int base = i * w + 1;
            
            if(base > n) continue;
            
            if(i % 2 == 0) {
                int idx = x;
                boxnum = base + idx;
            } else {
                int idx = w - 1 - x;
                boxnum = base + idx;
            }
            
            if(boxnum > n) continue;
            answer++;
        }
        
        return answer;
    }
}