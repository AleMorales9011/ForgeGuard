package Top10;

public class StringReverse {
    public static String reverseManual(String text) {
        if (text == null) return null;
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        return reversed;
    }

    public static String reverseBuilder(String text) {
         if (text == null) return null;
         return new StringBuilder(text).reverse().toString();
    }

    public static void main (String[] args){
        String input = "hello";
        System.out.println("Manual: " + reverseBuilder(input));
        System.out.println("Builder: " + reverseBuilder(input));
    }
}

