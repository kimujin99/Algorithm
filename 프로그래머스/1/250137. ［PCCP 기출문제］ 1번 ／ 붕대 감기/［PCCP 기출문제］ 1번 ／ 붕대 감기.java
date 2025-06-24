class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int time = 0;
        
        for(int[] attack : attacks) {
            // 공격 당하기 전 누적 치유
            int combo = attack[0] - time - 1;
            hp = Math.min(hp + combo * bandage[1], health); // 초당 치유
            hp = Math.min(hp + (combo / bandage[0]) * bandage[2], health); // 추가 치유
            time = attack[0]; 
            // 공격
            hp = Math.max(hp - attack[1], 0);
            
            if (hp == 0) {
                hp = -1;
                break;
            }
        }

        return hp;
    }
}