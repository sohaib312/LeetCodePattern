import java.util.HashMap;
import java.util.Map;


public class LongestSubStringWithoutRepeatingChar {
    
    public static int longestSubStringWithKUnqCharac(String text){
        int i=0, j=0, max=Integer.MIN_VALUE;
        char[] charArray = text.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();

        while (j < charArray.length) {
           countMap.putIfAbsent(charArray[j], 0) ;
           countMap.put(charArray[j], countMap.get(charArray[j])+1);

           if (countMap.size() == j-i+1) {
            max = max > j-i+1 ? max : j-i+1;
            j++;
           } else if (countMap.size() < j-i+1) {
            while (countMap.size() < j-i+1) {
                countMap.put(charArray[i], countMap.get(charArray[i])-1);
                if (countMap.get(charArray[i]) == 0) {
                        countMap.remove(charArray[i]);
                    }
                i++;
            }
            j++;
           }
        }

        return max;
    }
    
    public static void main(String[] args){
        String text = "pwwkew";
        int result = longestSubStringWithKUnqCharac(text);
        System.out.println("result : " +result);
    }
}
