import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] result = new String[quiz.length];
        
        for(int i = 0; i < quiz.length; i++) {
            String expression = quiz[i].split(" = ")[0];
            int originAnswer = Integer.parseInt(quiz[i].split(" = ")[1]);
            int correctAnswer = 0;
            
            if(expression.contains(" + ")) {
                int x = Integer.parseInt(expression.split(" \\+ ")[0]);
                int y = Integer.parseInt(expression.split(" \\+ ")[1]);
                correctAnswer = x + y;
            } else {
                int x = Integer.parseInt(expression.split(" \\- ")[0]);
                int y = Integer.parseInt(expression.split(" \\- ")[1]);
                correctAnswer = x - y;
            }
            
            if(originAnswer == correctAnswer) result[i] = "O";
            else result[i] = "X";
        }

        return result;
    }
}