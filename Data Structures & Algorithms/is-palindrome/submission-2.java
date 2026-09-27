class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = "";
        for(char c : s.toCharArray()){
            if(c!=' ' && (Character.isDigit(c)||Character.isLetter(c))) str+=c;
        }
        int left = 0;
        int right = str.length()-1;

        while(left<=right){
            if(str.charAt(left)!=str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
