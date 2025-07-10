class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        int col = 0, row = 0;

        for(int i = 0; i < h; i++) {
            if(park[i].contains("S")) {
                col = i;
                row = park[i].indexOf("S");
            }
        }
        
        for(String route : routes) {
            String[] routeArr = route.split(" ");
            String destination = routeArr[0];
            int distance = Integer.parseInt(routeArr[1]);
            int moveCol = 0, moveRow = 0;
            boolean canMove = true;
            
            switch (destination) {
                case "W" : moveRow = -1; break;
                case "E" : moveRow = 1; break;
                case "N" : moveCol = -1; break;
                case "S" : moveCol = 1; break;
            }
            
            for(int i = 1; i <= distance; i++) {
                int nowCol = col + i * moveCol;
                int nowRow = row + i * moveRow;

                if(nowCol < 0 || nowCol > h - 1 || nowRow < 0 || nowRow > w - 1) {
                    canMove = false;
                    break;
                }
                
                if(park[nowCol].charAt(nowRow) == 'X') {
                    canMove = false;
                    break;
                }
                
            }
            
            if(canMove) {
                col += distance * moveCol;
                row += distance * moveRow;
            }
        }
        
        return new int[] {col, row};
    }
}