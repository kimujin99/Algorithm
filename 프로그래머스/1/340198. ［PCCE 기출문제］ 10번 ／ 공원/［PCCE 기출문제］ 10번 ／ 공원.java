import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int h = park.length;
        int w = park[0].length;
        int result = -1;
        
        List<int[]> positions = new ArrayList<>();
        
        // 빈 자리 리스트 생성
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if("-1".equals(park[i][j])) {
                    int[] arr = new int[] {i, j};
                    positions.add(arr);
                }
            }
        }
        
        // 매트 내림차순 정렬
        mats = Arrays.stream(mats)
            .boxed()
            .sorted((a, b) -> b - a)
            .mapToInt(Integer::intValue)
            .toArray();
        
        for(int[] position : positions) {
            int px = position[0];
            int py = position[1];
            
            for(int mat : mats) {
                if(h < px + mat || w < py + mat) continue;
                boolean isFit = true;
                
                for(int i = 0; i < mat; i++) {
                    for(int j = 0; j < mat; j++) {
                        int x = px + i;
                        int y = py + j;
                        
                        if(!"-1".equals(park[x][y])) isFit = false;
                        if(!isFit) break;
                    }
                    if(!isFit) break;
                }
                if(isFit) result = Math.max(result, mat);
            }
        }
        
        return result;
    }
}