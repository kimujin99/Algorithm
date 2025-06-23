class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 초 단위로 통일하여 계산
        int videoLenSec = toSeconds(video_len);
        int posSec = toSeconds(pos);
        int opStartSec = toSeconds(op_start);
        int opEndSec = toSeconds(op_end);
        
        // 시작값이 오프닝구간에 있는지 체크
        if(opStartSec <= posSec && posSec <= opEndSec) posSec = opEndSec;
        
        for(String command : commands) {
            if(command.equals("next")) {
                posSec = Math.min(posSec + 10, videoLenSec);
            } else {
               posSec = Math.max(posSec - 10, 0);
            }
            
            if(opStartSec <= posSec && posSec <= opEndSec) posSec = opEndSec;
        }
        
        return toTimeStr(posSec);
    }

    // 시간 문자열을 초단위로 변환
    public int toSeconds (String time) {
        int mm = Integer.parseInt(time.substring(0, 2));
        int ss = Integer.parseInt(time.substring(3, 5));
        return mm * 60 + ss;
    }
    
    // 초단위를 시간 문자열로 변환
    public String toTimeStr (int seconds) {
        int mm = seconds / 60;
        int ss = seconds % 60;
        return String.format("%02d:%02d", mm, ss);
    }
}