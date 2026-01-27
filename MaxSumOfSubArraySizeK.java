class MaxSumOfSubArraySizeK {
    public static int findMaxSumSubArray(int K, int[] arr) {
        int i=0, j=0, sum=0, maxSum=Integer.MIN_VALUE;

        while (j < arr.length) {
            sum += arr[j];

            if(j-i+1 < K){
                j++;
            } else if( j-i+1 == K){
                maxSum = Math.max(maxSum, sum);
                sum -= arr[i];
                j++;
                i++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int K = 3;
        int result = findMaxSumSubArray(K, arr);
        System.out.println("Maximum sum of a subarray of size " + K + " is: " + result); // Output: 9
    }
}