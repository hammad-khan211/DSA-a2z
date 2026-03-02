    import java.util.*;
    class SpiralMatrix
    {
        static List < Integer > printSpiralMatrix(int[][] matrix)//Time O(n*m)                                                     
        {                                                         //Space O(n*m) in case of list otherwise O(1) if printed directly
            int n = matrix.length;
            int m = matrix[0].length;
            int left = 0;
            int right = m - 1;
            int top = 0;
            int bottom = n - 1;
            List < Integer > nums = new ArrayList<>();

            while(top <= bottom && left <= right)
            {
                //right
                for(int i = left ; i <= right ; i++)
                {
                    nums.add(matrix[top][i]);
                }
                top++;


                //bottom
                for(int i = top ; i <= bottom ; i++)
                {
                    nums.add(matrix[i][right]);
                    
                }
                right--;


                //left
                if(top <= bottom)
                {
                    for(int i = right ; i >= left ; i--)
                    {
                        nums.add(matrix[bottom][i]);
                    
                    }
                    bottom--;
                }

                //top
                if(left <= right)
                {
                    for(int i = bottom ; i >= top ; i--)
                    {
                        nums.add(matrix[i][left]);
                    
                    }
                    left++;
                }    
            }
            return nums;
        }
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of rows of the matrix : ");
            int n = sc.nextInt();
            System.out.println("Enter the number of columns for rach row : ");
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            System.out.println("Enter the " + (n*m) + " number of array elements : ");
            for(int i = 0 ; i < n ; i++)
            {
                for(int j = 0 ; j < m ; j++)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            List < Integer > result = printSpiralMatrix(arr);
            for(int x : result)
            {
                System.out.print(x + " ");
            }

        }
    }