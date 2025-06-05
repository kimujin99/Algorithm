class Solution {
    public int solution(String A, String B) {
        if (B.equals(A)) return 0;
        
        int length = A.length();
        String temp = "";
        
        for(int i = 1; i < length; i++) {
            temp = A.substring(length-i, length) + A.substring(0, length-i);
            if(B.equals(temp)) {
                return i;
            }
        }
        
        return -1;
    }
}