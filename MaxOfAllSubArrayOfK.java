
public class MaxOfAllSubArrayOfK {
    public static int[] maxOfAllSubArrayOfK(int[] arr, int K){
        int i=0, j=0;
        int max=0;
        int[] ans = new int[arr.length - K +1];

        while (j < arr.length){
            max = max > arr[j] ? max : arr[j];

            if(j-i+1 < K){
                j++;
            } else if(j-i+1 == K){
                ans[i] = max;
                i++;
                j++;
            }

        }

        return ans;
    }
    
    
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int K = 3;
        int[] result = maxOfAllSubArrayOfK(arr, K);
        System.out.print("Maximums of all subarrays of size " + K + " are: ");
        for(int num : result){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
