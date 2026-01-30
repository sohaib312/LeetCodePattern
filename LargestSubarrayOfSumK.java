public class LargestSubarrayOfSumK {
    public static int largestSubarray(int[] arr, int K){

        int i=0, j=0, sum =0, max=0;

        while (j < arr.length) {
            sum = sum + arr[j];
            
            if (sum < K ) {
                j++;
            } else if (sum == K) {
                max = max < j-i+1 ? j-i+1 : max;
                j++;
            } else if (sum > K) {
                while (sum > K) {
                    sum = sum - arr[i];
                    i++;
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
        int K = 5;
        int result = largestSubarray(arr, K);
        System.out.println("result : " +result);
    }
}
