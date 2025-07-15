package Top10;

public class PalindromeCheck {
    public static boolean isPalindrome(String text){
        if (text == null){
            return false;
        }
        String cleaned = text.replaceAll("\\s+","").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right){
            if (cleaned.charAt(left) != cleaned.charAt(right)){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
    public static void main (String[] args){
        System.out.println(isPalindrome("racecar"));
    }

}
