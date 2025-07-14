class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10; // *
        int right = 12; // #

        for(int number : numbers) {
            if(number == 0) number = 11;
            
            if(number == 1 || number == 4 || number == 7) {
                left = number;
                answer.append("L");
            } else if(number == 3 || number == 6 || number == 9) {
                right = number;
                answer.append("R");
            } else {
                int leftDistance = getDistance(left, number);
                int rightDistance = getDistance(right, number);
                
                if(leftDistance < rightDistance) {
                    left = number;
                    answer.append("L");
                } else if(leftDistance > rightDistance) {
                    right = number;
                    answer.append("R");
                } else {
                    if(hand.equals("left")) {
                        left = number;
                        answer.append("L");
                    } else {
                        right = number;
                        answer.append("R");
                    }
                }
            }
            
        }
        
        return answer.toString();
    }
    
    public int getDistance(int a, int b) {
        int ax = (a - 1) / 3;
        int ay = (a - 1) % 3;
        int bx = (b - 1) / 3;
        int by = (b - 1) % 3;

        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
}