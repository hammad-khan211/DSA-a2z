import java.util.*;
class HighestandLowestFreqElements{
    public static void main(String args[])
    {
        //declaration of array
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.println("Enter " + N + " numer of array elements : ");
        for(int i = 0 ; i < N ; i++)
        {
            arr[i] = sc.nextInt();
        }

        //precomputing
        HashMap < Integer , Integer > mpp = new HashMap<>();
        for(int i = 0 ; i < N ; i++)
        {
            mpp.put(arr[i] , mpp.getOrDefault(arr[i] , 0) + 1);
        }

        //finding highest and lowest occuring numbers
        int maxFreq = 0;
        int maxEle = 0;
        int minFreq = N;
        int minEle = 0;

        for(Map.Entry < Integer , Integer > entry : mpp.entrySet()) // iteration of HashMap
        {
            int element = entry.getKey(); 
            int freq = entry.getValue();

            if(freq > maxFreq)
            {
                maxFreq = freq;
                maxEle = element;

            }
            if(freq < minFreq)
            {
                minFreq = freq;
                minEle = element;
            }
        }

        //printing result
        System.out.println("Number with maximum occorunces : " + maxEle + " , occuring " + maxFreq +" times.");
        System.out.println("Number with minimum occorunces : " + minEle + " , occuring " + minFreq +" times.");

    







    }
}