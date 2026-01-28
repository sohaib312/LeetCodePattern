import java.util.Arrays;

class FirstNegativeIntForEachK {
    public static int[] findFirstNegativeInt(int K, int[] arr) {
        int i=0, j=0, minSum=0;
        int[] result = new int[arr.length - K + 1];

        while (j < arr.length) {
            minSum = arr[j];

            if(j-i+1 < K){
                j++;
            } else if( j-i+1 == K){
                minSum = Math.min(arr[i], minSum);
                result[i] = minSum < 0 ? minSum : 0;
                j++;
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int K = 2;
        int[] result = findFirstNegativeInt(K, arr);
        System.out.println("First negative integers in each subarray of size " + K + " are: " + Arrays.toString(result)); // Output: [-8, -6, -6, 0]
    }
}