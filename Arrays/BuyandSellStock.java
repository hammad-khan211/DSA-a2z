// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Example 1:

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

// Example 2:

// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.

import java.util.Scanner;
class BuyandSellStock
{
    static int maxProfit(int[] nums)
    {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int profit = 0;
        int maximumProfit = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] < min)
            {
                min = nums[i];
            }
            else{
                profit = nums[i] - min;
                maximumProfit = Math.max(maximumProfit , profit);
            }
        }
        return maximumProfit;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter the " + size + " number of array elements : ");
        for(int i = 0 ; i < size ; i++)
        {
            nums[i] = sc.nextInt();
        }
        int result = maxProfit(nums);
        System.out.println("Maximumm profit : " + result);
        sc.close();
    }
}