package Top10;

import java.util.HashMap;
import java.util.Map;

public class CharCounter {
    public static Map<Character, Integer> countCharacters(String input){
        Map<Character, Integer> charCountMap = new HashMap<>();
        if (input == null) return charCountMap;

        for (char c : input.toCharArray()){
            if (charCountMap.containsKey(c)){
                charCountMap.put(c, charCountMap.get(c) + 1);
            }else{
                charCountMap.put(c,1);
            }
        }
        return charCountMap;
    }
    public static void main (String[] args) {
        String word = "banana";
        Map<Character, Integer> result = countCharacters(word);
        System.out.println("Character counts for " + word + ":");
        for (Map.Entry<Character, Integer> entry : result.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
