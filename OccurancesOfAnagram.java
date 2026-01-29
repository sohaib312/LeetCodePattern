import java.util.HashMap;
import java.util.Map;

class OccurancesOfAnagram {
    public static int countAnagramOccurances(String text, String ptr){
        char[] ptrArr = ptr.toCharArray();
        char[] textArr = text.toCharArray();     
        int k = ptr.length();   
        int count=0, sum=0;
        int i=0, j=0;
        
        Map<Character, Integer> ptrFreqMap = new HashMap<>();
        
        for(char c : ptrArr){
            ptrFreqMap.putIfAbsent(c, 0);
            ptrFreqMap.put(c, ptrFreqMap.get(c) + 1);
        }

        count = ptrFreqMap.size();

        while( j < textArr.length) {
            if(ptrFreqMap.containsKey(textArr[j])){
                ptrFreqMap.put(textArr[j], ptrFreqMap.get(textArr[j]) - 1);
                if(ptrFreqMap.get(textArr[j]) == 0){
                    count--;
                }
            }

            if(j-i+1 < k){
                j++;
            } else if (j-i+1 == k) {
                if (count == 0) {
                    sum += 1;
                }
                if(ptrFreqMap.containsKey(textArr[i])){
                    ptrFreqMap.put(textArr[i], ptrFreqMap.get(textArr[i]) + 1);
                    if(ptrFreqMap.get(textArr[i]) == 1){
                        count++;
                    }
                }
                j++;
                i++;
            }

        }


        return sum;
    }
    
    
    public static void main(String[] args) {
        String text = "aabaabaa";
        String pattern = "aaba";
        int result = countAnagramOccurances(text, pattern);
        System.out.println("Number of anagram occurrences of the pattern in the text is: " + result);
    }
}
