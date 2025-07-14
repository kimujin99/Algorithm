class Solution {
    public int[] solution(String[] wallpaper) {
        int top = 49, bottom = 0, left = 49, right = 0;
        
        for(int i = 0; i < wallpaper.length; i++) {
            String target = wallpaper[i];
            if(target.contains("#")) {
                top = Math.min(top, i);
                bottom = Math.max(bottom, i);
                left = Math.min(left, target.indexOf("#"));
                right = Math.max(right, target.lastIndexOf("#"));
            }
        }
        
        return new int[] {top, left, bottom + 1, right + 1};
    }
}