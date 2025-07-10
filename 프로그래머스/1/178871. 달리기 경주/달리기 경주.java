import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }
        
        for(String calling : callings) {
            int idx = playerMap.get(calling);
            String frontPlayer = players[idx - 1];
            
            players[idx - 1] = calling;
            players[idx] = frontPlayer;
            
            playerMap.put(calling, idx - 1);
            playerMap.put(frontPlayer, idx);
        }
        
        return players;
    }
}