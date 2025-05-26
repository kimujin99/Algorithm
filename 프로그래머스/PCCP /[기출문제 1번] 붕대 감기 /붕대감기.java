class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int nowHealth = health;
        int combo = 0;
        
        int skillTime = bandage[0];
        int heal = bandage[1];
        int additionalHeal = bandage[2];
        
        // 0 ~ 마지막 공격시간까지
        for(int i = 0; i <= attacks[attacks.length-1][0]; i++) {
            int damage = 0;
            for(int[] attack : attacks) {
                if(attack[0] == i) damage = attack[1];
            }
            
            // 회복
            // 최대 체력이상 회복 X, 공격받으면 회복 X
            if(damage > 0) {
                if(nowHealth - damage <= 0) return -1;
                nowHealth -= damage;
                combo = 0;
            } else {
                nowHealth = Math.min(nowHealth + heal, health);
                combo++;
                
                // 콤보가 차면 추가 회복
                if(combo == skillTime) {
                    nowHealth = Math.min(nowHealth + additionalHeal, health);
                    combo = 0;
                }
            }
        }
        
        return nowHealth;
    }
}
