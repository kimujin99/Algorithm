import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int h = park.length;
        int w = park[0].length;

        // 매트 내림차순 정렬
        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            int mat = mats[i];
            for (int x = 0; x <= h - mat; x++) {
                for (int y = 0; y <= w - mat; y++) {
                    if (canPlace(park, x, y, mat)) {
                        return mat;  // 가장 큰 매트 가능 → 바로 리턴
                    }
                }
            }
        }
        return -1;
    }

    // 해당 위치에 매트를 놓을 수 있는지 확인하는 함수
    private boolean canPlace(String[][] park, int x, int y, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!"-1".equals(park[x + i][y + j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
