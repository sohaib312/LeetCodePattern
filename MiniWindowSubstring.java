import java.util.HashMap;
import java.util.Map;

public class MiniWindowSubstring {
    public static int miniWindowSubString(String text1, String text2){
        int i=0, j=0;
        Map<Character, Integer> countMap = new HashMap<>();
        char[] subStrArray = text2.toCharArray();
        char[] strArray = text1.toCharArray();
        int count=0;
        int min = Integer.MAX_VALUE;

        for(char c : subStrArray){
            countMap.putIfAbsent(c, 0);
            countMap.put(c,countMap.get(c)+1);
        }

        count = countMap.size();

        while (j < strArray.length) {
            
            if(countMap.containsKey(strArray[j])){
                countMap.put(strArray[j], countMap.get(strArray[j]) - 1);
                if(countMap.get(strArray[j]) == 0){
                    count--; 
                }
            }

            if(count > 0){
                j++;
            } else if(count == 0){
                while (count == 0) {
                    min = min < j-i+1 ? min : j-i+1;

                    if(countMap.containsKey(strArray[i])){
                        countMap.put(strArray[i], countMap.get(strArray[i]) + 1);
                        if(countMap.get(strArray[i]) == 1){
                            count++;
                        }
                    }
                    i++;
                }
                j++;
            }
        }

        return min;
    }

    public static void main(String[] args){
        String str1 = "ADOBECODEBANC";
        String str2 = "ABC";
        int result = miniWindowSubString(str1, str2);
        System.out.println("Result : " +result);
    }
}
