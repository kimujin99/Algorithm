class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9_.-]", "");
        // 3단계
        new_id = new_id.replaceAll("[.]{2,}", ".");
        // 4단계
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        // 5단계
        if("".equals(new_id)) new_id = "a";
        // 6단계
        if(new_id.length() > 15) new_id = new_id.substring(0, 15);
        new_id = new_id.replaceAll("[.]$", "");
        // 7단계
        if(new_id.length() < 3) {
            while(new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        
        return new_id;
    }
}