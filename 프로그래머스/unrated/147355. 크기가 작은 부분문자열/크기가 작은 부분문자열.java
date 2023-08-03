class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        long check = Long.parseLong(p);
        for (int i = 0; i < t.length() - len + 1; i++) {
            long sum = 0;
            double cal = Math.pow(10, len - 1);
            for (int j = i; j < i + len; j++) {
                sum += (t.charAt(j) - '0') * cal;
                cal /= 10;
            }
            if (sum <= check) answer++;
        }
        return answer;
    }
}