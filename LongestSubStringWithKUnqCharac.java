import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUnqCharac {
    
    public static int longestSubStringWithKUnqCharac(String text, int K){
        int i=0, j=0, max=Integer.MIN_VALUE;
        Map<Character, Integer> countMap = new HashMap<>();

        char[] charArray = text.toCharArray();

        while (j < charArray.length) {
            countMap.putIfAbsent(charArray[j], 0);
            countMap.put(charArray[j], countMap.get(charArray[j])+1);

            if (countMap.size() < K) {
                j++;
            } else if (countMap.size() == K) {
                max = max > j-i+1 ? max :j-i+1;
                j++;
            } else if (countMap.size() > K) {
                while (countMap.size() > K) {
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
    
    public static void main(String[] args) {
        String text = "aabacbebebe";
        int K = 3;
        int result = longestSubStringWithKUnqCharac(text, K);
        System.out.println("result : " +result);
    }
}
