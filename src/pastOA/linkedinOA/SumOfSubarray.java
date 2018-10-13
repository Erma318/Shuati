package pastOA.linkedinOA;

public class SumOfSubarray {

    public static long SubArraySum( int arr[] , int n )
    {
        long result = 0;

        // computing sum of subarray using formula
        for (int i=0; i<n; i++)
            result += (arr[i] * (i+1) * (n-i));

        // return all subarray sum
        return result ;
    }
}
