import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        for(int i = 0; i < quiz.length; i++) {
            String[] arr = quiz[i].split(" ");
            int result = Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) * (arr[1].equals("+") ? 1 : -1);

            if (result == Integer.parseInt(arr[4])) quiz[i] = "O";
            else quiz[i] = "X";
        }
        return quiz;
    }
}