class Solution {
    public int[] solution(long n) {
        long number = n;
        int size = String.valueOf(number).length();
        int[] answer = new int[size]; 
        
        for (int i = 0; i < size; i++) {
            answer[i] = (int) (number % 10);
            number /= 10;
        }
        
        return answer;
    }
}