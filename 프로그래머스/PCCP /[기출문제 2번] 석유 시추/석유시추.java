import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int groupId = 2;
        int rowSize = 0;
        int maxSize = 0;
        Map<Integer, Integer> oilMap = new HashMap<>();
        
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(land[i][j] == 1) {
                    int size = bfs(land, i, j, groupId);
                    oilMap.put(groupId, size);
                    groupId++;
                }
            }
        }
        
        for(int i = 0; i < land[0].length; i++) {
            Map<Integer, Integer> selectedOilMap = new HashMap<>();
            for(int j = 0; j < land.length; j++) {
                if(land[j][i] > 0) {
                    selectedOilMap.put(land[j][i], oilMap.get(land[j][i]));
                }
            }
                    
            int sum = selectedOilMap.values().stream().mapToInt(Integer::intValue).sum();
            maxSize = Math.max(sum, maxSize);
        }
        
        return maxSize;
    }
    
    // 가까운 지점부터 탐색
    public int bfs(int[][] land, int startX, int startY, int id) {
        int n = land.length;
        int m = land[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 초기값 저장, 대체
        queue.offer(new int[]{startX, startY});
        land[startX][startY] = id;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(land[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
                        land[nx][ny] = id;
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
